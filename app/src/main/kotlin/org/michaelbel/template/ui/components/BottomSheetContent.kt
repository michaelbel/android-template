package org.michaelbel.template.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import org.michaelbel.template.ui.theme.AppTheme
import org.michaelbel.template.ui.theme.BottomSheetShape
import org.michaelbel.template.ui.theme.Dimens
import org.michaelbel.template.ui.theme.Red800
import org.michaelbel.template.ui.theme.large

@Composable
fun HomeBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: ModalBottomSheetState,
    scope: CoroutineScope,
    currentSortOption: Int,
    onSettingsClicked: () -> Unit = {},
    onSortOptionClicked: (Int) -> Unit = {},
) {

    Surface(
        shape = BottomSheetShape,
        color = MaterialTheme.colors.surface,
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = Dimens.SmallPadding.size)
                .navigationBarsPadding()
        ) {
            TopSheetSection(
                modifier = Modifier
                    .padding(Dimens.SmallPadding.size),
                onCloseClicked = { scope.launch { sheetState.hide() } },
                onSettingsClicked = {
                    scope.launch {
                        sheetState.hide()
                        onSettingsClicked()
                    }
                }
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                items(Sort.values()) { item ->
                    val selectedColor by animateColorAsState(
                        targetValue = if (currentSortOption == item.sortValue) {
                            MaterialTheme.colors.primary
                                .copy(alpha = .6f)
                        } else Color.Transparent,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    val contentColor by animateColorAsState(
                        targetValue = if (currentSortOption == item.sortValue) {
                            Red800
                                .copy(alpha = .9f)
                        } else MaterialTheme.colors.onBackground,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing
                        )
                    )

                    SheetOption(
                        modifier = Modifier
                            .fillMaxWidth(),
                        sortOptionName = item.type,
                        icon = item.icon,
                        onOptionClicked = {
                            onSortOptionClicked(item.sortValue)
                        },
                        selectedSortColor = selectedColor,
                        contentColor = contentColor
                    )
                }

                item {
                    DonateAndAbout(
                        modifier = Modifier
                            .padding(Dimens.MediumPadding.size),
                        onAboutClicked = { scope.launch { sheetState.hide() } },
                        onDonateClicked = { scope.launch { sheetState.hide() } }
                    )
                }
            }
        }
    }
}

@Composable
fun TopSheetSection(
    modifier: Modifier = Modifier,
    onCloseClicked: () -> Unit = { },
    onSettingsClicked: () -> Unit = { },
    settingsButtonVisible: Boolean = true
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(height = 5.dp, width = 32.dp)
                .background(
                    color = MaterialTheme.colors.onBackground.copy(alpha = .1f),
                    shape = CircleShape
                )
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = onCloseClicked) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = stringResource(id = R.string.cd_close),
                    tint = MaterialTheme.colors.secondary
                )
            }

            Text(
                text = stringResource(R.string.bottom_sheet_dialog),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(
                onClick = onSettingsClicked,
                enabled = settingsButtonVisible
            ) {
                if (settingsButtonVisible) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = stringResource(id = R.string.cd_settings),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun SheetOption(
    modifier: Modifier = Modifier,
    sortOptionName: String,
    style: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    maxLines: Int = 1,
    iconDescription: String? = null,
    icon: ImageVector,
    contentColor: Color = MaterialTheme.colors.onBackground,
    onOptionClicked: () -> Unit = { },
    selectedSortColor: Color = Color.Transparent
) {

    Box(
        modifier = modifier
            .clip(large)
            .background(
                color = selectedSortColor,
                shape = large
            )
            .clickable { onOptionClicked() }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.MediumPadding.size)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                tint = contentColor,
            )
            Spacer(modifier = Modifier.width(Dimens.MediumPadding.size))
            Text(
                text = sortOptionName,
                style = style,
                color = contentColor,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun DonateAndAbout(
    modifier: Modifier = Modifier,
    onDonateClicked: () -> Unit = { },
    onAboutClicked: () -> Unit = { }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = onDonateClicked,
            shape = CircleShape,
            elevation = ButtonDefaults
                .buttonElevation(
                    defaultElevation = 0.dp
                ),
            modifier = Modifier
                .weight(1f)
        ) {
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Donate",
                modifier = Modifier
                    .padding(
                        horizontal = 4.dp,
                        vertical = Dimens.SmallPadding.size
                    ),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(Dimens.MediumPadding.size))
        Button(
            onClick = onAboutClicked,
            shape = CircleShape,
            elevation = ButtonDefaults
                .buttonElevation(
                    defaultElevation = 0.dp
                ),
            modifier = Modifier
                .weight(.7f)
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "About",
                modifier = Modifier
                    .padding(
                    horizontal = 4.dp,
                    vertical = Dimens.SmallPadding.size
                ),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun BottomSheetPreview() {
    AppTheme {
        HomeBottomSheet(
            scope = rememberCoroutineScope(),
            sheetState = ModalBottomSheetState(ModalBottomSheetValue.Hidden),
            currentSortOption = 1
        )
    }
}

@Preview
@Composable
fun SortOptionPreview() {
    AppTheme {
        SheetOption(sortOptionName = "Alphabetical", icon = Icons.Outlined.AccountCircle)
    }
}

enum class Sort(
    val type: String,
    val icon: ImageVector,
    val sortValue: Int
) {
    ALPHABETICAL_ASC(
        type = "Alphabetical Order",
        icon = Icons.Outlined.AccountCircle,
        sortValue = 0
    ),
    NEW_RELEASE_FIRST(
        type = "Newest Release First",
        icon = Icons.Outlined.AccountCircle,
        sortValue = 1
    ),
    OLD_RELEASE_FIRST(
        type = "Oldest Release First",
        icon = Icons.Outlined.AccountCircle,
        sortValue = 2
    ),
    LOW_PRICE_FIRST(
        type = "Lowest Price First",
        icon = Icons.Outlined.AccountCircle,
        sortValue = 3
    ),
    HIGH_PRICE_FIRST(
        type = "Highest Price First",
        icon = Icons.Outlined.AccountCircle,
        sortValue = 4
    )
}