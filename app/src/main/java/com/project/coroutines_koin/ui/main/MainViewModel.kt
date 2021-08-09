package com.project.coroutines_koin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepository,
    private val navController: NavController
) : ViewModel() {

    val filmesLiveData = MutableLiveData<List<Filme>>()

    fun getFilmes() {
        repository.getFilmes { filmes ->
            filmesLiveData.postValue(filmes)
        }
    }

    fun getFimesCoroutines() {
        //executa na thread principal
        CoroutineScope(Dispatchers.Main).launch {

            // espera para executar na thread principal
            val filmes = withContext(Dispatchers.Default) {
                repository.getFilmesCoroutines()
            }
            filmesLiveData.value = filmes
        }
    }
}