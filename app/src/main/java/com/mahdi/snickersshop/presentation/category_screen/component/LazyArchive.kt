package com.mahdi.snickersshop.presentation.category_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.presentation.fake_model.ListItems

@Composable
fun LazyArchive(
//    categories: List<Cat>,
//    selectedCategory: Category,
//    onCategorySelected: (Category) -> Unit
) {

     var items by remember {
          mutableStateOf((1..10).map {
               ListItems(selected = false)
          })
     }
     val image1: Int = R.drawable.pic1
     val image2: Int = R.drawable.pic2
     val image3: Int = R.drawable.pic3

     Box(
          modifier = Modifier
               .fillMaxSize()
               .background(Color.White)
     ) {

          LazyRow(contentPadding = PaddingValues(8.dp)) {
               items(items.size, itemContent = { item ->
                    when (item) {
                         0 -> {
                              CardArchive(image = image2, text = " New \nArrival" )
                         }
                         1 -> {
                              CardArchive(image = image1, text = " New \nArrival")
                         }
                         2 -> {
                              CardArchive(image = image3, text = "New \nArrival")
                         }
                    }
               })
          }
     }
}

@Composable
fun CardArchive(image: Int, text: String , ) {
     Card(
          modifier = Modifier
               .width(320.dp)
               .height(370.dp)
               .padding(15.dp), shape = RoundedCornerShape(15.dp)
     ) {

          Box(modifier = Modifier.fillMaxSize().clickable {}) {
               Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
               )
               Box(
                    modifier = Modifier
                         .fillMaxHeight()
                         .fillMaxWidth()
                         .padding(bottom = 50.dp),
                    contentAlignment = Alignment.BottomCenter,
               ) {
                    Text(
                         text = text,
                         fontSize = 52.sp,
                         color = Color.Black,
                         style = MaterialTheme.typography.h1,
                         fontWeight = FontWeight.SemiBold,
                         textAlign = TextAlign.Center
                    )
               }
          }
     }
}