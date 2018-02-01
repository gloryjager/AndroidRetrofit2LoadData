/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy

import io.reactivex.Single
import net.kentaku.api.kentaku.model.GetListPropertyResponse
import net.kentaku.api.kentaku.model.GetMatchPropNumberCommuteResponse
import net.kentaku.api.portal.model.GetListMergePropertyResponse
import net.kentaku.api.proxy.model.*
import retrofit2.http.*

/**
 * 代理APIのインターフェース
 * お問い合わせ, 物件検索(ValCode指定), 評価推奨, Push, お知らせ
 * Created by tsuyosh on 17/12/08.
 */
interface ProxyApi {
    @Headers(value = arrayOf(
            "Content-Type: application/json"
    ))
    @POST("sendDataInquiryTerminal")
    fun sendDataInquiryTerminal(@Body request: SendDataInquiryTerminalRequest): Single<SendDataInquiryTerminalResponse>

    @GET
    fun getListProperty(@Url url: String): Single<GetListPropertyResponse>

    @GET
    fun getListMergeProperty(@Url url: String): Single<GetListMergePropertyResponse>

    @GET
    fun getMatchPropNumberStationCommuteKentaku(@Url url: String): Single<GetMatchPropNumberCommuteResponse>

    @GET
    fun getMatchPropNumberStationCommutePortal(@Url url: String): Single<net.kentaku.api.portal.model.GetMatchPropNumberCommuteResponse>

    @GET
    fun getListPropertyStationCommutingKentaku(@Url url: String): Single<GetListPropertyResponse>

    @GET
    fun getListPropertyStationCommutingPortal(@Url url: String): Single<GetListMergePropertyResponse>

    @Headers(value = arrayOf(
            "Content-Type: application/json"
    ))
    @POST("feedback")
    fun feedback(@Body request: FeedbackRequest): Single<FeedbackResponse>

    @Headers(value = arrayOf(
            "Content-Type: application/json"
    ))
    @POST("setPushCondition")
    fun setPushCondition(@Body request: SetPushConditionRequest): Single<SetPushConditionResponse>

    @Headers(value = arrayOf(
            "Content-Type: application/json"
    ))
    @POST("deletePushConditions")
    fun deletePushConditions(@Body request: DeletePushConditionRequest): Single<DeletePushConditionResponse>

    @Headers(value = arrayOf(
            "Content-Type: application/json"
    ))
    @POST("updateDeviceToken")
    fun updateDeviceToken(@Body request: UpdateDeviceTokenRequest): Single<UpdateDeviceTokenResponse>
}