package com.example.hshop.constants

object PaymentMethods {
    const val CREDIT_CARD = "CREDIT_CARD"
    const val DEBIT_CARD = "DEBIT_CARD"
    const val PAYPAL = "PAYPAL"
    const val CASH_ON_DELIVERY = "CASH_ON_DELIVERY"

    val ALL = listOf(CREDIT_CARD, DEBIT_CARD, PAYPAL, CASH_ON_DELIVERY)
}