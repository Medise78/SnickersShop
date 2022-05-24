package com.mahdi.snickersshop.presentation.detail_screen.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mahdi.snickersshop.screens
import com.mahdi.snickersshop.ui.theme.Orange

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(navHostController: NavController,bottomBarStatus:MutableState<Boolean>) {

     val items = screens
     val navBackStackEntry by navHostController.currentBackStackEntryAsState()
     val currentRoute = navBackStackEntry?.destination?.route

     AnimatedVisibility(visible = bottomBarStatus.value) {
          BottomNavigation(backgroundColor = Color.Black, modifier = Modifier.height(83.dp)) {
               items.forEach { item ->
                    BottomNavigationItem(
                         icon = {
                              Column {
                                   if (item.badge > 0) {
                                        BadgeBox(badgeContent = {
                                             Text(text = item.badge.toString())
                                        }) {
                                             if (currentRoute == item.route) {
                                                  Box(
                                                       modifier = Modifier
                                                            .size(50.dp)
                                                            .clip(CircleShape)
                                                            .background(Orange),
                                                       contentAlignment = Alignment.Center
                                                  ) {
                                                       Icon(
                                                            painter = painterResource(id = item.icon),
                                                            contentDescription = "",
                                                            modifier = Modifier.size(23.dp),
                                                       )
                                                  }
                                             } else {
                                                  Icon(
                                                       painter = painterResource(id = item.icon),
                                                       contentDescription = "",
                                                       modifier = Modifier.size(23.dp),
                                                  )
                                             }
                                        }
                                   } else {
                                        if (currentRoute == item.route) {
                                             Box(
                                                  modifier = Modifier
                                                       .size(50.dp)
                                                       .clip(CircleShape)
                                                       .background(Orange),
                                                  contentAlignment = Alignment.Center
                                             ) {
                                                  Icon(
                                                       painter = painterResource(id = item.icon),
                                                       contentDescription = "",
                                                       modifier = Modifier.size(23.dp),
                                                  )
                                             }
                                        } else {

                                             Icon(
                                                  painter = painterResource(id = item.icon),
                                                  contentDescription = "",
                                                  modifier = Modifier.size(23.dp),
                                             )
                                        }

                                   }
                              }
                         },
                         selectedContentColor = Color.White,
                         unselectedContentColor = Color.White.copy(0.5f),
                         alwaysShowLabel = true,
                         selected = currentRoute == item.route,
                         onClick = {
                              navHostController.navigate(item.route)
                         },
                    )
               }
          }
     }

}