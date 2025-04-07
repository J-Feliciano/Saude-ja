package com.example.saudeja22402837

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saudeja22402837.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBuscar.setOnClickListener{
            var insertMed = binding.edtInsertBusca.text.toString().toUpperCase()
            if (estoqueMedicamentos[insertMed] == true){
                binding.txvResult.text = "Há ${insertMed} no estoque"
            }
            else if(estoqueMedicamentos[insertMed] == false){
                binding.txvResult.text = "Não há ${insertMed} no estoque"
            }
            else{
                binding.txvResult.text = "Nome inválido ou não há registro"
            }
            //binding.txvResult.setText()
        }

    }
    private val estoqueMedicamentos = mapOf(
        "PARACETAMOL" to true,
        "IBUPROFENO" to true,
        "DIPIRONA" to true,
        "ACETILCISTEINA" to false,
        "ASPIRINA" to false
    )
}