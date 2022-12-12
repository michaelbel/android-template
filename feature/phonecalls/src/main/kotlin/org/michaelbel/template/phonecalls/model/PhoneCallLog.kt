package org.michaelbel.template.phonecalls.model

data class PhoneCallLog(
    val number: String,
    val type: Int,
    val date: String,
    val duration: Int
)