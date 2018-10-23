package com.doghero.features.myheroes

import android.view.View
import com.agoda.kakao.*
import com.doghero.R
import com.doghero.R.id.recyclerView as recyclerViewId
import com.doghero.R.id.textViewName
import org.hamcrest.Matcher

class TestMyHeroes : Screen<TestMyHeroes>() {

    val loading: KView = KView { withId(R.id.containerLoading) }

    val emptyView: KView = KView { withId(R.id.containerEmptyView) }

    val recyclerView: KRecyclerView = KRecyclerView({
        withId(recyclerViewId)
    }, itemTypeBuilder = {
        itemType(::Item)
    })

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val title: KTextView = KTextView(parent) { withId(textViewName) }
    }
}