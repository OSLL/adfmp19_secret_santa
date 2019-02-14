package ru.hse.spb.secretsanta.data.statuses

/**
 * Type of a person. Person may be a participant of a festival or even its admin. The other possibility is that
 * person does not participate in any festival.
 */
enum class PersonType {
    NO_FESTIVAL, ADMIN, PARTICIPANT
}
