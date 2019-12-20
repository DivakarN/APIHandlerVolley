package com.sysaxiom.apihandlervolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sysaxiom.apihandlervolley.handler.ApiHandler
import com.sysaxiom.apihandlervolley.handler.ServiceNetworkListener
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleGetCall()

        val jsonObject = JSONObject()
        jsonObject.put("mobile", "9789926468")
        samplePostCall(jsonObject.toString())

    }

    //region Sample Get request
    fun sampleGetCall(){
        try {
            ApiHandler.getAyncNetworkCall("http://172.16.4.26:3090/getInterest", this, object : ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d("APIHandlerVolley",message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d("APIHandlerVolley",response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d("APIHandlerVolley", e.toString())
        }
    } //endregion

    //region Sample post request
    fun samplePostCall(jsonObject: String) {
        try {
            ApiHandler.postAsyncNetworkCall("http://172.16.4.26:3090/checkMobile", this, jsonObject, object : ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d("APIHandlerVolley", message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d("APIHandlerVolley", response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d("APIHandlerVolley", e.toString())
        }
    }//endregion

}
