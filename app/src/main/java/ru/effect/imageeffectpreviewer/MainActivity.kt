package ru.effect.imageeffectpreviewer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.effect.imageeffectpreviewer.ui.components.left_side_sheet.LeftSideSheetPreview
import ru.effect.imageeffectpreviewer.ui.theme.ImageEffectPreviewerTheme

@Composable
@Preview(showBackground = true)
private fun MainActivityPreview() {
    ImageEffectPreviewerTheme {
        LeftSideSheetPreview()
    }
}
