package com.fpenim.groceries.services


import com.fpenim.groceries.RecipesHelper.bacon
import com.fpenim.groceries.RecipesHelper.cookedShrimp
import com.fpenim.groceries.RecipesHelper.cream
import com.fpenim.groceries.RecipesHelper.garlic
import com.fpenim.groceries.RecipesHelper.oliveOil
import com.fpenim.groceries.RecipesHelper.pastaCarbonara
import com.fpenim.groceries.RecipesHelper.spaghetti
import com.fpenim.groceries.RecipesHelper.spaghettiGamberini
import com.fpenim.groceries.RecipesHelper.tagliatelle
import com.fpenim.groceries.model.Count
import com.fpenim.groceries.model.Mass
import com.fpenim.groceries.model.Quantity
import com.fpenim.groceries.model.Volume
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShoppingListServiceTest {

    private val service = ShoppingListService()

    @Test
    internal fun getIngredientsFromOneRecipe() {
        val ingredients = service.getIngredients(listOf(pastaCarbonara))

        assertEquals(3, ingredients.size)
        assertEquals(3, ingredients.values.flatten().size)
    }

    @Test
    internal fun getIngredientsFromTwoRecipes() {
        val ingredients = service.getIngredients(listOf(pastaCarbonara, spaghettiGamberini))

        assertEquals(7, ingredients.size)
        assertEquals(8, ingredients.values.flatten().size)

        assertEquals(2, ingredients[cream.name]?.size)
    }

    @Test
    internal fun getShoppingListFromOneRecipe() {
        val shoppingList = service.getShoppingList(listOf(pastaCarbonara))

        assertEquals(3, shoppingList.size)

        assertEquals(Quantity(0.18, Mass.KILOGRAM), shoppingList.find { it.first == tagliatelle.name }?.second)
        assertEquals(Quantity(0.2, Volume.LITRE), shoppingList.find { it.first == cream.name }?.second)
        assertEquals(Quantity(0.1, Mass.KILOGRAM), shoppingList.find { it.first == bacon.name }?.second)
    }

    @Test
    internal fun getShoppingListFromTwoRecipes() {
        val shoppingList = service.getShoppingList(listOf(pastaCarbonara, spaghettiGamberini))

        assertEquals(7, shoppingList.size)

        assertEquals(Quantity(0.18, Mass.KILOGRAM), shoppingList.find { it.first == tagliatelle.name }?.second)
        assertEquals(Quantity(0.25, Volume.LITRE), shoppingList.find { it.first == cream.name }?.second)
        assertEquals(Quantity(0.1, Mass.KILOGRAM), shoppingList.find { it.first == bacon.name }?.second)
        assertEquals(Quantity(0.18, Mass.KILOGRAM), shoppingList.find { it.first == spaghetti.name }?.second)
        assertEquals(Quantity(0.4, Mass.KILOGRAM), shoppingList.find { it.first == cookedShrimp.name }?.second)
        assertEquals(Quantity(0.03, Volume.LITRE), shoppingList.find { it.first == oliveOil.name }?.second)
        assertEquals(Quantity(2.0, Count.COUNT), shoppingList.find { it.first == garlic.name }?.second)
    }
}