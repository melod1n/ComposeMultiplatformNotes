package com.meloda.test.cmpapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.notes
import org.jetbrains.compose.resources.stringResource

object NotesScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        var notes: List<Note> by remember {
            mutableStateOf(emptyList())
        }

        val isNotesEmpty by remember {
            derivedStateOf { notes.isEmpty() }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(Res.string.notes))
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.push(CreateNoteScreen)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null
                    )
                }
            }
        ) { padding ->
            if (isNotesEmpty) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ElevatedButton(
                        onClick = {
                            notes += dummyNotes
                        }
                    ) {
                        Text(text = "Add dummy notes")
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
                    itemsIndexed(notes) { index, note ->
                        NoteItem(note)
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Note #${note.id}")

        Text(
            text = note.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        )

        Text(text = note.content)

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Immutable
data class Note(
    val id: Int,
    val title: String,
    val content: String
)
