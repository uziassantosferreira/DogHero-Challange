package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.model.PresentationCategory
import com.doghero.model.PresentationHero

object PresentationMyHeroesMapper: BaseMapper<HashMap<Category, List<Hero>>,
        HashMap<PresentationCategory, List<PresentationHero>>>() {

    override fun transformFrom(source: HashMap<PresentationCategory, List<PresentationHero>>): HashMap<Category, List<Hero>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: HashMap<Category, List<Hero>>): HashMap<PresentationCategory, List<PresentationHero>> {
        val hash: HashMap<PresentationCategory, List<PresentationHero>> = hashMapOf()
        source.forEach {
            hash[PresentationCategoryMapper.transformTo(it.key)] = PresentationHeroMapper.transformToList(it.value)
        }
        return hash
    }
}