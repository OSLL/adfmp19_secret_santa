package ru.hse.spb.secretsanta.data.contexts

import ru.hse.spb.secretsanta.data.FestivalId
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException

/**
 * Client context of a user who is not a participant of any festival. Context allows to perform various
 * read and write requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this context directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface NoFestivalClientContext {
    /**
     * Creates a festival with a given [FestivalId].
     *
     * @param festivalId id of a new festival.
     */
    fun createFestival(festivalId: FestivalId)

    /**
     * Person that uses this particular client joins a festival with a given [FestivalId].
     *
     * @param festivalId if of a festival to join to.
     */
    fun joinFestival(festivalId: FestivalId)
}
