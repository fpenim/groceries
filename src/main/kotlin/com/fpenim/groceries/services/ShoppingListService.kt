package com.fpenim.groceries.services

import com.fpenim.groceries.model.Recipe
import javax.measure.Quantity

class ShoppingListService {

    fun getShoppingList(recipes: List<Recipe>): Map<String, MutableList<Quantity<*>>> {

        val shoppingList = mutableMapOf<String, MutableList<Quantity<*>>>()

        recipes.forEach { recipe ->
            recipe.ingredients.forEach { entry ->
                if (shoppingList.containsKey(entry.key.name)) {
                    shoppingList[entry.key.name]?.add(entry.value)
                } else {
                    shoppingList[entry.key.name] = mutableListOf(entry.value)
                }
            }
        }

        return shoppingList
    }

}