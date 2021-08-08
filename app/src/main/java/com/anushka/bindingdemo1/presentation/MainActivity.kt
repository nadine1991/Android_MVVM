package com.anushka.bindingdemo1.presentation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.anushka.bindingdemo1.R
import com.anushka.bindingdemo1.adapters.ItemAdapter
import com.anushka.bindingdemo1.databinding.ActivityMainBinding
import com.anushka.bindingdemo1.model.breadlist.BreedList
import com.anushka.bindingdemo1.model.breadlist.BreedListItem
import com.anushka.bindingdemo1.model.breed.OneBreed
import com.anushka.bindingdemo1.model.gridbreed.breedgrid


class MainActivity : AppCompatActivity() {

        var current_postition = 0
        var List_Breeds= ArrayList<BreedListItem>()
        var List_Breeds_select= ArrayList<String>()
        var List_Breeds_images = ArrayList<String>()

        var adapter: ItemAdapter?=null
        var recyclerView: RecyclerView? = null

        private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
           //setContentView(R.layout.activity_main)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



            stag_grid()
            initviewmodel()

        }

        private fun initviewmodel() {

           val viewModel= ViewModelProvider(this)
                .get(MainActivityViewModel::class.java)

            val responseLiveData = viewModel.getdataselectobserver()

            responseLiveData.observe(this, Observer<BreedList>  {
                if (it!=null){
                    List_Breeds = it
                  print("first data observed  "+it[0].breedGroup.toString() )
                 it.forEach { List_Breeds_select.add(it.name)}

                    println("first data observed" )


                    val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,   List_Breeds_select
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    binding.spinner.setAdapter(adapter)

                }else {
                    print("first data observed null")

                }


            })
            viewModel.makeApiCall()


            binding.spinner.setOnItemSelectedListener(object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
                ) {

                    var id:Int = position + 1
                    Toast.makeText(getApplicationContext(),
                        List_Breeds_select[position],
                        Toast.LENGTH_LONG)
                        .show();
                        viewModel.makeapiimageCall(id.toString())
                    println("call id api  " + id.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })

            print("list_Breeds"  + List_Breeds)

            val responseLiveDataImages = viewModel.getdatashowobserver()
            responseLiveDataImages.observe(this, Observer <OneBreed>{
                if(it!=null) {
                    it.forEach {
                        List_Breeds_images.add(it.url)
                        println("number of records " + it.breeds)
                        it.breeds.forEach { println("number of records " + it.id)
                           }
                    }
                    println("selected data observed" + it)
                   // List_Breeds_images.add(breedgrid(it[0].id,it[0].url))
                    println(" List_Breeds_images" +  List_Breeds_images )
                   // adapter?.notifyDataSetChanged()

                    adapter?.notifyItemChanged(current_postition)

                    current_postition++
                    print("current_postition "+current_postition)
                }

            })



        }


        private fun stag_grid() {
            // Set the LayoutManager that this RecyclerView will use.
            binding.recycleViewStagged.layoutManager = GridLayoutManager(this, 3);

            adapter = ItemAdapter(this, List_Breeds_images)
            // adapter instance is set to the recyclerview to inflate the items.
            binding.recycleViewStagged.adapter = adapter
        }

    }

