package com.mahdi.snickersshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.mahdi.snickersshop.presentation.detail_screen.MainScreen
import com.mahdi.snickersshop.presentation.login_screen.view_model.LoginViewModel
import com.mahdi.snickersshop.ui.theme.SnickersShopTheme

class MainActivity : ComponentActivity() {
     @ExperimentalComposeUiApi
     @ExperimentalAnimationApi
     @ExperimentalMaterialApi
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContent {
               SnickersShopTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                         val navController = rememberNavController()
                         MainScreen(navController, loginViewModel = LoginViewModel(application),this)
                    }
               }
          }
     }
}


