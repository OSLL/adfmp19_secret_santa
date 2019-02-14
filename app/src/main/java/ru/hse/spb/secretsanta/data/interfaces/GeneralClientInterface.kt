package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.PersonId
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException
import ru.hse.spb.secretsanta.data.statuses.PersonType

/**
 * General client interface. Interface allows to perform various general-purpose read and write
 * requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this interface directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface GeneralClientInterface {
    /**
     * Request [PersonType] based on this person id.
     *
     * @param personId id of a person.
     * @returns [PersonType] of a person with a given [PersonId].
     */
    fun getPersonType(personId: PersonId): PersonType
}
