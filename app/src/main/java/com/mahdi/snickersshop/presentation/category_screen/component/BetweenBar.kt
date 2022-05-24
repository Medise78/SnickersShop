package com.mahdi.snickersshop.presentation.category_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mahdi.snickersshop.R

@Composable
fun BetweenBar() {
     Box(
          modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(0.1f)
               .background(Color.White)
     ) {
          Row(modifier = Modifier.fillMaxWidth()) {
               Spacer(modifier = Modifier.width(12.dp))
               Box(
                    modifier = Modifier
                         .fillMaxWidth()
                         .weight(0.45f)
                         .fillMaxHeight(), contentAlignment = Alignment.CenterStart
               ) {
                    IconButton(onClick = { }) {

                         Icon(
                              painter = painterResource(id = R.drawable.left),
                              contentDescription = "Arrow",
                              modifier = Modifier.size(45.dp)
                         )
                    }
               }
               Box(
                    modifier = Modifier
                         .fillMaxWidth()
                         .weight(0.2f)
                         .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
               ) {
                    IconButton(onClick = { }) {
                         Icon(
                              painter = painterResource(id = R.drawable.glass),
                              contentDescription = "Search",
                              modifier = Modifier.size(35.dp)
                         )
                    }
               }
               Spacer(modifier = Modifier.width(10.dp))
               Box(
                    modifier = Modifier
                         .fillMaxWidth()
                         .weight(0.05f)
                         .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
               ) {
                    IconButton(onClick = { }) {
                         Icon(
                              painter = painterResource(id = R.drawable.bag),
                              contentDescription = "Buy",
                              modifier = Modifier.size(32.dp)
                         )
                    }
               }
               Spacer(modifier = Modifier.width(15.dp))
          }
     }
}