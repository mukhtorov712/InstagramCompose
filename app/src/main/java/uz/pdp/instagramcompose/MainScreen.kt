package uz.pdp.instagramcompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.pdp.instagramcompose.ui.theme.PrimaryColor

@Composable
fun MainScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        InstagramImage(200.dp)
        UserImage()
        UserText(str = "jacob_w")
        LogInButton(12, 35, 35, true)
        SwitchAccount()
        SignUpCard(navController)
    }
}

@Composable
fun InstagramImage(dp: Dp) {
    Image(
        painterResource(id = R.drawable.ic_logo_instagram),
        contentDescription = "",
        modifier = Modifier.padding(top = dp)
    )

}

@Composable
fun UserImage() {
    Image(
        painterResource(id = R.drawable.ic_user), contentDescription = "", modifier = Modifier
            .padding(top = 50.dp)
            .size(85.dp, 85.dp)
    )
}

@Composable
fun UserText(str: String) {
    Text(
        modifier = Modifier.padding(top = 13.dp),
        text = str,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun LogInButton(top: Int, start: Int, end: Int, enable: Boolean) {
    val context = LocalContext.current
    val enabled by remember { mutableStateOf(enable) }
        Button(
            onClick = { Toast.makeText(context, "Log in", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .padding(top = top.dp, start = start.dp, end = end.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
            enabled = enabled
        ) {
            Text(
                text = "Log in", modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
        }
}

@Composable
fun SwitchAccount() {
    Text(
        text = "Switch accounts", modifier = Modifier.padding(top = 30.dp), style = TextStyle(
            fontSize = 14.sp
        ),
        color = PrimaryColor
    )
}

@Composable
fun SignUpCard(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Color.LightGray)
        )
        Row(
            modifier = Modifier
                .clickable(indication = null, interactionSource = remember {
                    MutableInteractionSource()
                }) {
                    navController.navigate(Screen.SignUpScreen.route)
                }
                .padding(18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don’t have an account?",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Sign up.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}