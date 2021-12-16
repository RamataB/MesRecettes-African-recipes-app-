package com.example.mesrecettes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), ItemsAdapter.Clicklistener {

       val imagesName = arrayOf(
           ItemsModal("Thieboudienne","Rice and Fish", R.drawable.image1),
           ItemsModal("Okra soup","Seafood", R.drawable.image2),
           ItemsModal("Egusi soup", "Fish&Meat", R.drawable.image3),
           ItemsModal("Palm nut soup", "Crab", R.drawable.image4),
           ItemsModal("Yassa", "Chicken", R.drawable.image5),
           ItemsModal("Potato leaves stew", " Sweet potato leaves",R.drawable.image6),
           ItemsModal("Attiéké poisson", "Cassava couscous with fried fish",R.drawable.image7),
           ItemsModal("Ghana fufu", "Cassava&Fresh Plantain",R.drawable.image8)

           )

         val itemModalList= ArrayList<ItemsModal>()
         var itemsAdapter:ItemsAdapter?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        for (items in imagesName){
            itemModalList.add(items)
        }
        itemsAdapter= ItemsAdapter(this);
        itemsAdapter!!.setData(itemModalList);


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=itemsAdapter
    }

    override fun ClicItem(itemsModal: ItemsModal) {
        Log.e("TAG", itemsModal.name);
        when(itemsModal.name) {
            "Thieboudienne"->
                startActivity(Intent(this@SecondActivity, Item1Activity::class.java))
            "Okra soup"->
                startActivity(Intent(this@SecondActivity, Item2Activity::class.java))
            "Egusi soup"->
                startActivity(Intent(this@SecondActivity, Item3Activity::class.java))
            "Palm nut soup"->
                startActivity(Intent(this@SecondActivity, Item4Activity::class.java))
            "Yassa"->
                startActivity(Intent(this@SecondActivity, Item5Activity::class.java))
            "Potato leaves stew"->
                startActivity(Intent(this@SecondActivity, Item6Activity::class.java))
            "Attiéké poisson"->
                startActivity(Intent(this@SecondActivity, Item7Activity::class.java))
            "Ghana fufu"->
                startActivity(Intent(this@SecondActivity, Item8Activity::class.java))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuItem=menu!!.findItem(R.id.searchView)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth= Int.MAX_VALUE
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                itemsAdapter!!.filter.filter(filterString)


                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {
            itemsAdapter!!.filter.filter(filterString)

                return true
            }


        })

        return true
    }


}