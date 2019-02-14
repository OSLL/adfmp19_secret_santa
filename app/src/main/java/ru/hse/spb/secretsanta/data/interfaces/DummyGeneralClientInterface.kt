package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.PersonId
import ru.hse.spb.secretsanta.data.statuses.PersonType

class DummyGeneralClientInterface : GeneralClientInterface {
    override fun getPersonType(personId: PersonId): PersonType {
        return PersonType.NO_FESTIVAL
    }
}
