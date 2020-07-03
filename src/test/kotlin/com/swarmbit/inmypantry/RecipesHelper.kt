package com.swarmbit.inmypantry

import com.swarmbit.inmypantry.model.Ingredient
import com.swarmbit.inmypantry.model.Recipe
import tec.units.ri.AbstractUnit.ONE
import tec.units.ri.quantity.Quantities
import tec.units.ri.unit.Units.GRAM
import tec.units.ri.unit.Units.LITRE


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
                    tagliatelle to Quantities.getQuantity(180, GRAM),
                    cream to Quantities.getQuantity(0.2, LITRE),
                    bacon to Quantities.getQuantity(100, GRAM)
            )
    )

    internal val spaghettiGamberini = Recipe(
            name = "Spaghetti Gamberini",
            portions = 4,
            ingredients = mutableMapOf(
                    spaghetti to Quantities.getQuantity(180, GRAM),
                    cookedShrimp to Quantities.getQuantity(400, GRAM),
                    cream to Quantities.getQuantity(0.05, LITRE),
                    oliveOil to Quantities.getQuantity(0.03, LITRE),
                    garlic to Quantities.getQuantity(2, ONE)
            )
    )
}