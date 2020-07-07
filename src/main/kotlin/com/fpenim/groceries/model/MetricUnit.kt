package com.fpenim.groceries.model

interface MetricUnit {
    val multiplier: Int
    val symbol: String
}

enum class Volume(
        override val multiplier: Int,
        override val symbol: String
): MetricUnit {
    LITRE(1, "l"),
    DECILITRE(10, "dl"),
    CENTILITRE(100, "cl"),
    MILLILITRE(1000, "ml")
}

enum class Mass(
        override val multiplier: Int,
        override val symbol: String
): MetricUnit {
    KILOGRAM(1, "kg"),
    GRAM(1000, "g")
}

enum class Count(
        override val multiplier: Int,
        override val symbol: String
): MetricUnit {
    COUNT(1, "")
}