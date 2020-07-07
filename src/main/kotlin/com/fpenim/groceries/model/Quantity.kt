package com.fpenim.groceries.model

data class Quantity(val value: Double, val unit: MetricUnit) {

    fun printName(): String {
        return "$value ${unit.symbol}"
    }

    fun isCompatibleWith(quantities: List<Quantity>): Boolean = quantities.all { this.unit::class.java == it.unit::class.java }
}

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