package org.michaelbel.template.phonecalls.model

enum class CallType(
    val text: String
) {
    INCOMING("Incoming"),
    OUTGOING("Ongoing"),
    MISSED("Missed")
}