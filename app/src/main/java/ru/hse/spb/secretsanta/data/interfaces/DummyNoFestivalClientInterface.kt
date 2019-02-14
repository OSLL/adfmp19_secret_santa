package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.FestivalId
import ru.hse.spb.secretsanta.data.exceptions.ClientErrorException

class DummyNoFestivalClientInterface : NoFestivalClientInterface {
    override fun createFestival(festivalId: FestivalId) {
    }

    override fun joinToFestival(festivalId: FestivalId) {
        throw ClientErrorException("There is no festival with given id.")
    }
}
