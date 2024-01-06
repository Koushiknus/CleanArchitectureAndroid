package com.example.architectureplayground

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var people = listOf<Person>(
        Person("Jaya","N","INR",21),
         Person("Koushik","R","Pakistan",21)
    )
    var cityStates = buildMap<String,String> {
        put("Chennai","TamilNadu")
        put("Mumbai","Maharastra")
        put("Banglore","Karnataka")
    }
    fun mapFunction(){
        val transformedList = people.map { it.lastName }
        println("MapResultIs$transformedList")
        val mergeNames= people.map { "($it.lastName) (${it.firstName}) " }
        println("MergeNamesIs$mergeNames")

    }

    fun mapIndex(){
        val transform  = people.mapIndexed { index, person -> "$index _ ${person.firstName}"  }
        println("MapIndexIs$transform")
    }

    fun mapNotNull(){
        val transform = people.mapNotNull { if(it.nationality !== "INR")it.firstName else null }
        println("MapNotNull$transform")
    }

    fun iterateMap(){
        val transform  = cityStates.map { entry: Map.Entry<String, String> -> entry.key  }
        println("IterateMap$transform")
        val keys = cityStates.mapKeys { it.key.uppercase() }
        println("IterateKeys$keys")
    }
}