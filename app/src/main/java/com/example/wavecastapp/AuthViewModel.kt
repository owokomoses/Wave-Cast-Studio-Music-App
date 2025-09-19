package com.example.wavecastapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for handling authentication state in the WaveCast app
 */
class AuthViewModel : ViewModel() {
    
    // Authentication state
    private val _authState = MutableLiveData<AuthState>(AuthState.NotAuthenticated)
    val authState: LiveData<AuthState> = _authState
    
    /**
     * Authentication states for the app
     */
    sealed class AuthState {
        object NotAuthenticated : AuthState()
        object Authenticated : AuthState()
        object Loading : AuthState()
    }
}