package com.dalcim.pizza.feature.clients

import com.dalcim.pizza.domain.Client
import com.dalcim.pizza.model.ClientRepository

class ClientsController {

    private val clientRepository = ClientRepository()

    fun getClients(): List<Client> {
        return clientRepository.getClients()
    }

}