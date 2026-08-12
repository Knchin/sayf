package com.example.sayf

import androidx.compose.ui.platform.web.WebComposeApp
import org.w3c.dom.Element

fun main() {
    WebComposeApp(
        rootElement = document.getElementById("root") as Element,
        content = ::App
    )
}