package org.michaelbel.template.phonecalls.model

data class PhoneCallLog(
    val number: String,
    val type: CallType,
    val date: String,
    val duration: Int
)