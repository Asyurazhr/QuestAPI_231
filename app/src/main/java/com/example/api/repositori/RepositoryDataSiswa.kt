package com.example.api.repositori

import com.example.api.apiservice.ServiceApiSiswa
import com.example.api.modeldata.DataSiswa


interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void>
}
