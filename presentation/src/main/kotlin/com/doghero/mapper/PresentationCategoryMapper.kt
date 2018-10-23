package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Category.*
import com.doghero.model.PresentationCategory

object PresentationCategoryMapper: BaseMapper<Category, PresentationCategory>() {
    override fun transformFrom(source: PresentationCategory): Category {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Category): PresentationCategory =
        when(source) {
        RECENTS -> PresentationCategory.RECENTS
        FAVORITES -> PresentationCategory.FAVORITES
    }
}