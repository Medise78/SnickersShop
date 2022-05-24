package com.mahdi.snickersshop.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mahdi.snickersshop.presentation.home_screen.component.HomeImage

@Composable
fun HomeScreen(navHostController: NavHostController) {
     Box(modifier = Modifier.fillMaxSize()) {
          HomeImage(navHostController)
     }
}