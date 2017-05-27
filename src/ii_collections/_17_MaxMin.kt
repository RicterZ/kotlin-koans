package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    return this.customers.maxBy { it.orders.count() }
    // Return a customer whose order count is the highest among all customers
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    val a = this.orders.map { it.products.maxBy { it.price } }
    return a.firstOrNull()
    // Return the most expensive product which has been ordered
}
