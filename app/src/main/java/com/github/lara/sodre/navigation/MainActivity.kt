package com.github.lara.sodre.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.lara.sodre.navigation.screens.LoginScreen
import com.github.lara.sodre.navigation.screens.MenuScreen
import com.github.lara.sodre.navigation.screens.PedidosScreen
import com.github.lara.sodre.navigation.screens.PerfilScreen
import com.github.lara.sodre.navigation.ui.theme.Android5navigationbetweenscreensTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Android5navigationbetweenscreensTheme {

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable("login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable("menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(navArgument("cliente") {
                                defaultValue = "Cliente Genérico")

                            })
                        ) {
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                it.arguments?.getString("cliente")
                            )
                        }

                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") { type = NavType.StringType },
                                navArgument("idade") { type = NavType.IntType }
                            )
                        ) {
                            val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
                            val idade: Int? = it.arguments?.getInt("idade", 0)
                            PerfilScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                nome!!, nome!!,
                                idade!!
                            )
                        }
                    }
                }
            }
        }
    }
}