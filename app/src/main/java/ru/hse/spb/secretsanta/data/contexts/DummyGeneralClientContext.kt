package ru.hse.spb.secretsanta.data.contexts

import ru.hse.spb.secretsanta.data.PersonId
import ru.hse.spb.secretsanta.data.statuses.PersonType

class DummyGeneralClientContext : GeneralClientContext {
    override fun requestPersonType(personId: PersonId): PersonType {
        return PersonType.NO_FESTIVAL
    }
}
