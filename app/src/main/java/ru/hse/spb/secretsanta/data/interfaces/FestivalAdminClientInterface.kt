package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.FestivalRules
import ru.hse.spb.secretsanta.data.PersonId
import ru.hse.spb.secretsanta.data.SantaGiftInfo
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException
import ru.hse.spb.secretsanta.data.statuses.FestivalMode

/**
 * Client interface of an admin of a festival. Interface allows to perform various read and write
 * requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this interface directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface FestivalAdminClientInterface : FestivalParticipantClientInterface {
    /**
     * A map that for each santa contains his/her [SantaGiftInfo].
     */
    val giftsInfo: Map<PersonId, SantaGiftInfo>

    /**
     * Starts this festival.
     */
    fun startFestival()

    /**
     * Changes rules of this festival.
     *
     * @param newRules new rules of this festival that completely replace the old ones.
     */
    fun changeRules(newRules: FestivalRules)

    /**
     * Removes person from list of participants of this festival.
     *
     * @param personId an id of a person to remove.
     */
    fun kickPerson(personId: PersonId)

    /**
     * Destroys this festival.
     */
    fun destroyFestival()
}
