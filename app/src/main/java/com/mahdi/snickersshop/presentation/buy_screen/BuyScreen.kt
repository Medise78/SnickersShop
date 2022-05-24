package com.mahdi.snickersshop.presentation.buy_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mahdi.snickersshop.presentation.buy_screen.component.ItemBuyCard
import com.mahdi.snickersshop.presentation.buy_screen.component.ItemBuyTopBar
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.presentation.add_to_cart_screen.formatAmount
import com.mahdi.snickersshop.ui.theme.Orange

@Composable
fun BuyScreen(navHostController: NavHostController) {
     Box(modifier = Modifier.fillMaxSize()) {
          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.89f)
                    .padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
               shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
          ) {
               Column {
                    Box(
                         modifier = Modifier
                              .fillMaxSize()
                              .weight(1.8f)
                    ) {
                         Column {
                              ItemBuyTopBar(5, navHostController)
                              Spacer(modifier = Modifier.height(25.dp))
                              LazyColumn() {
                                   items(5) {
                                        ItemBuyCard(
                                             painter = R.drawable.s3,
                                             title = "Nike Air MAx",
                                             price = formatAmount(65.5f),
                                             size = "L"
                                        )
                                        Spacer(modifier = Modifier.height(15.dp))
                                   }
                              }
                         }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(
                         modifier = Modifier
                              .fillMaxSize()
                              .weight(1.2f)
                              .padding(horizontal = 30.dp)
                    ) {
                         Column {
                              SubTotalPayment(
                                   subPay = 209.5f,
                                   text = "Sub total:",
                                   color = Color.Black
                              )

                              Spacer(modifier = Modifier.height(15.dp))

                              SubTotalPayment(
                                   subPay = 5.5f,
                                   text = "Shipping:",
                                   color = Color.Black
                              )

                              Spacer(modifier = Modifier.height(18.dp))

                              Divider(color = Color.Black.copy(0.15f))

                              Spacer(modifier = Modifier.height(12.dp))

                              SubTotalPayment(subPay = 216f, text = "Bag Total:", color = Orange)

                              Spacer(modifier = Modifier.height(25.dp))

                              Button(
                                   onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                                        Orange
                                   ), modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                        .clip(
                                             RoundedCornerShape(10.dp)
                                        )
                              ) {
                                   Text(
                                        text = "Checkout",
                                        color = Color.White,
                                        style = MaterialTheme.typography.h1,
                                        fontWeight = FontWeight.Bold
                                   )
                              }
                         }
                    }
               }
          }
     }
}

@Composable
fun SubTotalPayment(subPay: Float, text: String, color: Color) {
     Row(modifier = Modifier.fillMaxWidth()) {
          Box(
               modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 5.dp)
          ) {
               Text(
                    text = text,
                    color = Color.Black.copy(0.3f),
                    style = MaterialTheme.typography.h1,
               )
          }
          Box(
               modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
               contentAlignment = Alignment.CenterEnd
          ) {
               Text(
                    text = "$" + formatAmount(subPay),
                    color = color,
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
               )
          }
     }
}