package com.doghero.data

import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import com.doghero.domain.rxjava.repository.HeroRepository
import io.reactivex.Flowable
import java.util.*

class HeroRepositoryImpl: HeroRepository {

    override fun getHeroes(): Flowable<HashMap<Category, List<Hero>>> {
        return Flowable.just(hashMapOf(Category.FAVORITES to listOf(provideHero(), provideHero(), provideHero())))
}

    private fun provideHero(): Hero {
        return Hero(isSuperHero = Random().nextBoolean(),
            user = User("UZIAS SANTOS FERREIRA",
                "https://osegredo.com.br/wp-content/uploads/2017/07/9-maneiras-de-se-tornar-uma-pessoa-melhor-830x450.jpg"),
            address = Address("vila marianaanasa"),
            price = 100
        )
    }
}