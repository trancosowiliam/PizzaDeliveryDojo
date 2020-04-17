package com.dalcim.pizza.model

import com.dalcim.pizza.domain.Client

class Database {

    object Clients {
        val all = mutableListOf(
            Client(id = 1, name = "Wiliam"),
            Client(id = 2, name = "Mateus"),
            Client(id = 3, name = "Vanessa")
        )

        fun save(client: Client): Int {
            val entity = client.copy(id = all.size + 1)
            all.add(client)
            return entity.id
        }
    }
}