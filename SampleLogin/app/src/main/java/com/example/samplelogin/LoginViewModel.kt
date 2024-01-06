package com.example.samplelogin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.samplelogin.data.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor (application: Application, val loginRepository: LoginRepository) : AndroidViewModel(application) {


    fun getUserNameErrorMessage() : String {
        return getApplication<Application>().resources.getString(R.string.et_enter_user_name)
    }


    fun mapFunction() :List<String> {
        return loginRepository.mapFunction()

    }

    fun mapIndex(): List<String> {
      return loginRepository.mapIndex()
    }

    fun mapNotNull(): List<String> {
       return loginRepository.mapNotNull()
    }

    fun iterateMap() : List<String>{
     return loginRepository.iterateMap()
    }

}