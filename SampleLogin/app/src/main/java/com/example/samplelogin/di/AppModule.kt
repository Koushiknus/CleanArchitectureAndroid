package com.example.samplelogin.di

import com.example.samplelogin.LoginRepository
import com.example.samplelogin.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLoginRepository(): LoginRepository {
            return LoginRepositoryImpl()
    }

}