package com.example.samplelogin

class FakeLoginRepository() : LoginRepository  {
    override fun mapFunction(): List<String> {
        return emptyList()
    }

    override fun mapIndex(): List<String> {
        return emptyList()

    }

    override fun mapNotNull(): List<String> {
        return emptyList()

    }

    override fun iterateMap(): List<String> {
        return emptyList()

    }


}