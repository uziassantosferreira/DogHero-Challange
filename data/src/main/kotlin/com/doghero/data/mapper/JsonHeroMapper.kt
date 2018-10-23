package com.doghero.data.mapper

import com.doghero.data.model.JsonHero
import com.doghero.data.model.JsonUser
import com.doghero.domain.rxjava.model.Address
import com.doghero.domain.rxjava.model.Hero
import com.doghero.domain.rxjava.util.InvalidData

object JsonHeroMapper: BaseMapper<Hero, JsonHero>() {

    override fun transformTo(source: Hero): JsonHero {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformFrom(source: JsonHero): Hero = Hero(
        isSuperHero = source.isSuperHero ?: InvalidData.UNINITIALIZED.getBoolean(),
        user = JsonUserMapper.transformFrom(source.user ?: JsonUser()),
        address = Address(source.addressNeighborhood ?: InvalidData.UNINITIALIZED.getString()),
        price = source.price ?: InvalidData.UNINITIALIZED.getLong()
    )

}