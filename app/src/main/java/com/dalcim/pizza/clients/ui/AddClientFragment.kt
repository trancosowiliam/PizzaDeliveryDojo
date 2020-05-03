package com.dalcim.pizza.clients.ui

  import android.os.Bundle
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.fragment.app.Fragment
  import com.dalcim.pizza.R
  import com.dalcim.pizza.clients.viewmodel.ClientViewModel
  import com.dalcim.pizza.core.model.Client
  import com.dalcim.pizza.showConfirmDialog
  import kotlinx.android.synthetic.main.fragment_add_client.*
  import kotlinx.android.synthetic.main.fragment_add_client.view.*


class AddClientFragment : Fragment() {
    private val viewModel by lazy { ClientViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val root = inflater.inflate(R.layout.fragment_add_client, container, false)
    setupView(root)
        return root
    }
    private fun setupView(root: View) {

        root.cliBtnSaveClient.setOnClickListener {
            val name = cliEdtName.text.toString()
            val address = cliEdtAddress.text.toString()

            val client = viewModel.createValidClient(name, address)


            if(client == null) {
                requireContext().showConfirmDialog(
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
        if (viewModel.saveClient(client) > 0) {
            activity?.onBackPressed()
        }
    }


}
