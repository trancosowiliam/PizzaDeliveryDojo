package com.dalcim.pizza.clients.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dalcim.pizza.core.model.Client
import com.dalcim.pizza.core.repository.ClientRepository

class ClientsViewModel:ViewModel() {
    private val clientRepository = ClientRepository()
      val clients:LiveData<List<Client>> = MutableLiveData<List<Client>>(clientRepository.getClients())

}