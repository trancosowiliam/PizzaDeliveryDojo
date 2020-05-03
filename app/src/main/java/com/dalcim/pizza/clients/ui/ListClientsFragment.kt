package com.dalcim.pizza.clients.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dalcim.pizza.R
import com.dalcim.pizza.clients.viewmodel.ClientsViewModel
import kotlinx.android.synthetic.main.fragment_list_clients.view.*

class ListClientsFragment : Fragment() {

    private val adapter by lazy { ClientsAdapter() }
    private val viewModel by lazy { ClientsViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val  root =  inflater.inflate(R.layout.fragment_list_clients, container, false).rootView
               setupView(root)
        setupObserve()
         return root

    }
    private fun setupObserve(){
        viewModel.clients.observe(this, Observer {
            adapter.data = it
        })
    }

    private fun setupView(root: View) {
        root.clsRecClients.layoutManager = LinearLayoutManager(requireContext())
        root.clsRecClients.adapter = adapter
        root.clsBtnAdds.setOnClickListener {
//            Client(id = 4, name = "Iago")
            goToNextScreen()
        }
    }

    private fun goToNextScreen() {
         findNavController().navigate( R.id.action_listClientsFragment_to_addClientFragment)
    }
}
