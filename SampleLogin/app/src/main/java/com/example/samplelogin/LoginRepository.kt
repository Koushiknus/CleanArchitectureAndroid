package com.example.samplelogin

interface LoginRepository {

    fun mapFunction() :List<String>
    fun mapIndex(): List<String>

    fun mapNotNull(): List<String>

    fun iterateMap() : List<String>
}