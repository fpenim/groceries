package com.fpenim.groceries.services


import com.fpenim.groceries.RecipesHelper.cream
import com.fpenim.groceries.RecipesHelper.pastaCarbonara
import com.fpenim.groceries.RecipesHelper.spaghettiGamberini
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShoppingListServiceTest {

    private val service = ShoppingListService()

    @Test
    internal fun getListFromOneRecipe() {
        val shoppingList = service.getShoppingList(listOf(pastaCarbonara))

        assertEquals(3, shoppingList.size)
        assertEquals(3, shoppingList.values.flatten().size)
    }

    @Test
    internal fun getListFromTwoRecipes() {
        val shoppingList = service.getShoppingList(listOf(pastaCarbonara, spaghettiGamberini))

        assertEquals(7, shoppingList.size)
        assertEquals(8, shoppingList.values.flatten().size)

        assertEquals(2, shoppingList[cream.name]?.size)

        println(shoppingList)

        //assertNotEquals(shoppingList[cream.name]?.get(0)?.measure, shoppingList[cream.name]?.get(1)?.measure)
    }


}