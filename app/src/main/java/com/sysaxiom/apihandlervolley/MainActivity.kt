package com.sysaxiom.apihandlervolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sysaxiom.apihandlervolley.Handler.ApiHandler
import com.sysaxiom.apihandlervolley.Handler.ServiceNetworkListener
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getInterest()
        var jsonObject = JSONObject()
        jsonObject?.put("mobile", "9789926460")
        updateInterest(jsonObject.toString())
    }

    //Sample Get request
    fun getInterest(){
        try {
            val task_list_api = "http://focozon.com:3090/getInterest"
            ApiHandler.getAyncNetworkCall(task_list_api, this, object : ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d("Volley",message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d("Volley",response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d("RapidTurnAround", e.toString())
        }

    }

    //Sample post request
    fun updateInterest(jsonObject: String) {
        try {
            val task_action_api = "http://focozon.com:3090/checkMobile"
            ApiHandler.postAsyncNetworkCall(task_action_api, this, jsonObject, object :
                ServiceNetworkListener {
                override fun onError(message: String) {
                    Log.d("JsonData", message)
                }

                override fun onResponse(response: JSONObject) {
                    Log.d("JsonData", response.toString())
                }
            })
        } catch (e: Exception) {
            Log.d("RapidTurnAround", e.toString())
        }
    }
}
