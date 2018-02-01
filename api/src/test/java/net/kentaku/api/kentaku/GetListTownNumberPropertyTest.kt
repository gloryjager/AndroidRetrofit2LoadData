/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import net.kentaku.api.kentaku.model.GetListTownNumberPropertyResponse
import org.junit.Test

/**
 * Created by tsuyosh on 17/10/12.
 */

class GetListTownNumberPropertyTest : KentakuApiTest() {
    @Test
    fun testMoshi() {
        val json = """
{"result":0,"message":"","towns":[{"city_id":13101,"town_id":"003","town_name":"岩本町","property_count":1},{"city_id":13101,"town_id":"016","town_name":"神田紺屋町","property_count":1}]}
"""
        val adapter = moshi.adapter(GetListTownNumberPropertyResponse::class.java)
        val response = adapter.fromJson(json)
        println(response)
    }

    @Test
    fun testGetListCityNumberProperty() {
        val response = api.getListTownNumberProperty("/kentakuapi/callApp.jsp?function=GetListTownNumberProperty&auth_code=218993f4634&entry_date=201708301655&city_id=13102")
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()

        println(response)
        println(response?.towns?.size)
        response?.towns?.forEach { println("id=${it.townId}, name=${it.townName}") }
    }
}