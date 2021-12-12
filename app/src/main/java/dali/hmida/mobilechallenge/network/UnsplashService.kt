package dali.hmida.mobilechallenge.network

import dali.hmida.mobilechallenge.Constants
import dali.hmida.mobilechallenge.models.Picture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UnsplashService {

    @GET( "photos/?client_id=${Constants.CLIENT_ID}")
    fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int
    ) : Call<List<Picture>>
}