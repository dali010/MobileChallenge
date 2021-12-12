package dali.hmida.mobilechallenge.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.provider.SyncStateContract

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dali.hmida.mobilechallenge.Constants
import dali.hmida.mobilechallenge.models.Picture
import dali.hmida.mobilechallenge.network.UnsplashService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class AppViewModel: ViewModel() {
    var photoList: MutableLiveData<List<Picture>> = MutableLiveData()


    fun getPictures(){
//            if (Constants.isNetworkAvailable(app)) {

                val retrofit : Retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service : UnsplashService = retrofit.create<UnsplashService>(UnsplashService::class.java)

                val listCall : Call<List<Picture>> = service
                    .getPhotos(
                        2,
                        30
                    )

                listCall.enqueue(object : Callback<List<Picture>> {

                    override fun onResponse(
                        call: Call<List<Picture>>,
                        response: Response<List<Picture>>
                    ) {
                        if (response.isSuccessful){
                            Log.i("test","test")
                             photoList.postValue(response.body())
                            Log.i("Response Result" , "${response.body()}")
                        }else{
                            val rc = response.code()
                            when(rc){
                                400 -> {
                                    Log.e("Error 400" , "Bad Connection")
                                }
                                404 -> {
                                    Log.e("Error 404" , "Not Found")
                                } else -> {
                                Log.e("Error" , "Generic Error")
                            }
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Picture>>, t: Throwable) {
                        Log.e("Errorrrrr" , "yaaaaaaaaa")                    }

                })

//            } else {
//                Log.e("error","error")
//            }
        }
    }


