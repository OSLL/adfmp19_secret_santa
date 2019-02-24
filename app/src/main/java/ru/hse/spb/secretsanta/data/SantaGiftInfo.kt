package ru.hse.spb.secretsanta.data

import ru.hse.spb.secretsanta.data.statuses.SantaGiftStatus

/**
 * In the end of a festival each person marks whether or not he/she has received a gift. Based on this
 * information [SantaGiftStatus] is assigned to each santa. This class is an entry for one santa which
 * contains recipient's [PersonId]s and [SantaGiftStatus].
 */
class SantaGiftInfo(
    val giftRecipientId: PersonId,
    val santaGiftStatus: SantaGiftStatus
)
