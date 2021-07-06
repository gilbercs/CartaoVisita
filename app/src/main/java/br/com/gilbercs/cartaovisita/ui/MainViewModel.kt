package br.com.gilbercs.cartaovisita.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gilbercs.cartaovisita.data.DataCartaoVisita
import br.com.gilbercs.cartaovisita.data.DataRepositoryCartaoVisita

class MainViewModel(private val dataRepositoryCartaoVisita: DataRepositoryCartaoVisita): ViewModel() {
    fun insert(dataCartaoVisita: DataCartaoVisita){
dataRepositoryCartaoVisita.adicionar(dataCartaoVisita)
    }

    fun getAll(): LiveData<List<DataCartaoVisita>>{
        return dataRepositoryCartaoVisita.getAll()
    }
}
class MainViewModelFactory(private val repository: DataRepositoryCartaoVisita) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}