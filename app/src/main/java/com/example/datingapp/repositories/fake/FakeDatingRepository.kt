package com.example.datingapp.repositories.fake

import com.example.datingapp.models.DatingProfile
import com.example.datingapp.models.Match
import com.example.datingapp.repositories.DatingRepository

class FakeDatingRepository : DatingRepository {
    private val likedProfileIds = mutableSetOf<String>()
    private val skippedProfileIds = mutableSetOf<String>()
    private val matches = mutableListOf<Match>()

    private val profiles = mutableListOf<DatingProfile>(
        DatingProfile(
            id = "profile_1",
            name = "Анна",
            age = 24,
            city = "Москва",
            about = "Люблю путешествия, кофе и прогулки по городу.",
            photoUrl = null
        ),
        DatingProfile(
            id = "profile_2",
            name = "Мария",
            age = 27,
            city = "Санкт-Петербург",
            about = "Занимаюсь йогой, читаю книги и люблю собак.",
            photoUrl = null
        ),
        DatingProfile(
            id = "profile_3",
            name = "Екатерина",
            age = 22,
            city = "Казань",
            about = "Люблю кино, вечерние прогулки и хорошую музыку.",
            photoUrl = null
        ),
        DatingProfile(
            id = "profile_4",
            name = "Ольга",
            age = 29,
            city = "Новосибирск",
            about = "Ищу интересное общение и человека с чувством юмора.",
            photoUrl = null
        ),
        DatingProfile(
            id = "profile_5",
            name = "София",
            age = 25,
            city = "Екатеринбург",
            about = "Фотография, спорт и спонтанные поездки — это про меня.",
            photoUrl = null
        )
    )

    private val profilesWhoLikedCurrentUser = setOf<String>(
        "profile_1",
        "profile_3",
        "profile_5"
    )

    init {
        // Сразу добавляем готовые мэтчи
        val profile1 = profiles.find { it.id == "profile_1" }!!
        val profile3 = profiles.find { it.id == "profile_3" }!!
        val profile5 = profiles.find { it.id == "profile_5" }!!

        matches.add(Match(id = "match_profile_1", matchProfile = profile1))
        matches.add(Match(id = "match_profile_3", matchProfile = profile3))
        matches.add(Match(id = "match_profile_5", matchProfile = profile5))

        likedProfileIds.addAll(listOf("profile_1", "profile_3", "profile_5"))
    }
    override fun getProfiles(): List<DatingProfile> {
        val unavailableProfileIds = likedProfileIds +
                skippedProfileIds +
                matches.map {match -> match.matchProfile.id}
        return profiles.filter { profile -> profile.id !in unavailableProfileIds}
    }

    override fun likeProfile(profileId: String): Match? {
        likedProfileIds.add(profileId)

        val profile = profiles.find { profile -> profile.id == profileId
        }?: return null

        val isMatch = profileId in profilesWhoLikedCurrentUser

        if (!isMatch) {
            return null
        }

        val existingMatch = matches.find { match -> match.matchProfile.id == profileId}

        if (existingMatch != null) {
            return existingMatch
        }

        val match = Match(
            id = "match_${profile.id}",
            matchProfile = profile
        )

        matches.add(match)

        return match
    }

    override fun skipProfile(profileId: String) {
        skippedProfileIds.add(profileId)
    }

    override fun getMatches(): List<Match> {
        return matches
    }

    override fun getMatchById(matchId: String): Match? {
        return matches.find {match ->
            match.id == matchId
        }
    }

}