package com.ramiroc.periodictable.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramiroc.periodictable.R
import com.ramiroc.periodictable.data.model.Element
import com.ramiroc.periodictable.ui.ElementViewModel
import kotlinx.android.synthetic.main.element_row.view.*

class ElementAdapter: RecyclerView.Adapter<ElementAdapter.MyViewHolder>() {
    private var elements: List<Element>? = null

    fun setElements(elements: List<Element>?){
        this.elements = elements
    }

    //inner class ElementViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvAtomicNumber = view.tvAtomicNumber
        val tvSymbol = view.tvSymbol
        val tvName = view.tvName
        val tvAtomicMass= view.tvAtomicMass
        val tvBlock = view.tvBlock

        fun bind(data: Element) {
            tvAtomicNumber.text = data.atomicNumber
            tvSymbol.text = data.symbol
            tvName.text = data.name
            tvAtomicMass.text = "1"
            tvBlock.text = data.block
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(elements?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return elements?.size ?: 0
    }
}