package com.fpenim.inmypantry.model

data class Ingredient(
        val name: String,
        val tags: Set<String> = setOf(name),
        val favourite: Boolean = false
)