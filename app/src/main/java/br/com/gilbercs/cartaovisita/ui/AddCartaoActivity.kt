package br.com.gilbercs.cartaovisita.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.gilbercs.cartaovisita.App
import br.com.gilbercs.cartaovisita.R
import br.com.gilbercs.cartaovisita.data.DataCartaoVisita
import br.com.gilbercs.cartaovisita.databinding.ActivityAddCartaoBinding

class AddCartaoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddCartaoBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //
        adicionarCartao()
    }
    private fun adicionarCartao(){
        //cadastro
        binding.btnConfirm.setOnClickListener {
            val cartaoVisita = DataCartaoVisita(
                name = binding.idEdtNome.editText!!.text.toString(),
                telefone = binding.idEdtTelefone.editText!!.text.toString(),
                email = binding.idEdtEmail.editText!!.text.toString(),
                empresa = binding.idEdtEmpresa.editText!!.text.toString() ,
                planoFundo = binding.idEdtCor.editText!!.text.toString()
            )
            mainViewModel.insert(cartaoVisita)
            Toast.makeText(this, R.string.label_cadastro_sucesso,Toast.LENGTH_LONG).show()
            finish()
        }

    }
}