package ru.effect.imageeffectpreviewer.ui.components.left_side_sheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.effect.imageeffectpreviewer.R

@Composable
fun LeftSideSheetContent(
    scope: CoroutineScope,
    state: DrawerState,
    items: List<LeftSideSheetContentItem>,
    onSelectedChanged: (LeftSideSheetContentItem) -> Unit
) {
    val selectedItem = remember { mutableStateOf(items.find { item -> item.isSelected }) }

    ModalDrawerSheet(drawerState = state) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Text(stringResource(R.string.toolbox_title), modifier = Modifier.padding(16.dp))
            items.forEach { item ->
                item.NavigationDrawerItem(
                    selected = item == selectedItem,
                    onClick = {
                        scope.launch { state.close() }
                        selectedItem.value = item
                        onSelectedChanged(item)
                    }
                )
            }
        }
    }
}

sealed interface LeftSideSheetContentItem {

    val isSelected: Boolean

    @Composable
    fun NavigationDrawerItem(
        selected: Boolean,
        onClick: () -> Unit,
    )
}
