package com.example.api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.modeldata.DetailSiswa
import com.example.api.modeldata.UIStateSiswa
import com.example.api.modeldata.toDataSiswa
import com.example.api.modeldata.toUiStateSiswa
import com.example.api.repositori.RepositoryDataSiswa
import com.example.api.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.Response

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoryDataSiswa
                .getSatuSiswa(idSiswa)
                .toUiStateSiswa(isEntryValid = true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean =
        uiState.nama.isNotBlank() && uiState.alamat.isNotBlank() && uiState.telpon.isNotBlank()

    suspend fun editSatuSiswa() {
        if (!validasiInput()) return

        val call: Response<Void> =
            repositoryDataSiswa.editSatuSiswa(idSiswa, uiStateSiswa.detailSiswa.toDataSiswa())

        if (call.isSuccessful) {
            println("Update Sukses : ${call.message()}")
        } else {
            println("Update Error : ${call.errorBody()}")
        }
    }
}
