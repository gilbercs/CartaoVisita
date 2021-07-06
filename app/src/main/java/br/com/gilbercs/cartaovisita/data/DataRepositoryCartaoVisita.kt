package br.com.gilbercs.cartaovisita.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DataRepositoryCartaoVisita(private val dao: DataInterfaceDaoCartaoVisita){
    fun adicionar(dataCartaoVisita: DataCartaoVisita)= runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(dataCartaoVisita)
        }
    }
    fun getAll()= dao.getAll()
}