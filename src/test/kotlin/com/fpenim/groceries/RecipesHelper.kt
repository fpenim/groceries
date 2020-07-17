package com.fpenim.groceries

import com.fpenim.groceries.model.Count
import com.fpenim.groceries.model.Ingredient
import com.fpenim.groceries.model.Mass
import com.fpenim.groceries.model.Quantity
import com.fpenim.groceries.model.Recipe
import com.fpenim.groceries.model.Volume

object RecipesHelper {

    internal val tagliatelle = Ingredient("Tagliatelle")
    internal val spaghetti = Ingredient("Spaghetti")
    internal val cream = Ingredient("Double cream")
    internal val bacon = Ingredient("Bacon")
    internal val cookedShrimp = Ingredient("Cooked shrimp")
    internal val oliveOil = Ingredient("Olive oil")
    internal val garlic = Ingredient("Garlic")

    internal val pastaCarbonara = Recipe(
            name = "Pasta Carbonara",
            portions = 2,
            ingredients = mutableMapOf(
                    tagliatelle to Quantity(180.0, Mass.GRAM),
                    cream to Quantity(200.0, Volume.MILLILITRE),
                    bacon to Quantity(100.0, Mass.GRAM)
            )
    )

    internal val spaghettiGamberini = Recipe(
            name = "Spaghetti Gamberini",
            portions = 4,
            ingredients = mutableMapOf(
                    spaghetti to Quantity(180.0, Mass.GRAM),
                    cookedShrimp to Quantity(0.4, Mass.KILOGRAM),
                    cream to Quantity(50.0, Volume.MILLILITRE),
                    oliveOil to Quantity(30.0, Volume.MILLILITRE),
                    garlic to Quantity(2.0, Count.COUNT)
            )
    )

    internal val quiche = Recipe(
            name = "Quiche",
            portions = 2,
            ingredients = mutableMapOf(
                    cream to Quantity(200.0, Volume.MILLILITRE),
                    bacon to Quantity(2.0, Count.COUNT)
            )
    )
}
