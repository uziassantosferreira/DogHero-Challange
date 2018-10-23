package com.doghero.features.myheroes

import android.os.Bundle
import android.view.View
import com.doghero.R
import com.doghero.base.BaseFragment
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_myheroes.*

class MyHeroesFragment: BaseFragment() {

    private val adapter = SectionedRecyclerViewAdapter()

    override fun layoutId(): Int = R.layout.fragment_myheroes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.addSection(HeroesSection(PresentationCategory.FAVORITES,
            listOf(PresentationHero(), PresentationHero(), PresentationHero())))
        adapter.addSection(HeroesSection(PresentationCategory.RECENTS,
            listOf(PresentationHero(), PresentationHero(), PresentationHero())))
    }
}