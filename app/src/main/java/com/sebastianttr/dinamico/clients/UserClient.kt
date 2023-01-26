package com.sebastianttr.dinamico.clients

import com.sebastianttr.dinamico.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserClient {

    @POST("userAuth")
    suspend fun authUser(@Body user : User) : Response<User>

    @POST("addUser")
    suspend fun addUser(@Body user : User) : Response<String>

    @POST("deleteUser")
    suspend fun deleteUser(@Body user : User) : Response<String>

    @POST("updateUser")
    suspend fun updateUser(@Body user : User) : Response<String>

    @POST("addOwnedModelToUser")
    suspend fun addOwnedCarModel(@Body user : User) : Response<String>

    @POST("getOwnedModelOfUser")
    suspend fun getOwnedCarModel(@Body user : User) : Response<List<Int>>

}