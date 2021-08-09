package com.project.coroutines_koin.di

import androidx.navigation.NavController
import com.project.coroutines_koin.ui.main.MainRepository
import com.project.coroutines_koin.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainRepository()
    }

    viewModel { (navController: NavController) ->
        MainViewModel(
            //pega MainRepository da factory acima
            repository = get(),
            navController = navController
        )
    }
}