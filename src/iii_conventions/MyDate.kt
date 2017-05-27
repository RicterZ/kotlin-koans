package iii_conventions

import java.sql.Time


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        val y = this.year - other.year
        val m = this.month - other.month
        val d = this.dayOfMonth - other.dayOfMonth
        if (y == 0) {
            if (m == 0) {
                return d
            } else {
                return m
            }
        } else {
            return y
        }
    }

    operator fun plus(ti: TimeInterval): MyDate {
        return this.plus(iii_conventions.RepeatTimeInterval(ti, 1))
    }

    operator fun plus(rti: RepeatTimeInterval): MyDate {
        return this.addTimeIntervals(rti.ti, rti.n)
    }

    operator fun rangeTo(other: MyDate): DateRange {
        return DateRange(this, other)
    }



}


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(n: Int): RepeatTimeInterval {
    return RepeatTimeInterval(this, n)
}


class RepeatTimeInterval(val ti: TimeInterval, val n: Int = 1)


class IteratorMyDate(val range: DateRange): Iterator<MyDate> {
    var now: MyDate

    init {
        this.now = this.range.start
    }

    override fun hasNext(): Boolean {
        return this.range.endInclusive >= this.now
    }

    override fun next(): MyDate {
        val ret = this.now
        this.now = this.now.nextDay()
        return ret
    }
}

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {

    override operator fun iterator(): IteratorMyDate {
        return IteratorMyDate(this)
    }

    operator fun contains(other: MyDate): Boolean {
        if (other.year < start.year || other.year > endInclusive.year) {
            return false
        }
        if (other.year == start.year && other.month < start.month) {
            return false
        }
        if (other.year == endInclusive.year && other.month > endInclusive.month) {
            return false
        }
        if (other.month == start.month && other.dayOfMonth < start.dayOfMonth) {
            return false
        }
        if (other.month == endInclusive.month && other.dayOfMonth > endInclusive.dayOfMonth) {
            return false
        }
        return true
    }
}
