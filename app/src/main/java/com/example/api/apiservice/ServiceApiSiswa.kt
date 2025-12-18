package com.example.api.apiservice

import com.example.api.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa {
    @GET(value="bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST(value="insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): retrofit2.Response<Void>

   /// @GET("baca1teman.php/{id}")
    ///suspend fun GetSatuSiswa(@Query("id")id: Int) DataSiswa

    ///@PUT("editTM.php/{id}")
   /// suspend fun editSatuSiswa(@query("id") id: INT,@Body dataSiswa): retrofit2Response<Void>
}