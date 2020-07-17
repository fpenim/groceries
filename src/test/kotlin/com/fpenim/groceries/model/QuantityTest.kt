package com.fpenim.groceries.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class QuantityTest {

    @Test
    internal fun sumVolumes() {
        val result = volumes.sum()

        assertEquals(2.2, result.value)
        assertEquals(Volume.LITRE, result.unit)
    }

    @Test
    internal fun sumMasses() {
        val result = masses.sum()

        assertEquals(1.0, result.value)
        assertEquals(Mass.KILOGRAM, result.unit)
    }

    @Test
    internal fun sumIncompatibleQuantities() {
        val e = assertThrows<IllegalArgumentException> {
            incompatibleQuantities.sum()
        }

        assertEquals("All quantities must be compatible.", e.message)
    }

    @Test
    internal fun splitByMetricUnitEmptyList() {
        assertTrue(emptyList<Quantity>().splitByMetricUnit().isEmpty())
    }

    @Test
    internal fun splitByMetricUnitOnlyVolumes() {
        val result = volumes.splitByMetricUnit()

        assertEquals(1, result.size)
        assertEquals(3, result.first().size)
    }

    @Test
    internal fun splitByMetricUnitMix() {
        val result = incompatibleQuantities.splitByMetricUnit()

        assertEquals(3, result.size)

        assertEquals(5, result.find { it.first().unit is Volume }?.size)
        assertEquals(2, result.find { it.first().unit is Mass }?.size)
        assertEquals(1, result.find { it.first().unit is Count }?.size)
    }

    companion object {
        private val volumes = mutableListOf(
                Quantity(200.0, Volume.MILLILITRE),
                Quantity(100.0, Volume.CENTILITRE),
                Quantity(10.0, Volume.DECILITRE)
        )
        private val masses = mutableListOf(
                Quantity(0.5, Mass.KILOGRAM),
                Quantity(500.0, Mass.GRAM)
        )
        private val incompatibleQuantities = mutableListOf(
                Quantity(200.0, Volume.MILLILITRE),
                Quantity(100.0, Volume.CENTILITRE),
                Quantity(10.0, Volume.DECILITRE),
                Quantity(0.5, Mass.KILOGRAM),
                Quantity(500.0, Mass.GRAM),
                Quantity(200.0, Volume.MILLILITRE),
                Quantity(100.0, Volume.MILLILITRE),
                Quantity(2.0, Count.COUNT)
        )
    }
}
