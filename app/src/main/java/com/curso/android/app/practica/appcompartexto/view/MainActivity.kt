package com.curso.android.app.practica.appcompartexto.view

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.curso.android.app.practica.appcompartexto.R
import com.curso.android.app.practica.appcompartexto.databinding.ActivityMainBinding
import com.curso.android.app.practica.appcompartexto.model.TypeResponse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        delete()

        mainViewModel.response.observe(this){
            when (it.equalText) {
                TypeResponse.EQUAL -> {
                    binding.response.text="Los dos textos son iguales"
                }
                TypeResponse.DIFFERENT -> {
                    binding.response.text="Los dos textos son distintos"
                }
                else -> {
                    binding.response.text=" "
                }
            }
        }
        binding.btnCompare.setOnClickListener {
            mainViewModel.textsComparison(binding.editText1.text.toString(), binding.editText2.text.toString(), binding.checkBox.isChecked)
        }
    }

private fun delete(){
    val btnDelete: Button = findViewById(R.id.btnBorrar)
    btnDelete.setOnClickListener {
        val textView1: EditText = findViewById(R.id.editText1)
        textView1.setText("")

        val textView2: EditText = findViewById(R.id.editText2)
        textView2.setText("")
    }
}

}

