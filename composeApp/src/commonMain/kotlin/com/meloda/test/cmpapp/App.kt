package com.meloda.test.cmpapp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.meloda.test.cmpapp.theme.AppTheme


val dummyNotes = List(50) { index ->
    Note(
        id = index,
        title = "Note #${index + 1}",
        content = "Note Content #${index + 1}"
    )
}

@Composable
internal fun App() = AppTheme { Navigator(screen = NotesScreen) }

internal expect fun openUrl(url: String?)
