package com.doghero.features.myheroes

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.doghero.R
import com.doghero.base.BaseFragment
import com.doghero.exception.PresentationFailure
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import kotlinx.android.synthetic.main.container_empty_view.view.*
import kotlinx.android.synthetic.main.fragment_myheroes.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MyHeroesFragment: BaseFragment() {

    private val adapter: SectionedRecyclerViewAdapter by inject()

    private val getHeroes: GetHeroesViewModel by viewModel()

    override fun layoutId(): Int = R.layout.fragment_myheroes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter

        subscribeToHeroes()
        getHeroes.loadHeroes()
    }

    private fun subscribeToHeroes() {
        containerLoading.visibility = View.VISIBLE
        getHeroes.heroes.observe(this,
            Observer { hash ->
                containerLoading.visibility = View.GONE
                hash?.let { it ->
                    if (it.isEmpty()){
                        showEmptyView()
                        return@let
                    }
                    it.forEach {
                    adapter.addSection(HeroesSection(it.key, it.value, this))
                }
            }
        })

        getHeroes.failure.observe(this, Observer {
            containerLoading.visibility = View.GONE
            it?.let {
                showErrorView(it)
            }
        })
    }

    private fun showEmptyView() {
        containerEmptyView.visibility = View.VISIBLE
        containerEmptyView.textViewEmptyView.setText(R.string.msg_my_heroes_empty)
    }

    private fun showErrorView(presentationFailure: PresentationFailure) {
        containerEmptyView.visibility = View.VISIBLE
        containerEmptyView.textViewEmptyView.setText(presentationFailure.getMessage())
    }
}