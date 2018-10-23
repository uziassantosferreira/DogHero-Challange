package com.doghero.mapper

import com.doghero.base.BaseMapper
import com.doghero.domain.rxjava.model.Address
import com.doghero.model.PresentationAddress

object PresentationAddressMapper: BaseMapper<Address, PresentationAddress>() {

    override fun transformFrom(source: PresentationAddress): Address {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: Address): PresentationAddress = PresentationAddress(source.neighborhood)

}