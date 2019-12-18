package com.sysaxiom.apihandlervolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sysaxiom.apihandlervolley.handler.ApiHandler
import com.sysaxiom.apihandlervolley.handler.ServiceNetworkListener
import com.sysaxiom.apihandlervolley.utils.ApiConstants
import com.sysaxiom.apihandlervolley.utils.LogConstants
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleGetCall()

        val jsonObject = JSONObject()
        jsonObject.put(ApiConstants.postApiJsonName, ApiConstants.postApiJsonValue)
        samplePostCall(jsonObject.toString())

    }

    //region Sample Get request
    fun sampleGetCall(){
        try {
            ApiHandler.getAyncNetworkCall(ApiConstants.getApi, this, object : ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d(LogConstants.TAG,message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d(LogConstants.TAG,response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d(LogConstants.TAG, e.toString())
        }
    } //endregion

    //region Sample post request
    fun samplePostCall(jsonObject: String) {
        try {
            ApiHandler.postAsyncNetworkCall(ApiConstants.postApi, this, jsonObject, object : ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d(LogConstants.TAG, message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d(LogConstants.TAG, response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d(LogConstants.TAG, e.toString())
        }
    }//endregion

}
