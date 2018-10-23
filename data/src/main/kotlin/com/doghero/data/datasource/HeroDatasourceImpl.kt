package com.doghero.data.datasource

import com.doghero.data.api.HeroService
import com.doghero.data.mapper.JsonHeroMapper
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import io.reactivex.Flowable

class HeroDatasourceImpl(private val heroService: HeroService): HeroDatasource {

    override fun getHeroes(): Flowable<HashMap<Category, List<Hero>>> {
        return heroService.getHeroes()
            .map {
                val hash = hashMapOf<Category, List<Hero>>()
                it.recents?.let {
                    hash.put(Category.RECENTS, JsonHeroMapper.transformFromList(it))
                }

                it.favorites?.let {
                    hash.put(Category.FAVORITES, JsonHeroMapper.transformFromList(it))
                }
                hash
        }
    }
}