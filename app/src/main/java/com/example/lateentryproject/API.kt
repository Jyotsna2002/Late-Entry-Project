package com.example.lateentryproject

import com.example.lateentryproject.apiCalls.LoginReqBody
import com.example.lateentryproject.apiCalls.LoginResp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
	@POST("auth/login/")
	fun login(@Body loginReqBody: LoginReqBody) : Call<LoginResp>

}