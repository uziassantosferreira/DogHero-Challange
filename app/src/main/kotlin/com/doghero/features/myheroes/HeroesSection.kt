package com.doghero.features.myheroes

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.doghero.R
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection
import kotlinx.android.synthetic.main.list_item_hero.view.*

class HeroesSection(private val category: PresentationCategory,
                    private val heroes: List<PresentationHero>,
                    private val fragment: Fragment): StatelessSection(
    SectionParameters.builder()
    .itemResourceId(R.layout.list_item_hero)
    .headerResourceId(R.layout.list_header)
    .build()) {

    override fun getContentItemsTotal(): Int = heroes.size

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val hero = heroes[position]
        holder?.itemView?.let {
            it.textViewName.text = hero.user.firstName
            it.textViewNeighborhood.text = hero.address.neighborhood
            it.textViewPrice.text = hero.getPriceFormatted()
            Glide.with(fragment)
                .load(hero.user.imageUrl)
                .apply(RequestOptions.circleCropTransform()
                    .placeholder(R.drawable.ic_person))
                .into(holder.itemView.imageViewUser)

            it.imageViewSuperHero.visibility = if(hero.isSuperHero) View.VISIBLE else View.GONE
        }
    }

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder =
        SectionedRecyclerViewAdapter.EmptyViewHolder(view)

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        (holder?.itemView as TextView).setText(category.getTitle())
    }
}