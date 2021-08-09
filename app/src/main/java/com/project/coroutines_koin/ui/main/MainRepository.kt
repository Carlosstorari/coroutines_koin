package com.project.coroutines_koin.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Titulo 1"),
                    Filme(2, "Titulo 2")
                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        // cria contexto de Coroutines
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Filme(1, "Titulo 1"),
                Filme(2, "Titulo 2")
            )
        }
    }
}