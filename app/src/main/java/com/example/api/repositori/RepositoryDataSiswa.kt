package com.example.api.repositori

import com.example.api.apiservice.ServiceApiSiswa
import com.example.api.modeldata.DataSiswa


interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa : DataSiswa):retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}