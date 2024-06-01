package com.example.sapcexapplication.di

import com.example.sapcexapplication.common.Constants
import com.example.sapcexapplication.data.remote.SpacexApi
import com.example.sapcexapplication.data.repository.CapsuleRepositoryImplementation
import com.example.sapcexapplication.domain.repository.CapsuleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSpacexApi(): SpacexApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpacexApi::class.java)
    }
    @Provides
    @Singleton
    fun provideCapsuleRepository(api: SpacexApi): CapsuleRepository {
        return CapsuleRepositoryImplementation(api)
    }
}