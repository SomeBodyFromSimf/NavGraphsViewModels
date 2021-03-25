package com.mihailchistousov.navgraphs.di

import android.content.Context
import android.content.res.Resources
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mihailchistousov.navgraphs.data.AuthRepo
import com.mihailchistousov.navgraphs.data.AuthRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import kotlin.random.Random


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    @Named("APP_STR")
    fun provideAppStr(): String = "appStr: ${Random.nextInt(0, 100000)}"

    @Singleton
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun provideAuthRepo(firebaseAuth: FirebaseAuth, firebaseDatabase: FirebaseDatabase): AuthRepo =
        AuthRepoImpl(firebaseAuth, firebaseDatabase)

    @Singleton
    @Provides
    fun provideFireBaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFireBaseDb() = FirebaseDatabase.getInstance()
}

@Module
@InstallIn(ViewModelComponent::class)
class VMModule {

    @ViewModelScoped
    @Provides
    @Named("VM_STR")
    fun provideVMStr(): String = "vmStr: ${Random.nextInt(0, 100000)}"
}