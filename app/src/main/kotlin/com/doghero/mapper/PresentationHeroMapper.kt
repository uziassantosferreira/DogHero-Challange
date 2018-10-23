package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.model.Hero
import com.doghero.model.PresentationHero

object PresentationHeroMapper: BaseMapper<Hero, PresentationHero>() {

    override fun transformFrom(source: PresentationHero): Hero {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Hero): PresentationHero = PresentationHero(
        isSuperHero = source.isSuperHero,
        user = PresentationUserMapper.transformTo(source.user),
        address = PresentationAddressMapper.transformTo(source.address),
        price = source.price
    )

}