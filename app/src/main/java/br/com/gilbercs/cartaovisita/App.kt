package br.com.gilbercs.cartaovisita

import android.app.Application
import br.com.gilbercs.cartaovisita.data.AppDatabase
import br.com.gilbercs.cartaovisita.data.DataRepositoryCartaoVisita

class App: Application(){
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { DataRepositoryCartaoVisita(database.cartaVisitaDao()) }
}