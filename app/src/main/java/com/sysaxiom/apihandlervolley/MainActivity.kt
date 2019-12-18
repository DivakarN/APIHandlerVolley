package com.sysaxiom.apihandlervolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sysaxiom.apihandlervolley.Handler.ApiHandler
import com.sysaxiom.apihandlervolley.Handler.ServiceNetworkListener
import com.sysaxiom.apihandlervolley.Utils.ApiConstants
import com.sysaxiom.apihandlervolley.Utils.LogConstants
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInterest()

        val jsonObject = JSONObject()
        jsonObject.put(ApiConstants.postApiJsonName, ApiConstants.postApiJsonValue)
        updateInterest(jsonObject.toString())

    }

    //region Sample Get request
    fun getInterest(){
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
    fun updateInterest(jsonObject: String) {
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
