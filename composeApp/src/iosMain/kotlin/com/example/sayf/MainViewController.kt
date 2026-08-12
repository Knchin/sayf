package com.example.sayf

import androidx.compose.ui.window.ComposeUIViewController
import UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    App()
}