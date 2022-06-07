package com.assignment.plantix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.plantix.databinding.ItemNamesBinding
import com.assignment.plantix.domain.NamesModel

class UsersListAdapter(): ListAdapter<NamesModel, UsersListAdapter.ViewHolder>(UsersListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemNamesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NamesModel) {
            var nameItem: NamesModel =  item
            nameItem.name = capitalize(nameItem.name)
            binding.data = nameItem
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNamesBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

fun capitalize(str: String?): String? {
    return str!!.trim().split("\\s+".toRegex())
        .joinToString(" ") { it.capitalize() }
}

class UsersListDiffCallback : DiffUtil.ItemCallback<NamesModel>() {

    override fun areItemsTheSame(oldItem: NamesModel, newItem: NamesModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: NamesModel, newItem: NamesModel): Boolean {
        return oldItem == newItem
    }

}