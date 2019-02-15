package ru.hse.spb.secretsanta.data.contexts

import ru.hse.spb.secretsanta.data.FestivalId
import ru.hse.spb.secretsanta.data.exceptions.ClientErrorException

class DummyNoFestivalClientContext : NoFestivalClientContext {
    override fun createFestival(festivalId: FestivalId) {
    }

    override fun joinToFestival(festivalId: FestivalId) {
        throw ClientErrorException("There is no festival with given id.")
    }
}
