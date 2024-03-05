package com.aditya.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aditya.notesapp.screen.NoteScreen
import com.aditya.notesapp.screen.NoteViewModel
import com.aditya.notesapp.ui.theme.NotesAppTheme


@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
               Surface(color = MaterialTheme.colorScheme.background) {
                   val noteViewModel = viewModel<NoteViewModel>()
                   NotesApp(noteViewModel)
               }
            }
        }
    }
}


@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(notes = notesList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) })

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesAppTheme {
    }
}


