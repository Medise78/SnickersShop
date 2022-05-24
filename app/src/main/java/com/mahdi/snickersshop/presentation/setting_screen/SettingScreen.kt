package com.mahdi.snickersshop.presentation.setting_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mahdi.snickersshop.presentation.setting_screen.component.CardTop
import com.mahdi.snickersshop.presentation.setting_screen.component.RowItems

@Composable
fun SettingScreen() {
     Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
          Card(
               modifier = Modifier.height(520.dp),
               shape = RoundedCornerShape(topEnd = 0.dp, topStart = 0.dp)
          ) {
               Column(modifier = Modifier.background(color = Color(0xFFf3f4fd))) {
                    Spacer(modifier = Modifier.height(55.dp))
                    RowItems()
               }
          }
     }
     CardTop()
}