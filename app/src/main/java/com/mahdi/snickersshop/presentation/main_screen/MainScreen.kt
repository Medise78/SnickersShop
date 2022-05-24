package com.mahdi.snickersshop.presentation.detail_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.mahdi.snickersshop.PageScreen
import com.mahdi.snickersshop.Screen
import com.mahdi.snickersshop.UserInfo
import com.mahdi.snickersshop.presentation.detail_screen.component.BottomNavigationBar
import com.mahdi.snickersshop.presentation.detail_screen.component.DetailScreen
import com.mahdi.snickersshop.presentation.add_to_cart_screen.AddtoCartScreen
import com.mahdi.snickersshop.presentation.add_to_cart_screen.draggable_viewmodel.DragViewModel
import com.mahdi.snickersshop.presentation.buy_screen.BuyScreen
import com.mahdi.snickersshop.presentation.category_screen.CategoryScreen
import com.mahdi.snickersshop.presentation.home_screen.HomeScreen
import com.mahdi.snickersshop.presentation.login_screen.LoginScreen
import com.mahdi.snickersshop.presentation.login_screen.view_model.LoginViewModel
import com.mahdi.snickersshop.presentation.setting_screen.SettingScreen
import com.mahdi.snickersshop.presentation.signup_screen.SignupScreen
import com.mahdi.snickersshop.presentation.splash_screen.SplashScreen
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@OptIn(ExperimentalMaterialApi::class)
@ExperimentalAnimationApi
@Composable
fun MainScreen(
       navHostController : NavHostController ,
       loginViewModel : LoginViewModel ,
       context : Context ,
)
{
      val scaffoldState = rememberScaffoldState()
      val dragViewModel = DragViewModel()
      val bottomBarState = rememberSaveable {
            mutableStateOf(true)
      }
      val scope = rememberCoroutineScope()
      val loginState = loginViewModel.emailState.value
      val loginStatePass = loginViewModel.passwordState.value

      Scaffold(scaffoldState = scaffoldState , bottomBar = {
            if (currentRoute(navController = navHostController) != PageScreen.AddtoCartScreen.route)
            {
                  BottomNavigationBar(navHostController , bottomBarState)
            }
      }) {
            NavHost(
                  navController = navHostController ,
                  startDestination = PageScreen.SplashScreen.route
            ) {
                  composable(PageScreen.SplashScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = false
                              SplashScreen(navController = navHostController)
                        }
                  }
                  composable(PageScreen.LoginScreen.route) {
                        bottomBarState.value = false
                        LoginScreen(
                              onClickSignup = {
                                    navHostController.navigate(PageScreen.SignUpScreen.route)
                              } ,
                              onClickLogin = {
                                    navHostController.navigate(PageScreen.HomeScreen.route)

                              } ,
                              onClickForget = { /*TODO*/ } ,
                        )
                  }
                  composable(PageScreen.SignUpScreen.route) {
                        bottomBarState.value = false
                        SignupScreen(
                              onClickSignup = {
                                    navHostController.navigate(PageScreen.LoginScreen.route)
                              })
                  }
                  composable(PageScreen.HomeScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = false
                              HomeScreen(navHostController)
                        }
                  }
                  composable(Screen.CategoryScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = true
                              CategoryScreen()
                        }
                  }
                  composable(Screen.DetailScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = true
                              DetailScreen(navHostController = navHostController)
                        }
                  }
                  composable(Screen.CartScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = true
                              BuyScreen(navHostController)
                        }
                  }
                  composable(Screen.SettingScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = true
                              SettingScreen()
                        }
                  }
                  composable(PageScreen.AddtoCartScreen.route) {
                        Surface(color = Color.Black) {
                              bottomBarState.value = false
                              AddtoCartScreen(dragViewModel , navHostController)
                        }
                  }
            }
      }
}

@Composable
fun currentRoute(navController : NavHostController) : String?
{
      val navBackStackEntry by navController.currentBackStackEntryAsState()
      return navBackStackEntry?.destination?.route
}


