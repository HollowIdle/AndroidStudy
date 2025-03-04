package com.example.andrioidstudycompose

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andrioidstudycompose.ui.theme.AndrioidStudyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            AndrioidStudyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(paddingModifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Login(paddingModifier: Modifier = Modifier){
    val loginFieldText = remember { mutableStateOf("") }
    val passwordFieldText = remember { mutableStateOf("") }

    Column(
        modifier = paddingModifier.fillMaxSize()){
        Text(
            text = "Login",
            modifier = Modifier.fillMaxWidth(1f).padding(top = 10.dp),
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 10.dp)
        ) {
            OutlinedTextField(
                value = loginFieldText.value,
                onValueChange = {newText -> loginFieldText.value = newText},
                label = {Text("login")},
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 10.dp)
        ) {
            OutlinedTextField(
                value = passwordFieldText.value,
                onValueChange = {newText -> passwordFieldText.value = newText},
                label = {Text("password")},
                visualTransformation = PasswordVisualTransformation()
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Button(
                onClick = { onLoginClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 70.dp, vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.buttonColor)
                )
            ) {
                Text("Login")
            }
        }

    }
}

fun onLoginClick(){
    Log.d("Button pressed","login Button pressed");
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndrioidStudyComposeTheme {
        Login()
    }
}