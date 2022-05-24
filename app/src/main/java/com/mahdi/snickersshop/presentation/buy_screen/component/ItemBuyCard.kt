package com.mahdi.snickersshop.presentation.buy_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdi.snickersshop.R

@Composable
fun ItemBuyCard(
     painter: Int,
     title: String,
     price: String,
     size: String
) {
     var counter by remember {
          mutableStateOf(0)
     }
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .height(110.dp)
               .padding(horizontal = 20.dp),
          elevation = 0.dp,
          shape = RoundedCornerShape(
               topStart = 10.dp,
               topEnd = 10.dp,
               bottomStart = 1.dp,
               bottomEnd = 1.dp
          )
     ) {
          Row {
               Box(modifier = Modifier.padding(5.dp)) {
                    Surface(
                         shape = RoundedCornerShape(10.dp)
                    ) {
                         Image(
                              painter = painterResource(id = painter),
                              contentDescription = null,
                              contentScale = ContentScale.Crop,
                              modifier = Modifier
                                   .height(150.dp)
                                   .width(100.dp)
                         )
                    }
               }
               Column {
                    Box(
                         modifier = Modifier
                              .fillMaxWidth()
                              .padding(start = 5.dp)
                    ) {
                         Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                              Spacer(modifier = Modifier.height(5.dp))
                              Text(
                                   text = title,
                                   style = MaterialTheme.typography.h1,
                                   fontWeight = FontWeight.Bold
                              )
                              Spacer(modifier = Modifier.height(5.dp))
                              Text(
                                   text = "$$price",
                                   style = MaterialTheme.typography.h1,
                                   fontWeight = FontWeight.Bold
                              )
                              Spacer(modifier = Modifier.height(11.dp))
                              Row(
                                   verticalAlignment = Alignment.CenterVertically,
                                   horizontalArrangement = Arrangement.spacedBy(
                                        10.dp
                                   )
                              ) {
                                   Icon(
                                        painter = painterResource(id = R.drawable.plus),
                                        contentDescription = null,
                                        modifier = Modifier
                                             .size(20.dp)
                                             .clickable {
                                                  if (counter < 10) {
                                                       counter++
                                                  }
                                             }
                                   )
                                   Text(
                                        text = "$counter",
                                        style = MaterialTheme.typography.h1,
                                        modifier = Modifier.padding(top = 3.dp)
                                   )
                                   Icon(
                                        painter = painterResource(id = R.drawable.minus),
                                        contentDescription = null,
                                        modifier = Modifier
                                             .size(20.dp)
                                             .clickable {
                                                  if (counter > 0) {
                                                       counter--
                                                  }
                                             }
                                   )
                              }
                         }
                         Box(
                              modifier = Modifier.fillMaxWidth(),
                              contentAlignment = Alignment.CenterEnd
                         ) {
                              Column {
                                   Box(
                                        modifier = Modifier
                                             .fillMaxSize()
                                             .weight(1f)
                                             .padding(end = 27.dp, top = 8.dp),
                                        contentAlignment = Alignment.TopEnd
                                   ) {
                                        Text(
                                             text = size,
                                             style = MaterialTheme.typography.h5,
                                             color = Color.Black.copy(0.3f),
                                             fontSize = 18.sp
                                        )
                                   }
                                   Box(
                                        modifier = Modifier
                                             .fillMaxSize()
                                             .weight(1f)
                                             .padding(
                                                  end = 20.dp,
                                                  bottom = 8.dp
                                             ),
                                        contentAlignment = Alignment.BottomEnd
                                   ) {
                                        Icon(
                                             painter = painterResource(id = R.drawable.delete11),
                                             contentDescription = "delete",
                                             tint = Color.Red.copy(0.5f),
                                             modifier = Modifier.size(28.dp)
                                        )
                                   }

                              }
                         }
                    }
               }
          }
     }
}