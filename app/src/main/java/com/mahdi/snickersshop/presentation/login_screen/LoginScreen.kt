package com.mahdi.snickersshop.presentation.login_screen

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
import androidx.compose.ui.semantics.Role.Companion.Image
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
fun LoginScreen(
     onClickSignup: () -> Unit,
     onClickLogin: () -> Unit,
     onClickForget: () -> Unit,
) {
     androidx.compose.foundation.Image(
          modifier = Modifier.fillMaxSize(),
          painter = painterResource(id = R.drawable.bacsign),
          contentDescription = "", contentScale = ContentScale.Crop
     )
     Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)
                    .height(530.dp), shape = RoundedCornerShape(20.dp), elevation = 40.dp
          ) {
               Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()) {

                    Texttopl()
                    TextFieldPhonel()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldPasswordl()
                    Spacer(modifier = Modifier.height(15.dp))
                    Forget(onClickForget = onClickForget)
                    Spacer(modifier = Modifier.height(15.dp))
                    ButtonLogin(onClickLogin = onClickLogin)
                    Spacer(modifier = Modifier.height(15.dp))
                    ButtonSignupl(onClickSignup = onClickSignup)
                    contage()
               }
          }
     }
}

@Composable
fun Texttopl() {
     Row(
          Modifier
               .fillMaxWidth()
               .height(85.dp)
               .padding(top = 0.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
     ) {
          Text(
               modifier = Modifier.fillMaxWidth(.72f),
               text = "Login",
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
fun TextFieldPhonel() {
     val textPhone = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "Email",
          text = textPhone.value,
          textChange = { textPhone.value = it },
          painter = painterResource(id = R.drawable.phone),
          keyboardType = KeyboardType.Text
     )


}

@ExperimentalComposeUiApi
@Composable
fun TextFieldPasswordl() {
     val textPassword = remember { mutableStateOf("") }

     TextFieldCustom(
          textname = "Password",
          text = textPassword.value,
          textChange = { textPassword.value = it },
          painter = painterResource(id = R.drawable.password),
          keyboardType = KeyboardType.Text
     )
}

@Composable
fun ButtonLogin(
     onClickLogin: () -> Unit
) {
     Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
     ) {


          Button(
               onClick = onClickLogin,
               shape = RoundedCornerShape(20.dp),
               modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(64.dp)
                    .fillMaxWidth(.75f),
               elevation = ButtonDefaults.elevation(30.dp),
               colors = ButtonDefaults.buttonColors(backgroundColor = Color(color = 0xFFFF8901))
          ) {
               Text(
                    text = "Login",
                    style = TextStyle(Color.White),
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
               )
          }
     }
}

@Composable
fun Forget(
     onClickForget: () -> Unit,
) {
     Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
          Text(
               modifier = Modifier
                    .padding(end = 50.dp)
                    .clickable(onClick = onClickForget),
               text = "Forgot Password?",
               fontSize = 12.sp,
               color = Color(color = 0xFFFF8901),
               fontFamily = FontFamily(Font(R.font.poppins_regular))
          )
     }
}


@Composable
fun ButtonSignupl(
     onClickSignup: () -> Unit
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
               colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
          ) {
               Text(
                    text = "Signup",
                    style = TextStyle(Color(color = 0xFFFF8901)),
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
               )
          }
     }
}

@Composable
fun contage() {
     Column(
          modifier = Modifier
               .fillMaxSize()
               .padding(bottom = 30.dp),
          verticalArrangement = Arrangement.Bottom,
          horizontalAlignment = Alignment.CenterHorizontally
     ) {
          Text(
               text = "Production And Support By Contagiouscode ",

               style = TextStyle(
                    color = Color.Black.copy(.7f), fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
               )
          )
     }
}