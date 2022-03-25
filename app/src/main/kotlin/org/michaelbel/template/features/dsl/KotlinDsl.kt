package org.michaelbel.template.features.dsl

data class User(
    var log: Log? = null,
    var location: Location? = null,
    var number: String = ""
) {
    fun number(lambda: () -> String) {
        this.number = lambda()
    }
}

data class Log(
    var key: String = "",
    var value: String = ""
) {
    fun key(lambda: () -> String) {
        this.key = lambda()
    }

    fun value(lambda: () -> String) {
        this.value = lambda()
    }
}

data class Location(
    var lat: String = "",
    var long: String = ""
) {
    fun lat(lambda: () -> String) {
        this.lat = lambda()
    }

    fun long(lambda: () -> String) {
        this.long = lambda()
    }
}

fun user(lambda: User.() -> Unit): User {
    val user = User()
    user.apply(lambda)
    return user
}

fun log(lambda: Log.() -> Unit): Log {
    val log = Log()
    log.apply(lambda)
    return log
}

fun location(lambda: Location.() -> Unit): Location {
    val location = Location()
    location.apply(lambda)
    return location
}

val user = user {
    log = log {
        key { "my_key" }
        value { "My Value" }
    }
    location = location {
        lat { "40.0" }
        long { "30.0" }
    }
    number { "534" }
}