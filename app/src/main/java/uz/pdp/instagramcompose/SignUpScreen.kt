package uz.pdp.instagramcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.pdp.instagramcompose.ui.theme.PrimaryColor

@Composable
fun SignUpScreen(navController: NavController) {

    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()) {
        Image(
            painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "image",
            modifier = Modifier
                .size(30.dp)
                .clip(
                    CircleShape
                )
                .clickable { navController.popBackStack() }
                .padding(5.dp)
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        InstagramImage(0.dp)

        val textState1 = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = textState1.value,
            onValueChange = {
                textState1.value = it
            },
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Username") }
        )

        val textState2 = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = textState2.value,
            onValueChange = {
                textState2.value = it
            },
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Column(
            horizontalAlignment = Alignment.End, modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Forgot password?", style = TextStyle(
                    fontSize = 12.sp,
                    color = PrimaryColor
                )
            )
        }

        LogInButton(30, 0, 0, true)

        Row(
            modifier = Modifier.padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook",
            )
            Text(
                text = "Log in with Facebook", modifier = Modifier.padding(start = 10.dp),
                style = TextStyle(
                    color = PrimaryColor,
                    fontSize = 14.sp
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.LightGray)
                    .weight(1f)
            )

            Text(
                text = "OR", modifier = Modifier.padding(start = 20.dp, end = 20.dp), style =
                TextStyle(color = Color.LightGray, fontSize = 12.sp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.LightGray)
                    .weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don’t have an account?",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Sign up.",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = PrimaryColor
                )
            )
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Color.LightGray)
        )

        Text(
            modifier = Modifier.padding(18.dp),
            text = "Instagram from Facebook",
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray
            )
        )
    }
}