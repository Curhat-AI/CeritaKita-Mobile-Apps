package com.ceritakita.app._core.presentation.components.tabBar

import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily

@Composable
fun CustomTabBar(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = BrandColors.brandPrimary600,
    inactiveColor: Color = TextColors.grey500,
    indicatorColor: Color = BrandColors.brandPrimary600,
    activeFontSize: Float = 15f,
    inactiveFontSize: Float = 15f
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = Color.Transparent,
        divider = ({
            HorizontalDivider(
                color = TextColors.grey200,
                thickness = 1.dp
            )
        }),
        contentColor = activeColor,
        indicator = {
            SecondaryIndicator(
                Modifier.tabIndicatorOffset(it[selectedTabIndex]),
                height = 3.dp,
                color = indicatorColor
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontFamily = dmSansFontFamily,
                            fontSize = if (index == selectedTabIndex) activeFontSize.sp else inactiveFontSize.sp,
                            fontWeight = if (index == selectedTabIndex) FontWeight.SemiBold else FontWeight.Normal,
                            color = if (index == selectedTabIndex) activeColor else inactiveColor
                        )
                    )
                }
            )
        }
    }
}