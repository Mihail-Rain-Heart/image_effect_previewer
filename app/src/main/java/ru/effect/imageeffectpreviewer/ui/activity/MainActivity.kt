package ru.effect.imageeffectpreviewer.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import dagger.hilt.android.AndroidEntryPoint
import ru.effect.imageeffectpreviewer.ui.components.MainActivityContent
import ru.effect.imageeffectpreviewer.ui.components.left_side_sheet.LeftSideSheet
import ru.effect.imageeffectpreviewer.ui.components.left_side_sheet.LeftSideSheetContent
import ru.effect.imageeffectpreviewer.ui.theme.ImageEffectPreviewerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageEffectPreviewerTheme {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                LeftSideSheet(
                    sheetContent = {
                        LeftSideSheetContent(
                            scope = scope,
                            state = drawerState,
                            items = emptyList(),
                            onSelectedChanged = {}
                        )
                    },
                    content = { MainActivityContent() },
                    drawerState = drawerState
                )
            }
        }
    }
}