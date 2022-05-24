package com.mahdi.snickersshop

sealed class PageScreen(var route: String) {
     object AddtoCartScreen : PageScreen("add_screen")
     object LoginScreen : PageScreen("login_screen")
     object SignUpScreen : PageScreen("signup_screen")
     object SplashScreen : PageScreen("splash_screen")
     object HomeScreen : PageScreen("home_screen")
}
