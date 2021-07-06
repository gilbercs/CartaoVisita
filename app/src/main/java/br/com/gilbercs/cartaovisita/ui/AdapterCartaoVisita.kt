package br.com.gilbercs.cartaovisita.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gilbercs.cartaovisita.data.DataCartaoVisita
import br.com.gilbercs.cartaovisita.databinding.AdapterCartaoVisitaBinding

class AdapterCartaoVisita: ListAdapter<DataCartaoVisita, AdapterCartaoVisita.ViewHolder>(DiffCallback()) {

        var listenerShare: (View) -> Unit = {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = AdapterCartaoVisitaBinding.inflate(inflater, parent, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        inner class ViewHolder(
            private val binding: AdapterCartaoVisitaBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(item: DataCartaoVisita) {
                binding.idAdpNome.text= item.name
                binding.idAdpTelefone.text = item.telefone
                binding.idAdpEmail.text = item.email
                binding.idAdpEmpresa.text = item.empresa
                binding.idAdpCarView.setCardBackgroundColor(Color.parseColor(item.planoFundo))
                binding.idAdpCarView.setOnClickListener {
                    listenerShare(it)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<DataCartaoVisita>() {
        override fun areItemsTheSame(oldItem: DataCartaoVisita, newItem: DataCartaoVisita) = oldItem == newItem
        override fun areContentsTheSame(oldItem: DataCartaoVisita, newItem: DataCartaoVisita) =
            oldItem.id == newItem.id
}