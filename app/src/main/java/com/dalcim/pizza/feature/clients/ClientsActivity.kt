package com.dalcim.pizza.feature.clients

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dalcim.pizza.R
import com.dalcim.pizza.domain.Client
import com.dalcim.pizza.feature.client.ClientActivity
import kotlinx.android.synthetic.main.activity_clients.*

class ClientsActivity : AppCompatActivity() {

    private val adapter by lazy { ClientsAdapter() }
    private val controller by lazy { ClientsController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)

        setupView()
        loadClients()
    }

    override fun onResume() {
        super.onResume()

        loadClients()
    }

    private fun setupView() {
        clsRecClients.layoutManager = LinearLayoutManager(this)
        clsRecClients.adapter = adapter

        clsBtnAdd.setOnClickListener {
            Client(id = 4, name = "Iago")

            val intent = Intent(this, ClientActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadClients() {
        adapter.data = controller.getClients()
    }
}
