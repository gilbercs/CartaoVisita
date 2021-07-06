package br.com.gilbercs.cartaovisita.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import br.com.gilbercs.cartaovisita.App
import br.com.gilbercs.cartaovisita.databinding.ActivityMainBinding
import br.com.gilbercs.cartaovisita.help.Image

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { AdapterCartaoVisita()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        //recyclear
        binding.idRecyclerViewMain.adapter = adapter
        //get
        getAllCartaoVisita()
        //ação floatActionButton
        abrirActivityAdd()
    }
    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    private fun abrirActivityAdd(){
        binding.idFab.setOnClickListener {
            val intent = Intent(this, AddCartaoActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this, card)
        }
    }
    private fun getAllCartaoVisita() {
        mainViewModel.getAll().observe(this, { cartaoVisita ->
            adapter.submitList(cartaoVisita)
        })
    }
}