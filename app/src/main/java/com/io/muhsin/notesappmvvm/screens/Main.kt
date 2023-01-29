package com.io.muhsin.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.io.muhsin.notesappmvvm.MainViewModel
import com.io.muhsin.notesappmvvm.MainViewModelFactory
import com.io.muhsin.notesappmvvm.model.Note
import com.io.muhsin.notesappmvvm.navigation.NavRoute
import com.io.muhsin.notesappmvvm.ui.theme.NotesAppMVVMTheme

@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    val notes = mViewModel.readTest.observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icons",
                    tint = Color.White)
            }
        }
    ) {/*
        Column {
            noteItem(title = "Note 1", subtitle = "Subtitle", navController =navController)
            noteItem(title = "Note 2", subtitle = "Subtitle", navController =navController)
            noteItem(title = "Note 3", subtitle = "Subtitle", navController =navController)
            noteItem(title = "Note 4", subtitle = "Subtitle", navController =navController)
        }*/
        LazyColumn{
            items(notes){ note->
                noteItem(note = note , navController=navController )

            }
        }

    }
}
@Composable
fun noteItem(note: Note,navController:NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable { navController.navigate(NavRoute.Note.route) },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text =note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text =note.subtitle)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevMainScreen() {
    NotesAppMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}