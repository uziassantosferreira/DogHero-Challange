package com.doghero.data

import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import com.doghero.domain.rxjava.repository.HeroRepository
import io.reactivex.Flowable
import java.util.*
import java.util.concurrent.TimeUnit

class HeroRepositoryImpl: HeroRepository {

    override fun getHeroes(): Flowable<HashMap<Category, List<Hero>>> {
        return Flowable.just(hashMapOf(Category.FAVORITES to listOf(provideHero(), provideHero(), provideHero()))).delay(3000,
            TimeUnit.MILLISECONDS)
    }

    private fun provideHero(): Hero {
        return Hero(isSuperHero = Random().nextBoolean(),
            user = User("UZIAS SANTOS FERREIRA",
                "https://doghero-uploads-dev.s3.amazonaws.com/uploads/photo/433367/sq135_147 6480114177_736191_avatar.jpg"),
            address = Address("vila marianaanasa"),
            price = 100
        )
    }
}