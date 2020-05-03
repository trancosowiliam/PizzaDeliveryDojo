package com.dalcim.pizza.core.repository

import com.dalcim.pizza.core.model.Client
import com.dalcim.pizza.core.repository.local.data.source.Database

class ClientRepository {

    fun getClients(): List<Client> {
        return Database.Clients.all
    }

    fun save(client: Client): Int {
        return Database.Clients.save(client)
    }
}