package com.fpenim.groceries.services

import com.fpenim.groceries.model.Quantity
import com.fpenim.groceries.model.Recipe
import com.fpenim.groceries.model.splitByMetricUnit
import com.fpenim.groceries.model.sum
import org.slf4j.LoggerFactory

class ShoppingListService {

    fun getShoppingList(recipes: List<Recipe>): List<Pair<String, List<Quantity>>> {

        return getIngredients(recipes)
                .mapNotNull {
                    try {
                        it.key to it.value.splitByMetricUnit().map { list -> list.sum() }
                    } catch (e: IllegalArgumentException) {
                        logger.info("${it.key} has empty list of quantities ${it.value}", e)
                        null
                    }
                }
    }

    fun getIngredients(recipes: List<Recipe>): Map<String, MutableList<Quantity>> {

        val shoppingList = mutableMapOf<String, MutableList<Quantity>>()

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

    companion object {
        private val logger = LoggerFactory.getLogger(ShoppingListService::class.java)
    }

}
