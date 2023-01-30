package com.io.muhsin.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.io.muhsin.notesappmvvm.MainViewModel
import com.io.muhsin.notesappmvvm.MainViewModelFactory
import com.io.muhsin.notesappmvvm.navigation.NavRoute
import com.io.muhsin.notesappmvvm.ui.theme.NotesAppMVVMTheme
import com.io.muhsin.notesappmvvm.utils.Constants.Keys.FIREBASE
import com.io.muhsin.notesappmvvm.utils.Constants.Keys.ROOM_DATABASE
import com.io.muhsin.notesappmvvm.utils.Constants.Keys.WHAT_WILL_WE_USE
import com.io.muhsin.notesappmvvm.utils.TYPE_FIREBASE
import com.io.muhsin.notesappmvvm.utils.TYPE_ROOM

@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = WHAT_WILL_WE_USE)
            Button(
                onClick = {
                    mViewModel.initDataBase(TYPE_ROOM){
                        navController.navigate(route = NavRoute.Main.route)
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            )
            {
                Text(text = ROOM_DATABASE)
            }
            Button(
                onClick = {
                   mViewModel.initDataBase(TYPE_FIREBASE){
                       navController.navigate(route = NavRoute.Main.route)
                   }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            )
            {
                Text(text = FIREBASE)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen() {
    NotesAppMVVMTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}