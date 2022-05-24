package com.mahdi.snickersshop.presentation.add_to_cart_screen

import android.content.res.Resources
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mahdi.snickersshop.PageScreen
import com.mahdi.snickersshop.Screen
import com.mahdi.snickersshop.presentation.add_to_cart_screen.component.DraggableCardSimple
import com.mahdi.snickersshop.presentation.add_to_cart_screen.detail_component.ImageViewPager
import com.mahdi.snickersshop.presentation.add_to_cart_screen.draggable_viewmodel.DragViewModel
import com.mahdi.snickersshop.presentation.add_to_cart_screen.draggable_viewmodel.model.CardModel
import com.mahdi.snickersshop.ui.theme.Orange
import java.text.DecimalFormat

private val amountDecimalFormat = DecimalFormat("#,###.##")
fun formatAmount(amount: Float): String {
     return amountDecimalFormat.format(amount)
}

const val CARD_HEIGHT = 56
const val CARD_OFFSET = -480f
fun Float.dp(): Float = this * density + 0.5f
val density: Float
     get() = Resources.getSystem().displayMetrics.density

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddtoCartScreen(
     viewModel: DragViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
     navHostController: NavHostController
) {
     val revealedCardIds = viewModel.revealedCardIdsList.collectAsState()
     val id = CardModel().id

     Column(modifier = Modifier.fillMaxSize()) {
          Box(modifier = Modifier.fillMaxSize()) {
               Box(modifier = Modifier.fillMaxSize()) {

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                         ImageViewPager()
                    }
                    DraggableCardSimple(
                         cardHeight = CARD_HEIGHT.dp,
                         isRevealed = revealedCardIds.value.contains(id),
                         cardOffset = CARD_OFFSET.dp(),
                         onExpand = { viewModel.onItemExpanded(id) },
                         onCollapse = { viewModel.onItemCollapsed(id) },
                         navHostController = navHostController
                    )
               }
               Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                         Box(
                              modifier = Modifier
                                   .fillMaxWidth()
                                   .weight(1f)
                                   .padding(start = 30.dp, top = 18.dp)
                         ) {
                              Column {
                                   Text(
                                        text = "Sub total",
                                        style = MaterialTheme.typography.h1,
                                        color = Color.White.copy(0.5f)
                                   )
                                   Text(
                                        text = "$" + formatAmount(69.5f),
                                        style = MaterialTheme.typography.h1,
                                        color = Color.White,
                                        fontSize = 25.sp, modifier = Modifier.padding(start = 3.dp)
                                   )
                              }
                         }
                         Box(
                              modifier = Modifier
                                   .fillMaxWidth()
                                   .weight(1f)
                                   .padding(end = 30.dp, top = 25.dp),
                              contentAlignment = Alignment.CenterEnd
                         ) {
                              Button(
                                   onClick = { navHostController.navigate(Screen.CartScreen.route) },
                                   colors = ButtonDefaults.buttonColors(Orange),
                                   modifier = Modifier
                                        .height(45.dp)
                                        .width(150.dp), shape = RoundedCornerShape(10.dp)
                              ) {
                                   Text(
                                        text = "Add to Cart",
                                        color = Color.White,
                                        style = MaterialTheme.typography.button,
                                        textAlign = TextAlign.Center
                                   )
                              }
                         }
                    }
               }
          }
     }
}