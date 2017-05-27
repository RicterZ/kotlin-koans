package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter {
        it.orders.any {
            it.products.contains(product)
        }
    }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    val orders = this.orders.filter { it.isDelivered }
    val ordered_order = orders.map { it.products.maxBy { it.price } }
    return ordered_order.firstOrNull()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers.map {
        it.orders.map { it.products.count { it == product } }.sum()
    }.sum()
}
