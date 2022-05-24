package com.mahdi.snickersshop.presentation.detail_screen.component



import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mahdi.snickersshop.presentation.fake_model.Category
import com.mahdi.snickersshop.presentation.fake_model.Menu
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun DetailScreen(navHostController: NavHostController) {

     val lazyListState = rememberLazyListState()
     val scope = rememberCoroutineScope()
     val catList = listOf(
          Category("Nike", 1),
          Category("Adidas", 2),
          Category("Puma", 3),
          Category("Shoes", 4),
     )
     val menu = Menu(catList, emptyList())
     Box(modifier = Modifier
          .fillMaxSize()
          .background(Color.Black)) {
          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.89f)
                    .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
               ,
               shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
          ) {

               Box(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                         Spacer(modifier = Modifier.height(20.dp))
                         TopBar()
                         Spacer(modifier = Modifier.height(15.dp))
                         Text(
                              text = "Find your",
                              style = MaterialTheme.typography.h1,
                              modifier = Modifier.padding(start = 22.dp),
                              fontSize = 24.sp,
                              fontWeight = FontWeight.Bold
                         )
                         Text(
                              text = "match style!",
                              style = MaterialTheme.typography.body1,
                              fontSize = 23.sp,
                              fontWeight = FontWeight.Black,
                              modifier = Modifier.padding(start = 22.dp)
                         )
                         Spacer(modifier = Modifier.height(15.dp))
                         CategoryTab(
                              categories = catList,
                              selectedCategory = lazyListState.firstVisibleItemIndex.getCategory(menu),
                              onCategorySelected = { category ->
                                   scope.launch { lazyListState.scrollToItem(category.getIndex(menu)) }
                              })
                         Images(navHostController)

                    }
               }
          }
     }
}

private fun Int.getCategory(menu: Menu): Category {
     return menu.categories.last { it.getIndex(menu) <= this }
}

private fun Category.getIndex(menu: Menu): Int {
     var index = 0
     for (i in 0 until menu.categories.indexOf(this)) {
          index += 1
          index += menu.menuItems.filter { it.id == menu.categories[i].id }.size
     }
     return index
}