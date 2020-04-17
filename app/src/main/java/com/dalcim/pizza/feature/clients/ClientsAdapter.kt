package com.dalcim.pizza.feature.clients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalcim.pizza.R
import com.dalcim.pizza.domain.Client
import kotlinx.android.synthetic.main.item_client.view.*

class ClientsAdapter : RecyclerView.Adapter<ClientsAdapter.ClientViewHolder>() {
    var data: List<Client> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false)

        return ClientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ClientViewHolder, position: Int) {
        val client = data[position]

        viewHolder.render(client)
    }

    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun render(client:Client) {
            itemView.icliTxtName.text = client.name
        }
    }
}