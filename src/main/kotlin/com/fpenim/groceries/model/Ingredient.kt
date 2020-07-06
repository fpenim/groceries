package com.fpenim.groceries.model

data class Ingredient(
        val name: String,
        val tags: Set<String> = setOf(name),
        val favourite: Boolean = false
)