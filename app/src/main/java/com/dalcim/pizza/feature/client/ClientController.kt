package com.dalcim.pizza.feature.client

import com.dalcim.pizza.domain.Client
import com.dalcim.pizza.model.ClientRepository

class ClientController {

    private val clientRepository = ClientRepository()

    fun createValidClient(name: String, address: String): Client? {
        return if (name.trim().length > 2) {
            Client(name = name, address = address)
        } else {
            null
        }
    }

    fun saveClient(client: Client): Int {
        return clientRepository.save(client)
    }
}