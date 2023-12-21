package com.asimsafar.lesson8.Features.newProduct

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.asimsafar.lesson8.R
import com.asimsafar.lesson8.databinding.ActivityAddProductBinding
import com.asimsafar.lesson8.MainViewModel
import com.asimsafar.lesson8.Model.Product

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding
    lateinit var viewModel: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(AddProductViewModel::class.java)

        binding = ActivityAddProductBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.lifecycleOwner = this
//        binding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        observeAll()
    }

    fun observeAll() {
        viewModel.newProductCallBack.observe(this) {
            val intent = Intent()
            val product = Product(viewModel.name.value.orEmpty(), viewModel.code.value.orEmpty(), viewModel.description.value.orEmpty())
            intent.putExtra("product", product)

            setResult(RESULT_OK, intent)
            finish()
        }

        viewModel.error.observe(this) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}