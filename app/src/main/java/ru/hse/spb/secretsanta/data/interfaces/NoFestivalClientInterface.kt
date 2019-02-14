package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.FestivalId
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException

/**
 * Client interface of a user who is not a participant of any festival. Interface allows to perform various
 * read and write requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this interface directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface NoFestivalClientInterface {
    /**
     * Creates a festival with a given [FestivalId].
     *
     * @param festivalId id of a new festival.
     */
    fun createFestival(festivalId: FestivalId)

    /**
     * Person that uses this particular client joins to a festival with a given [FestivalId].
     *
     * @param festivalId if of a festival to join to.
     */
    fun joinToFestival(festivalId: FestivalId)
}
