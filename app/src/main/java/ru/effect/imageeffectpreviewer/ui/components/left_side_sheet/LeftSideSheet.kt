package ru.effect.imageeffectpreviewer.ui.components.left_side_sheet

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import ru.effect.imageeffectpreviewer.ui.components.MainActivityContentPreview
import ru.effect.imageeffectpreviewer.ui.theme.ImageEffectPreviewerTheme

@Composable
fun LeftSideSheet(
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
    drawerState: DrawerState,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = sheetContent,
        gesturesEnabled = true,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun LeftSideSheetPreview() {
    ImageEffectPreviewerTheme {
        val state = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ImageEffectPreviewerTheme {
            LeftSideSheet(
                sheetContent = {
                    LeftSideSheetContent(
                        state = state,
                        scope = scope,
                        items = listOf(),
                        onSelectedChanged = {}
                    )
                },
                content = { MainActivityContentPreview() },
                drawerState = state
            )
        }
    }
}
