package com.example.samplelogin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.samplelogin.data.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (application: Application) : AndroidViewModel(application) {


    fun getUserNameErrorMessage() : String {
        return getApplication<Application>().resources.getString(R.string.et_enter_user_name)
    }

    var people = listOf<Person>(
        Person("Jaya","N","INR",21),
        Person("Koushik","R","Pakistan",21)
    )
    var cityStates = buildMap<String,String> {
        put("Chennai","TamilNadu")
        put("Mumbai","Maharastra")
        put("Banglore","Karnataka")
    }
    fun mapFunction() :List<String> {
        val transformedList = people.map { it.firstName }
        println("MapResultIs$transformedList")
        val mergeNames= people.map { "($it.lastName) (${it.firstName}) " }
        println("MergeNamesIs$mergeNames")
        return transformedList

    }

    fun mapIndex(): List<String> {
        val transform  = people.mapIndexed { index, person -> "$index _ ${person.firstName}"  }
        println("MapIndexIs$transform")
        return transform
    }

    fun mapNotNull(): List<String> {
        val transform = people.mapNotNull { if(it.nationality !== "INR")it.firstName else null }
        println("MapNotNull$transform")
        return transform
    }

    fun iterateMap() : List<String>{
        val transform  = cityStates.map { entry: Map.Entry<String, String> -> entry.key  }
        println("IterateMap$transform")
        val keys = cityStates.mapKeys { it.key.uppercase() }
        println("IterateKeys$keys")
        return transform
    }

}