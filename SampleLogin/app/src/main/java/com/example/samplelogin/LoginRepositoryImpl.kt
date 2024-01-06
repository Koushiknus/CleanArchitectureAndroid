package com.example.samplelogin

import com.example.samplelogin.data.Person

class LoginRepositoryImpl()  : LoginRepository {

    var people = listOf<Person>(
        Person("Jaya","N","INR",21),
        Person("Koushik","R","Pakistan",21)
    )
    var cityStates = buildMap<String,String> {
        put("Chennai","TamilNadu")
        put("Mumbai","Maharastra")
        put("Banglore","Karnataka")
    }
    override fun mapFunction(): List<String> {
        val transformedList = people.map { it.firstName }
        println("MapResultIs*Repository$transformedList")
        val mergeNames= people.map { "($it.lastName) (${it.firstName}) " }
        println("MergeNamesIs$mergeNames")
        return transformedList
    }

    override fun mapIndex(): List<String> {
        val transform  = people.mapIndexed { index, person -> "$index _ ${person.firstName}"  }
        println("MapIndexIs$transform")
        return transform
    }

    override fun mapNotNull(): List<String> {
        val transform = people.mapNotNull { if(it.nationality !== "INR")it.firstName else null }
        println("MapNotNull$transform")
        return transform
    }

    override fun iterateMap(): List<String> {
        val transform  = cityStates.map { entry: Map.Entry<String, String> -> entry.key  }
        println("IterateMap$transform")
        val keys = cityStates.mapKeys { it.key.uppercase() }
        println("IterateKeys$keys")
        return transform
    }


}