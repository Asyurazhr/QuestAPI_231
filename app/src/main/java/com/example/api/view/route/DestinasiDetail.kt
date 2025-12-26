package com.example.api.view.route

import com.example.api.R

object DestinasiDetail : DestinasiNavigasi {
    override val route: String = "detail_siswa"
    override val titleRes: Int = R.string.detail_siswa

    const val itemIdArg = "idSiswa"
    val routeWithArgs: String = "$route/{$itemIdArg}"
}
