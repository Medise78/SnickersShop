package com.mahdi.snickersshop.presentation.signup_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdi.snickersshop.R
import com.mahdi.snickersshop.presentation.login_screen.component.TextFieldCustom


@ExperimentalComposeUiApi
@Composable
fun SignupScreen(
     onClickSignup: () -> Unit
) {
     Image(
          modifier = Modifier.fillMaxSize(),
          painter = painterResource(id = R.drawable.bacsign),
          contentDescription = "", contentScale = ContentScale.Crop
     )
     Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .height(530.dp)
                    .padding(start = 25.dp, end = 25.dp),
               shape = RoundedCornerShape(20.dp),
               elevation = 40.dp
          ) {

               Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()) {

                    Texttops()
                    TextFieldPhones()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldName()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldPasswords()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldConfirm()
                    Spacer(modifier = Modifier.height(15.dp))
                    ButtonSignups(onClickSignup = onClickSignup)
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                         Text(text = "Signup by",
                              style = TextStyle(color = Color(color = 0xFFFF8901)),
                              fontSize = 10.sp,
                              modifier = Modifier.clickable { })
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    google()
               }
          }
     }
}


@Composable
fun Texttops() {
     Row(
          Modifier
               .fillMaxWidth()
               .height(85.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
     ) {
          Text(
               modifier = Modifier.fillMaxWidth(.72f),
               text = "Signup",
               fontSize = 35.sp,
               fontWeight = FontWeight(20),
               style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
               )
          )
     }
}

@ExperimentalComposeUiApi
@Composable
fun TextFieldPhones() {
     val textPhone = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "PhoneNumber",
          text = textPhone.value,
          textChange = { textPhone.value = it },
          painter = painterResource(id = R.drawable.phone),
          keyboardType = KeyboardType.Text
     )
}

@ExperimentalComposeUiApi
@Composable
fun TextFieldName() {
     val textPhone = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "Name",
          text = textPhone.value,
          textChange = { textPhone.value = it },
          painter = painterResource(id = R.drawable.person),
          keyboardType = KeyboardType.Text
     )
}

@ExperimentalComposeUiApi
@Composable
fun TextFieldPasswords() {
     val textPhone = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "Password",
          text = textPhone.value,
          textChange = { textPhone.value = it },
          painter = painterResource(id = R.drawable.password),
          keyboardType = KeyboardType.Text
     )
}

@ExperimentalComposeUiApi
@Composable
fun TextFieldConfirm() {
     val textPhone = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "Confirm",
          text = textPhone.value,
          textChange = { textPhone.value = it },
          painter = painterResource(id = R.drawable.confirm),
          keyboardType = KeyboardType.Text
     )
}

@Composable
fun ButtonSignups(
     onClickSignup: () -> Unit,
) {
     Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
     ) {
          Button(
               onClick = onClickSignup,
               shape = RoundedCornerShape(20.dp),
               modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(64.dp)
                    .fillMaxWidth(.75f),
               elevation = ButtonDefaults.elevation(30.dp),
               colors = ButtonDefaults.buttonColors(backgroundColor = Color(color = 0xFFFF8901))
          ) {
               Text(
                    text = "Signup",
                    style = TextStyle(Color.White),
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
               )
          }
     }
}

@Composable
fun google() {
     Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
          Image(
               modifier = Modifier
                    .width(15.dp)
                    .height(15.dp)
                    .clickable {},
               painter = painterResource(id = R.drawable.google480),
               contentDescription = ""
          )
          Spacer(modifier = Modifier.width(10.dp))
          Image(
               modifier = Modifier
                    .width(15.dp)
                    .height(15.dp)
                    .clickable {},
               painter = painterResource(id = R.drawable.facebook480),
               contentDescription = ""
          )
          Spacer(modifier = Modifier.width(10.dp))
          Image(
               modifier = Modifier
                    .width(15.dp)
                    .height(15.dp)
                    .clickable {},
               painter = painterResource(id = R.drawable.twitter480),
               contentDescription = ""
          )
     }
}