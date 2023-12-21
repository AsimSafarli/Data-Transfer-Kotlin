package com.asimsafar.lesson8.MainActiviy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.asimsafar.lesson8.databinding.ActivityMainBinding
import com.asimsafar.lesson8.Features.newProduct.AddProductActivity
import com.asimsafar.lesson8.MainViewModel
import com.asimsafar.lesson8.Model.Product

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout first
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel after inflating the layout
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Set up data binding
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Initialize the adapter
//        val adapter = ProdcutListAdapter(this.baseContext, mutableListOf())
//        binding.productView.adapter = adapter

        // Set up observers
        observeAll()
    }
    fun openAddProductActivity(){
        val intent = Intent(this, AddProductActivity::class.java)
//        startActivity(intent)
        newProductLauncher.launch(intent)
    }


    private val newProductLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK){
            val item = it.data?.getParcelableExtra<Product>("product")
            println(item)
        }
    }


    fun observeAll(){
        viewModel.addProductObserver.observe(this){
            if (it){
                openAddProductActivity()
            }
        }
    }


    fun removeObserve(){
        viewModel.addProductObserver.removeObservers(this)
    }


    override fun onResume() {
        super.onResume()
        observeAll()
    }


    override fun onPause() {
        super.onPause()
        removeObserve()
    }

}