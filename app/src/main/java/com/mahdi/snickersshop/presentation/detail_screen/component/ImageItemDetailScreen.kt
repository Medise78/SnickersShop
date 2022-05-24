package com.mahdi.snickersshop.presentation.detail_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
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
import com.mahdi.snickersshop.PageScreen
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.Screen

@Composable
fun ImageItemDetailScreen(navHostController: NavHostController, onClick: () -> Unit,boolean: Boolean) {
     Card(
          backgroundColor = Color.LightGray,
          modifier = Modifier
               .fillMaxWidth()
               .height(220.dp)
               .padding(12.dp)
               .clickable {
                    navHostController.navigate(PageScreen.AddtoCartScreen.route)
               },
          shape = RoundedCornerShape(15.dp)
     ) {
          Box(modifier = Modifier.fillMaxSize()) {
               Image(
                    painter = painterResource(id = R.drawable.s3),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
               )
               Box(
                    modifier = Modifier
                         .fillMaxSize()
                         .padding(15.dp),
                    contentAlignment = Alignment.TopEnd
               ) {
                    Surface(
                         modifier = Modifier
                              .size(40.dp)
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
                         IconButton(onClick = onClick) {
                              if (boolean) {
                                   Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favorite",
                                        modifier = Modifier
                                             .size(22.dp),
                                        tint = Color.Red
                                   )
                              } else {
                                   Icon(
                                        painter = painterResource(id = R.drawable.love),
                                        contentDescription = "favorite",
                                        modifier = Modifier
                                             .size(22.dp),
                                        tint = Color.Black
                                   )
                              }
                         }
                    }
               }
          }
     }
}