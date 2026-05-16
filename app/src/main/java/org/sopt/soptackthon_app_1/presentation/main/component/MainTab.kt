package org.sopt.soptackthon_app_1.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.soptackthon_app_1.core.navigation.MainTabRoute
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.navigation.Gabyu
import org.sopt.soptackthon_app_1.core.navigation.Yerim
import org.sopt.soptackthon_app_1.core.navigation.Yubin


//TODO 아이콘 에셋 추출 후 변경
enum class MainTab(
    @get:DrawableRes val selectedIconRes: Int,
    @get:DrawableRes val unselectedIconRes: Int,
    @get:StringRes val titleRes: Int,
    val route: MainTabRoute,
) {
    YERIM(
        selectedIconRes = R.drawable.ic_home_selected,
        unselectedIconRes = R.drawable.ic_home_unselected,
        titleRes = R.string.home,
        route = Yerim,
    ),
    YUBIN(
        selectedIconRes = R.drawable.ic_record_selected,
        unselectedIconRes = R.drawable.ic_record_unselected,
        titleRes = R.string.record,
        route = Yubin,
    ),
    GABYU(
        selectedIconRes = R.drawable.ic_myrecord_selected,
        unselectedIconRes = R.drawable.ic_myrecord_unselected,
        titleRes = R.string.myrecord,
        route = Gabyu,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (MainTabRoute) -> Boolean): Boolean {
            return entries.any { predicate(it.route) }
        }
    }
}
