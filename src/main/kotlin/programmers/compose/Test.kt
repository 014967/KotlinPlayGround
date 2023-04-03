//package com.knocklock.presentation.lockscreen.util
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberUpdatedState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
///**
// * @Created by 김현국 2023/02/13
// */
//
//@Composable
//fun Outer(
//    list: List<String>,
//    removeTempList: (List<String>) -> Unit
//) {
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(10.dp)
//    ) {
//        items(list, key = { it }) {
//            SwipeToDismissWithUpdatedState(list = list, removeItem = removeTempList, singleItem = it)
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SwipeToDismissWithUpdatedState(
//    singleItem: String,
//    list: List<String>,
//    removeItem: (List<String>) -> Unit
//) {
//    val updateList by rememberUpdatedState(list)
//    val dismissState = rememberDismissState(confirmStateChange = { dismissValue ->
//        when (dismissValue) {
//            DismissValue.Default -> {
//                false
//            }
//            DismissValue.DismissedToStart -> {
//                removeItem(updateList)
//                true
//            }
//            DismissValue.DismissedToEnd -> {
//                removeItem(listOf(singleItem))
//                true
//            }
//        }
//    })
//
//    SwipeToDismiss(
//        state = dismissState,
//        dismissThresholds = { FractionalThreshold(0.25f) },
//        dismissContent = {
//            Text(
//                modifier = Modifier.fillMaxWidth().background(color = androidx.compose.ui.graphics.Color.Blue),
//                text = singleItem,
//                textAlign = TextAlign.Center
//            )
//        },
//        background = {
//        }
//    )
//}
//
//@Preview
//@Composable
//fun PreviewText() {
//    MaterialTheme {
//        val stateHolder = rememberTestStateHolder()
//        val list by stateHolder.tempList.collectAsState()
//        Outer(
//            list,
//            removeTempList = {
//                stateHolder.removeTempList(it)
//            }
//        )
//    }
//}
//
//@Composable
//fun rememberTestStateHolder() = remember {
//    TestStateHolder()
//}
//class TestStateHolder() {
//
//    private val _tempList = MutableStateFlow(
//        mutableListOf(
//            "1",
//            "2",
//            "3",
//            "4",
//            "5",
//            "6",
//            "7"
//        )
//    )
//
//    val tempList = _tempList.asStateFlow()
//
//    fun removeTempList(list: List<String>) {
//        println("remove : " + list.joinToString(" ") { it })
//        val newList = _tempList.value - list.toSet()
//        _tempList.value = newList.toMutableList()
//    }
//}
