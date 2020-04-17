package com.dalcim.pizza.feature.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dalcim.pizza.R
import com.dalcim.pizza.domain.Client
import com.dalcim.pizza.showConfirmDialog
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    private val controller by lazy { ClientController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        setupView()
    }

    private fun setupView() {

        cliBtnSaveClient.setOnClickListener {
            val name = cliEdtName.text.toString()
            val address = cliEdtAddress.text.toString()

            val client = controller.createValidClient(name, address)


            if(client == null) {
                showConfirmDialog(
                    "Alerta",
                    "Dados Invalidos",
                    "Ok"
                ) { cliEdtName.isFocusable = true }
            }else {
                saveClient(client)
            }
        }
    }

    private fun saveClient(client: Client) {
        if (controller.saveClient(client) > 0) {
            finish()
        }
    }
}
