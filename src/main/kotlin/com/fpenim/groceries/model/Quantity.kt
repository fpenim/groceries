package com.fpenim.groceries.model

data class Quantity(val value: Double, val unit: MetricUnit) {

    fun printName(): String {
        return "$value ${unit.symbol}"
    }

    /**
     * Compatibility is based on units being convertible between each other.
     *
     * - Litre and millilitre are both Volume metrics - they are compatible.
     * - Kilogram is a Mass metric and decilitre is a Volume metric - they are incompatible.
     */
    fun isCompatibleWith(quantities: List<Quantity>): Boolean = quantities.all { this.unit::class.java == it.unit::class.java }
}

/**
 * TODO
 */
fun MutableList<Quantity>.sum(): Quantity {

    if (this.isEmpty()) {
        throw IllegalArgumentException("List of quantities can't be empty.")
    }

    if (!this.first().isCompatibleWith(this)) {
        throw IllegalArgumentException("All quantities must be compatible.")
    }

    val unit: MetricUnit = when(this.first().unit) {
        is Volume -> Volume.LITRE
        is Mass -> Mass.KILOGRAM
        is Count -> Count.COUNT
        else -> throw IllegalArgumentException("Invalid metric unit.")
    }

    var sum = 0.0
    for (element in this) {
        sum += element.value.div(element.unit.multiplier)
    }

    return Quantity(sum, unit)
}