package uz.pdp.instagramcompose

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object SignUpScreen: Screen("sign_up_screen")
}
