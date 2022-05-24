package com.mahdi.snickersshop.presentation.login_screen.view_model

sealed class LoginEvent
{
     data class Email(val text : String) : LoginEvent()
     data class Password(val text : String) : LoginEvent()
     object Login : LoginEvent()
}
