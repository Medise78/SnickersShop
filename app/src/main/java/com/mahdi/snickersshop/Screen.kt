package com.mahdi.snickersshop

sealed class Screen(var route: String, var icon: Int, var badge: Int = 0) {
     object CategoryScreen : Screen("category_screen", icon = R.drawable.home3)
     object DetailScreen : Screen("menu_screen", icon = R.drawable.apps)
     object CartScreen : Screen("cart_screen", icon = R.drawable.bag, badge = 23)
     object SettingScreen : Screen("setting_screen", icon = R.drawable.setting)
}

val screens = listOf(
     Screen.CategoryScreen,
     Screen.DetailScreen,
     Screen.CartScreen,
     Screen.SettingScreen
)
