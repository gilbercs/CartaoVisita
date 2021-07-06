package br.com.gilbercs.cartaovisita.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataInterfaceDaoCartaoVisita {
    @Query("SELECT * FROM DataCartaoVisita")
    fun getAll(): LiveData<List<DataCartaoVisita>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: DataCartaoVisita)
}