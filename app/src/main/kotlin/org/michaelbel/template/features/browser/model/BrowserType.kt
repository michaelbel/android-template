package org.michaelbel.template.features.browser.model

sealed class BrowserType
object Browser: BrowserType()
object InAppBrowser: BrowserType()