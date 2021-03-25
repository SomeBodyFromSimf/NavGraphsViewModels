package com.mihailchistousov.navgraphs.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.mihailchistousov.navgraphs.models.AdditionalInfo
import com.mihailchistousov.navgraphs.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDb: FirebaseDatabase
) : AuthRepo {

    override suspend fun signIn(email: String, password: String): FirebaseUser? {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return firebaseAuth.currentUser
    }

    override fun signUp(
        email: String,
        password: String,
        info: AdditionalInfo
    ): Flow<ResultState<Unit>> = flow {
        emit(ResultState.Loading)
        val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        authResult.user?.let {
            firebaseDb.getReference("users").child(it.uid).setValue(info).await()
            emit(ResultState.Success(Unit))
        } ?: emit(ResultState.Error(Exception("Что-то пошло не так")))
    }.catch { emit(ResultState.Error(Exception(it))) }
}

interface AuthRepo {
    suspend fun signIn(email: String, password: String): FirebaseUser?
    fun signUp(email: String, password: String, info: AdditionalInfo): Flow<ResultState<Unit>>
}
