package com.dalcim.pizza.clients.viewmodel

import androidx.lifecycle.ViewModel
import com.dalcim.pizza.core.model.Client
import com.dalcim.pizza.core.repository.ClientRepository

class ClientViewModel :ViewModel(){
    private val _clientRepository =  ClientRepository()

    fun createValidClient(name: String, address: String): Client? {
        return if (name.trim().length > 2) {
            Client(name = name, address = address)
        } else {
            null
        }
    }

    fun saveClient(client: Client): Int {
        return _clientRepository.save(client)
    }
}
