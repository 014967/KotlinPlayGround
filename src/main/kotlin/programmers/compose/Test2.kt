//package com.knocklock.presentation.lockscreen.util
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.State
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.delay
//
///**
// * @Created by 김현국 2023/02/13
// * @Time 7:29 PM
// */
//
//@Composable
//fun <T> rememberTest(newValue: T): State<T> = remember {
//    mutableStateOf(newValue)
//}.apply {
//    value = newValue
//}
//
//@Composable
//fun <T> rememberTest2(newValue: T): State<T> = remember(newValue) {
//    mutableStateOf(newValue)
//}
//
//@Composable
//fun Test(
//    buttonColour: String
//) {
//    val timerDuration = 10000L
//    LaunchedEffect(key1 = Unit, block = {
//        startTimer(timerDuration) {
//            println("Last pressed test1Color was $buttonColour")
//        }
//    })
//}
//
//@Composable
//fun Timer(
//    buttonColour: String
//) {
//    val timerDuration = 10000L
//    val test2Color = remember { mutableStateOf(buttonColour) }
////    println("startTest2HashCode :${test2Color.hashCode()} test2Color:  ${test2Color.value}")
//    println("recomposition : $buttonColour")
//    LaunchedEffect(key1 = buttonColour, block = {
//        startTimer(timerDuration) {
////            println("Last pressed test1Color was ${test1Color.hashCode()} ${test1Color.value}")
//            println("Last pressed test2Color was ${test2Color.hashCode()} ${test2Color.value}")
////            println("Last pressed buttonColour was $buttonColour")
//        }
//    })
//}
//
//suspend fun startTimer(time: Long, onTimerEnd: () -> Unit) {
//    delay(timeMillis = time)
//    onTimerEnd()
//}
//
//@Composable
//fun TwoButtonScreen() {
//    var buttonColour by remember {
//        mutableStateOf("Unknown")
//    }
//    Column {
//        Button(
//            onClick = {
//                buttonColour = "Red"
//            },
//            colors = ButtonDefaults.buttonColors(
//                contentColor = Color.Red
//            )
//        ) {
//            Text("Red Button")
//        }
//        Spacer(Modifier.height(24.dp))
//        Button(
//            onClick = {
//                buttonColour = "Black"
//            },
//            colors = ButtonDefaults.buttonColors(
//                contentColor = Color.Black
//            )
//        ) {
//            Text("Black Button")
//        }
//        Timer(buttonColour = buttonColour)
//    }
//}
//
//@Preview
//@Composable
//fun TestTwoButtonScreen() {
//    MaterialTheme {
//        TwoButtonScreen()
//    }
//}
