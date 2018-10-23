package com.doghero.fake

import com.doghero.domain.rxjava.model.Category
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.model.User
import com.doghero.domain.rxjava.repository.HeroRepository
import com.doghero.fake.FakeStatus.*
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import kotlin.Exception

class FakeHeroRepository: HeroRepository {

    companion object {
        var fakeStatus = SUCCESS
    }

    override fun getHeroes(): Flowable<HashMap<Category, List<Hero>>> {
        return when(fakeStatus){
            LOADING -> Flowable.interval(1000, 5000, TimeUnit.MILLISECONDS)
                .map { hashMapOf<Category, List<Hero>>() }
            SUCCESS -> Flowable.just(hashMapOf(Category.FAVORITES to listOf(Hero(user = User("Test")))))
            FAILURE -> Flowable.error(Exception())
        }
    }
}