package ru.hse.spb.secretsanta.data.contexts

import ru.hse.spb.secretsanta.data.PersonId
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException
import ru.hse.spb.secretsanta.data.statuses.PersonType

/**
 * General client context. Context allows to perform various general-purpose read and write
 * requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this context directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface GeneralClientContext {
    /**
     * Request [PersonType] based on this person id.
     *
     * @param personId id of a person.
     * @returns [PersonType] of a person with a given [PersonId].
     */
    fun requestPersonType(personId: PersonId): PersonType
}
