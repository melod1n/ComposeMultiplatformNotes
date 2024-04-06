package com.meloda.test.cmpapp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.meloda.test.cmpapp.theme.AppTheme


val dummyNotes = listOf(
    Note(id = 9818, title = "eros", content = "singulis"),
    Note(id = 1, title = "Kek", content = "singulis"),
    Note(id = 2, title = "eros", content = "singulis"),
    Note(id = 3, title = "eros", content = "singulis"),
    Note(id = 4, title = "eros", content = "singulis"),
)

@Composable
internal fun App() = AppTheme { Navigator(screen = NotesScreen) }

internal expect fun openUrl(url: String?)
