package com.dalcim.pizza.model

import com.dalcim.pizza.domain.Client

class ClientRepository {

    fun getClients(): List<Client> {
        return Database.Clients.all
    }

    fun save(client: Client): Int {
        return Database.Clients.save(client)
    }
}