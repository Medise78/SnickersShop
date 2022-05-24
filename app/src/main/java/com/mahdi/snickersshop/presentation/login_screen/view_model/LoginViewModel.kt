package com.mahdi.snickersshop.presentation.login_screen.view_model

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel

@SuppressLint("StaticFieldLeak")
class LoginViewModel(application : Application) : AndroidViewModel(application)
{
     private val _emailState = mutableStateOf(LoginState())
     val emailState : State<LoginState> = _emailState
     private val _passwordState = mutableStateOf(LoginState())
     val passwordState : State<LoginState> = _passwordState
     val context = application.applicationContext
     
     init
     {
     }
     
     fun onEvent(event : LoginEvent)
     {
          when (event)
          {
               is LoginEvent.Email ->
               {
                    _emailState.value = emailState.value.copy(
                              text = event.text
                    )
               }
               is LoginEvent.Password ->
               {
                    _passwordState.value = passwordState.value.copy(
                              text = event.text
                    )
               }
          }
     }
}