/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val dataSet = DataSource.dogs


    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        val dogName: TextView? = view?.findViewById(R.id.dog_name)
        val dogImage: ImageView? = view?.findViewById(R.id.dog_image)
        val dogAge: TextView? = view?.findViewById(R.id.dog_age)
        val dogDesc: TextView? = view?.findViewById(R.id.dog_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        var adapterLayout: View = if (layout == 3) {
            LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)

        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false)

        }
        return DogCardViewHolder(view = adapterLayout)
    }

    override fun getItemCount(): Int =
        dataSet.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context?.resources

        val data = dataSet[position]

        holder.dogImage?.setImageResource(data.imageResourceId)

        holder.dogName?.text = data.name

        holder.dogAge?.text = resources?.getString(R.string.dog_age,data.age)

        holder.dogDesc?.text = resources?.getString(R.string.dog_hobbies,data.hobbies)

    }
}
