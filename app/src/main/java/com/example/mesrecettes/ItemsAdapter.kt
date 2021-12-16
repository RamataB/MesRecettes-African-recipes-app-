package com.example.mesrecettes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mesrecettes.ItemsAdapter.*
import kotlinx.android.synthetic.main.row_items.view.*


class ItemsAdapter
    (var clicklistener: Clicklistener)

    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModallist= ArrayList<ItemsModal>();
    var itemsModalListFilter= ArrayList<ItemsModal>();

    fun setData(itemsModallist:ArrayList<ItemsModal>){
        this.itemsModallist= itemsModallist;
        this.itemsModalListFilter= itemsModallist;
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false));
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
    val itemsModal=itemsModallist[position];
        holder.name.text=itemsModal.name
        holder.des.text=itemsModal.des
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener {
             clicklistener.ClicItem(itemsModal)
        }



    }

    override fun getItemCount(): Int {
        return itemsModallist.size
    }
    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

     val name=itemView.foodName
      val des= itemView.foodDesc
      val image= itemView.imageView





    }

    interface Clicklistener{
    fun ClicItem(itemsModal: ItemsModal)




    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults=FilterResults();
                if(charsequence ==null||charsequence.length<0){
                    filterResults.count=itemsModalListFilter.size
                    filterResults.values=itemsModalListFilter
                }
               else{
                   var searchChr= charsequence.toString().lowercase()
                    val itemModal= ArrayList<ItemsModal>()
                    for (item in itemsModalListFilter){
                        if (item.name.contains(searchChr)|| item.des.contains(searchChr)){
                        itemModal.add(item)
                        }
                    }
                      filterResults.count = itemModal.size
                      filterResults.values = itemModal


                }
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {

                itemsModallist=filterResults!!.values as ArrayList<ItemsModal>
                notifyDataSetChanged()
            }

        }
    }


}

