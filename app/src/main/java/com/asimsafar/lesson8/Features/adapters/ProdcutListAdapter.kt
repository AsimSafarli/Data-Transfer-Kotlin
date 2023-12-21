package com.asimsafar.lesson8.Features.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.asimsafar.lesson8.Model.Product
import com.asimsafar.lesson8.R
import com.asimsafar.lesson8.databinding.ListItemProductBinding

class ProdcutListAdapter(val context:Context,private var dataList:MutableLiveData<Product>):BaseAdapter() {
    override fun getCount(): Int {
       return 100
    }

    override fun getItem(position: Int): Any {
       return ""
    }

    override fun getItemId(position: Int): Long {
     return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
       val binding : ListItemProductBinding = DataBindingUtil.inflate(
           LayoutInflater.from(context),
           R.layout.list_item_product,
           p2,
           false
       )
        binding.txtProductName.text = "assasas"
        binding.txtProductName.text="Product Add"
        return  binding.root
    }
}