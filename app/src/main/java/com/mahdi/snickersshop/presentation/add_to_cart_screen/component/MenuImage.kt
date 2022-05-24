package com.mahdi.snickersshop.presentation.add_to_cart_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.Screen
import com.mahdi.snickersshop.ui.theme.Orange

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MenuImage(navHostController: NavHostController) {

     val pagerState = rememberPagerState(4)

     Card(
          modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(0.89f)
               .padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
          shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
     ) {
          Box(
               modifier = Modifier
                    .fillMaxSize()
          ) {
               HorizontalPager(
                    state = pagerState
               ) { page ->
                    when (page) {
                         0 -> {
                              Image(
                                   painter = painterResource(id = R.drawable.s2),
                                   contentDescription = "",
                                   contentScale = ContentScale.Crop,
                                   modifier = Modifier.fillMaxSize()
                              )
                         }
                         1 -> {
                              Image(
                                   painter = painterResource(id = R.drawable.s3),
                                   contentDescription = "",
                                   contentScale = ContentScale.Crop,
                                   modifier = Modifier.fillMaxSize()
                              )
                         }
                         2 -> {
                              Image(
                                   painter = painterResource(id = R.drawable.s10),
                                   contentDescription = "",
                                   contentScale = ContentScale.Crop,
                                   modifier = Modifier.fillMaxSize()
                              )
                         }
                         3 -> {
                              Image(
                                   painter = painterResource(id = R.drawable.s2),
                                   contentDescription = "",
                                   contentScale = ContentScale.Crop,
                                   modifier = Modifier.fillMaxSize()
                              )
                         }
                    }
               }
               HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                         .padding(top = 20.dp, start = 23.dp),
                    activeColor = Orange,
                    inactiveColor = Color.White,
               )
          }
     }
     Box(
          modifier = Modifier
               .fillMaxSize()
               .padding(30.dp),
          contentAlignment = Alignment.TopEnd
     ) {
          Row(modifier = Modifier.fillMaxWidth()) {
               Box(
                    modifier = Modifier
                         .fillMaxSize()
                         .weight(1f)
               ) {
                    Surface(
                         modifier = Modifier
                              .size(50.dp)
                              .clickable {

                              },
                         color = Color.Transparent,
                         shape = CircleShape
                    ) {
                         IconButton(onClick = { navHostController.navigate(Screen.DetailScreen.route) }) {
                              Icon(
                                   painter = painterResource(id = R.drawable.left),
                                   contentDescription = "Arrow",
                                   modifier = Modifier.size(40.dp),
                                   tint = Color.Black.copy(0.7f)
                              )
                         }
                    }
               }
               Box(
                    modifier = Modifier
                         .fillMaxWidth()
                         .weight(1f)
                         .padding(top = 4.dp),
                    contentAlignment = Alignment.TopEnd
               ) {
                    Surface(
                         modifier = Modifier
                              .size(50.dp)
                              .border(
                                   1.dp,
                                   Color.Gray.copy(0.5f),
                                   shape = CircleShape
                              )
                              .clickable {

                              },
                         color = Color.White,
                         shape = CircleShape
                    ) {
                         IconButton(onClick = {

                         }) {
                              Icon(
                                   imageVector = Icons.Default.Favorite,
                                   contentDescription = "favorite",
                                   modifier = Modifier
                                        .size(22.dp),
                                   tint = Color.Red
                              )
                         }
                    }
               }
          }
          Box(
               modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),
               contentAlignment = Alignment.BottomCenter
          ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                         painter = painterResource(id = R.drawable.up_arrow),
                         contentDescription = "up_arrow",
                         tint = Color.White.copy(0.8f),
                         modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                         text = "Swipe up for details",
                         style = MaterialTheme.typography.body1,
                         color = Color.White.copy(1f)
                    )
               }
          }
     }
}