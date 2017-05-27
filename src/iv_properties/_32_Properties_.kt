package iv_properties

import util.TODO
import util.doc32

class PropertyExample() {
    var counter = 0
    var _propertyWithCounter: Int? = null
    var propertyWithCounter: Int?
        get() = this._propertyWithCounter
        set(value) {
            this.counter ++
            this._propertyWithCounter = value
        }
}

fun todoTask32(): Nothing = TODO(
    """
        Task 32.
        Add a custom setter to PropertyExample.propertyWithCounter so that
        the 'counter' property is incremented every time 'propertyWithCounter' is assigned to.
    """,
    documentation = doc32(),
    references = { PropertyExample() }
)
