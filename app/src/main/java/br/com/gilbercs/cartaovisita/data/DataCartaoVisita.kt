package br.com.gilbercs.cartaovisita.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataCartaoVisita(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val telefone: String,
    val email: String,
    val empresa: String,
    val planoFundo: String

)