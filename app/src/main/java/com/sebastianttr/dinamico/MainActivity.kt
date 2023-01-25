package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sebastianttr.dinamico.composable.SBottomNavigationItem
import com.sebastianttr.dinamico.config.Screen
import com.sebastianttr.dinamico.layouts.DashboardLayout
import com.sebastianttr.dinamico.layouts.ProfileLayout
import com.sebastianttr.dinamico.layouts.SettingsLayout
import com.sebastianttr.dinamico.models.BottomNavItemModel
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.MainStrong
import androidx.lifecycle.lifecycleScope
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.room.database.Database
import io.reactivex.Completable
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch{
            val db = Database.getDb(applicationContext)
        }

        setContent {
            val navController = rememberNavController()

            val items = remember {
                mutableStateListOf(
                    BottomNavItemModel(
                        screen = Screen.Dashboard,
                        selectedResId = R.drawable.dashboard_selected,
                        unselectedResId = R.drawable.dashboard_unselected,
                    ),
                    BottomNavItemModel(
                        screen = Screen.Profile,
                        selectedResId = R.drawable.profile_selected,
                        unselectedResId = R.drawable.profile_unselected
                    ),
                    BottomNavItemModel(
                        screen = Screen.Settings,
                        selectedResId = R.drawable.settings_selected,
                        unselectedResId = R.drawable.settings_unselected
                    ),
                )
            }
            DinamicoTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(modifier =
                            Modifier.height(80.dp)
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination

                            Column{
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                                    .background(AccentLight))
                                Row(
                                    modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .background(MainStrong)
                                        .padding(horizontal = 64.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    items.forEach { navItem ->
                                        SBottomNavigationItem(
                                            name = navItem.screen.view.route,
                                            selected = currentDestination?.hierarchy?.any { it.route == navItem.screen.view.route } == true,
                                            resIdUnselected = navItem.unselectedResId,
                                            resIdSelected = navItem.selectedResId,
                                            onClick = {
                                                navController.navigate(navItem.screen.view.route) {
                                                    // Pop up to the start destination of the graph to
                                                    // avoid building up a large stack of destinations
                                                    // on the back stack as users select items
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    // Avoid multiple copies of the same destination when
                                                    // reselecting the same item
                                                    launchSingleTop = true
                                                    // Restore state when reselecting a previously selected item
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                }
                            }

                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController, startDestination = Screen.Dashboard.view.route,
                        Modifier
                            .padding(bottom = 40.dp)
                    ) {
                        composable(Screen.Dashboard.view.route) { DashboardLayout() }
                        composable(Screen.Profile.view.route) { ProfileLayout() }
                        composable(Screen.Settings.view.route) { SettingsLayout() }
                    }
                }
            }
        }
    }
}

