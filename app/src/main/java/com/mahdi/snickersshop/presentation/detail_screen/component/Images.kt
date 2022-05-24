package com.mahdi.snickersshop.presentation.detail_screen.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mahdi.snickersshop.PageScreen
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.presentation.fake_model.ListItems
import com.mahdi.snickersshop.presentation.fake_model.ListItems2
import java.text.DecimalFormat

private val amountDecimalFormat = DecimalFormat("#,###.##")
fun formatAmount(amount: Float): String {
     return amountDecimalFormat.format(amount)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Images(navHostController: NavHostController) {
     var items by remember {
          mutableStateOf((1..20).map {
               ListItems(selected = false)
          })
     }
     Box(modifier = Modifier.fillMaxSize()) {
          Column(modifier = Modifier.fillMaxSize()) {

               LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    content = {
                         items(items.size) { index ->
                              ImageItemDetailScreen(
                                   navHostController = navHostController,
                                   onClick = {
                                        items =
                                             items.mapIndexed { i, listItems ->
                                                  if (i == index) {
                                                       listItems.copy(selected = true)
                                                       if (i == index && listItems.selected) {
                                                            listItems.copy(
                                                                 selected = false
                                                            )
                                                       } else {
                                                            listItems.copy(
                                                                 selected = true
                                                            )
                                                       }
                                                  } else {
                                                       listItems
                                                  }
                                             }
                                   },
                                   boolean = items[index].selected
                              )
                         }
                    })
               Text(
                    text = "Long T-Shirt:",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 5.dp, start = 15.dp)
               )
               Text(
                    text = "$" + formatAmount(99.9f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 0.dp, start = 15.dp)
               )
          }
     }
}