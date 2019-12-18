package com.sysaxiom.apihandlervolley.utils

class LogConstants{
    companion object{
        const val TAG = "APIHandlerVolley"
    }
}

class ApiConstants{
    companion object{
        const val baseUrl = "http://172.16.4.26:3090/"
        const val getApi = baseUrl+"getInterest"
        const val postApi = baseUrl+"checkMobile"
        const val postApiJsonName = "mobile"
        const val postApiJsonValue = "9789926460"
    }
}