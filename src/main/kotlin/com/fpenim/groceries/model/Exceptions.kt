package com.fpenim.groceries.model

import java.lang.Exception

abstract class QuantityException(message: String): Exception(message)

class UnsupportedQuantityException(message: String): QuantityException(message)

class IncompatibleQuantityException(message: String): QuantityException(message)