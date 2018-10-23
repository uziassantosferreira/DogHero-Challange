package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.model.User
import com.doghero.model.PresentationUser

object PresentationUserMapper: BaseMapper<User, PresentationUser>() {

    override fun transformFrom(source: PresentationUser): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: User): PresentationUser =
        PresentationUser(source.firstName, source.imageUrl)

}