package com.mahdi.snickersshop.presentation.add_to_cart_screen.detail_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mahdi.snickersshop.presentation.fake_model.SizeShoes
import com.mahdi.snickersshop.ui.theme.Orange

private enum class SelectSize { SELECT, UNSELECT }

@Composable
fun SizeCategory(
     onSelectBtn: () -> Unit,
     onUnselectedBtn: () -> Unit
) {
     var sizeList by remember {
          mutableStateOf(
               (0..6).map {
                    SizeShoes(
                         listOf(5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0)
                    )
               }
          )
     }
     Row(modifier = Modifier.fillMaxWidth()) {
          LazyRow {
               items(sizeList.size) { index ->
                    Card(
                         modifier = Modifier
                              .size(90.dp)
                              .padding(15.dp),
                         elevation = 20.dp,
                         shape = RoundedCornerShape(10.dp)
                    ) {
                         TextButton(
                              onClick = {
                                        sizeList = sizeList.mapIndexed { i, sizeShoes ->
                                             if (i == index) {
                                                  sizeShoes.copy(selected = true)
                                                  if (i == index && sizeShoes.selected) {
                                                       sizeShoes.copy(selected = false)
                                                  } else {
                                                       sizeShoes.copy(selected = true)
                                                  }
                                             } else {
                                                  sizeShoes
                                             }
                                        }
                              },
                              modifier = Modifier
                                   .fillMaxSize()
                                   .background(if (sizeList[index].selected) Orange else Color.Transparent),
                         ) {
                              when(index){
                                   0 ->{
                                        Text(text = "5.5", color = Color.Black)
                                   }
                                   1 ->{
                                        Text(text = "6.0", color = Color.Black)
                                   }
                                   2 ->{
                                        Text(text = "6.5", color = Color.Black)
                                   }
                                   3 ->{
                                        Text(text = "7.0", color = Color.Black)
                                   }
                                   4 ->{
                                        Text(text = "7.5", color = Color.Black)
                                   }
                                   5 ->{
                                        Text(text = "8.0", color = Color.Black)
                                   }
                                   6 ->{
                                        Text(text = "8.5", color = Color.Black)
                                   }
                              }
                         }
                    }
               }
          }
     }
}