package com.mahdi.snickersshop.presentation.add_to_cart_screen.detail_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.mahdi.snickersshop.ui.theme.Orange
import java.math.BigDecimal

val formatStar = BigDecimal.valueOf(4.5)

@ExperimentalPagerApi
@Composable
fun ImageViewPager() {
     Column(
          modifier = Modifier
               .fillMaxSize()
               .padding(start = 7.dp, end = 7.dp, bottom = 42.dp, top = 66.dp)
     ) {
          Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
               Column {
                    Box(
                         modifier = Modifier
                              .fillMaxWidth()
                              .fillMaxHeight(0.8f)
                              .background(Color.White),
                    ) {
                         Column(
                              modifier = Modifier
                                   .fillMaxSize()
                                   .padding(top = 100.dp, start = 10.dp, end = 10.dp)
                         ) {
                              Row {
                                   Box(
                                        modifier = Modifier
                                             .fillMaxWidth()
                                             .weight(1f)
                                             .padding(11.dp),
                                        contentAlignment = Alignment.TopStart
                                   ) {
                                        Column {
                                             Text(
                                                  text = "Mens Shoe",
                                                  style = MaterialTheme.typography.body1,
                                                  color = Color.Black.copy(0.5f),
                                                  fontWeight = FontWeight.Bold,
                                                  fontSize = 13.sp,
                                             )
                                             Spacer(modifier = Modifier.height(10.dp))
                                             Text(
                                                  text = "Nike Air Max",
                                                  style = MaterialTheme.typography.h1,
                                                  color = Color.Black,
                                                  fontWeight = FontWeight.Bold,
                                                  fontSize = 17.sp
                                             )
                                        }
                                   }
                                   Box(
                                        modifier = Modifier
                                             .fillMaxWidth()
                                             .weight(1f)
                                             .padding(top = 14.dp, end = 35.dp),
                                        contentAlignment = Alignment.TopEnd
                                   ) {
                                        Row {
                                             Icon(
                                                  imageVector = Icons.Default.Star,
                                                  contentDescription = "Star",
                                                  tint = Orange,
                                                  modifier = Modifier.size(18.dp)
                                             )
                                             Spacer(modifier = Modifier.width(4.dp))
                                             Text(
                                                  text = "(${formatStar})",
                                                  style = MaterialTheme.typography.h6,
                                                  color = Color.Black.copy(0.3f),
                                                  fontSize = 11.sp,
                                                  modifier = Modifier.padding(top = 2.dp)
                                             )
                                        }
                                   }
                              }
                              Spacer(modifier = Modifier.height(10.dp))
                              Row(modifier = Modifier.fillMaxWidth()) {
                                   Box(
                                        modifier = Modifier
                                             .fillMaxWidth()
                                             .weight(1f)
                                             .padding(start = 11.dp)
                                   ) {
                                        Text(
                                             text = "Size:",
                                             style = MaterialTheme.typography.h1,
                                             fontWeight = FontWeight.Bold,
                                             color = Color.Black,
                                             fontSize = 13.sp
                                        )
                                   }
                                   Box(
                                        modifier = Modifier
                                             .fillMaxWidth()
                                             .weight(1f)
                                             .padding(end = 25.dp, bottom = 0.dp),
                                        contentAlignment = Alignment.TopEnd
                                   ) {
                                        Text(
                                             text = "Uk",
                                             style = MaterialTheme.typography.h1,
                                             color = Color.Black,
                                             fontSize = 13.sp
                                        )
                                   }
                              }
                              Box(modifier = Modifier.fillMaxWidth()) {
                                   SizeCategory(
                                        onSelectBtn = { /*TODO*/ },
                                        onUnselectedBtn = {})
                              }
                              Spacer(modifier = Modifier.height(10.dp))
                              Box(modifier = Modifier.fillMaxWidth()) {
                                   DescriptionExpanded(
                                        header = "Description",
                                        desc = "Nike Running Shoe"
                                   )
                              }
                              Divider()
                              Box(modifier = Modifier.fillMaxWidth()) {
                                   DescriptionExpanded(
                                        header = "Free Delivery And Returns",
                                        desc = "Nike Running Shoe"
                                   )
                              }
                         }
                    }
               }
          }
     }
}