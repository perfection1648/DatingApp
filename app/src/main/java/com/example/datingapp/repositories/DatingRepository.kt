package com.example.datingapp.repositories

import com.example.datingapp.models.DatingProfile
import com.example.datingapp.models.Match

interface DatingRepository {

    fun getProfiles(): List<DatingProfile>

    fun likeProfile(profileId: String): Match?

    fun skipProfile(profileId: String)

    fun getMatches(): List<Match>

    fun getMatchById(matchId: String): Match?

}