package com.doghero.data.mapper

import com.doghero.data.model.JsonUser
import com.doghero.domain.rxjava.model.User
import com.doghero.domain.rxjava.util.InvalidData

object JsonUserMapper: BaseMapper<User, JsonUser>() {

    override fun transformFrom(source: JsonUser): User = User(
        source.firstName ?: InvalidData.UNINITIALIZED.getString(),
        source.imageUrl ?: InvalidData.UNINITIALIZED.getString())

    override fun transformTo(source: User): JsonUser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}