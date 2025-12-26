package com.example.api.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.api.repositori.AplikasiDataSiswa
import com.example.api.viewmodel.DetailViewModel
import com.example.api.viewmodel.EditViewModel
import com.example.api.viewmodel.EntryViewModel
import com.example.api.viewmodel.HomeViewModel

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }

        initializer {
            EntryViewModel(
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }

        initializer {
            DetailViewModel(
                savedStateHandle = createSavedStateHandle(),
                repositoryDataSiswa = aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }

        initializer {
            EditViewModel(
                savedStateHandle = createSavedStateHandle(),
                repositoryDataSiswa = aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
    }
}
