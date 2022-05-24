package com.mahdi.snickersshop.presentation.setting_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdi.snickersshop.R


@Composable
fun RowItems() {
     Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Top,
          horizontalAlignment = Alignment.CenterHorizontally
     ) {
          Items(
               painterStart = painterResource(id = R.drawable.password),
               text = "Change Password ",
               painterEnd = painterResource(id = R.drawable.go),
               onClick = {}
          )
          Spacer(modifier = Modifier.height(2.dp))
          Items(
               painterStart = painterResource(id = R.drawable.payment),
               text = "Payment",
               painterEnd = painterResource(id = R.drawable.go),
               onClick = {}
          )
          Spacer(modifier = Modifier.height(2.dp))
          Items(
               painterStart = painterResource(id = R.drawable.mobile),
               text = "Nexus Mobile",
               painterEnd = painterResource(id = R.drawable.go),
               onClick = {}
          )
          Spacer(modifier = Modifier.height(2.dp))
          Items(
               painterStart = painterResource(id = R.drawable.country),
               text = "Country",
               painterEnd = painterResource(id = R.drawable.go),
               onClick = {}
          )
          Spacer(modifier = Modifier.height(2.dp))
          Items(
               painterStart = painterResource(id = R.drawable.delivery),
               text = "Delivery Address",
               painterEnd = painterResource(id = R.drawable.go),
               onClick = {}
          )
          Spacer(modifier = Modifier.height(2.dp))
          ItemEnd(
               painterStart = painterResource(id = R.drawable.logout2),
               text = "Logout",
               onClick = {}
          )
     }
}

@Composable
fun Items(
     painterStart: Painter,
     text: String,
     painterEnd: Painter,
     onClick: () -> Unit
) {
     Row(
          modifier = Modifier
               .fillMaxWidth()
               .height(50.dp)
               .clickable(onClick = onClick),
          verticalAlignment = Alignment.CenterVertically,
     ) {
          Spacer(modifier = Modifier.width(20.dp))
          Row(
               Modifier.width(50.dp),
               horizontalArrangement = Arrangement.Center,
               verticalAlignment = Alignment.CenterVertically
          ) {
               Image(
                    modifier = Modifier.size(size = 25.dp),
                    painter = painterStart,
                    contentDescription = ""
               )
          }
          Spacer(modifier = Modifier.width(5.dp))
          Row(Modifier.fillMaxWidth()) {
               Text(
                    text = text,
                    style = TextStyle(color = Color.Black),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.5.sp,
               )
               Box(
                    Modifier
                         .fillMaxWidth()
                         .padding(end = 25.dp),
                    contentAlignment = Alignment.CenterEnd
               ) {
                    Icon(
                         painter = painterEnd,
                         contentDescription = "",
                         modifier = Modifier.size(20.dp),
                         tint = Color.Black.copy(0.5f)
                    )
               }
          }
     }
}

@Composable
fun ItemEnd(
     painterStart: Painter,
     text: String,
     onClick: () -> Unit
) {
     Row(
          modifier = Modifier
               .clickable(onClick = onClick)
               .fillMaxWidth()
               .height(50.dp),
          verticalAlignment = Alignment.CenterVertically,
     ) {
          Spacer(modifier = Modifier.width(20.dp))
          Row(
               Modifier
                    .width(50.dp)
                    .padding(end = 5.dp),
               horizontalArrangement = Arrangement.Center
          ) {
               Icon(
                    modifier = Modifier
                         .size(size = 25.dp)
                         .rotate(degrees = 180f),
                    painter = painterStart,
                    contentDescription = "",
                    tint = Color.Red
               )
          }
          Spacer(modifier = Modifier.width(5.dp))
          Row(Modifier.fillMaxWidth(.9f)) {
               Text(
                    text = text,
                    style = TextStyle(color = Color.Black),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.5.sp,
                    color = Color.Red
               )
          }
     }
}