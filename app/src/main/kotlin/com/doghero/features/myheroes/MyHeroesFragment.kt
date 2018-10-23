package com.doghero.features.myheroes

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.doghero.R
import com.doghero.base.BaseFragment
import com.doghero.data.HeroRepositoryImpl
import com.doghero.domain.rxjava.usecase.GetMyHeroes
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_myheroes.*

class MyHeroesFragment: BaseFragment() {

    private val adapter = SectionedRecyclerViewAdapter()

    private val repository = HeroRepositoryImpl()
    private val getMyHeroes = GetMyHeroes(repository)
    private val viewModel = GetHeroesViewModel(getMyHeroes)

    override fun layoutId(): Int = R.layout.fragment_myheroes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter

        subscribeToHeroes()
        viewModel.loadHeroes()
    }

    private fun subscribeToHeroes() {
        viewModel.heroes.observe(this,
            Observer { hash ->
                hash?.let { it ->
                    it.forEach {
                    adapter.addSection(HeroesSection(it.key, it.value, this))
                }
            }
        })
    }
}