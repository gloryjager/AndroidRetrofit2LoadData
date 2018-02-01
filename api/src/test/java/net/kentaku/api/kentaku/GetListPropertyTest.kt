/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import net.kentaku.api.kentaku.model.GetListPropertyResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by tsuyosh on 17/10/12.
 */

class GetListPropertyTest : KentakuApiTest() {
    @Test
    fun testMoshi() {
        val json = """
{"result": 0,"message": "","total_count": 2,"start_number": 1,"properties": [{"property_full_id": 300039160000012000068,"firm_side_code": "1-013082401-02020","disp_name": "ＡＲＴ岩本町","property_name": "ＡＲＴ岩本町","property_images": [{"kind": 1,"url": "e-heya.kentaku.net/directImage/013/082/401/013082401-02020-M.gif","comment":"間取図"},{"kind": 2,"url": "e-heya.kentaku.net/directImage/013/082/401/013082401-G.jpg","comment":"外観"}],"disp_price": "8.6万円","price": 86000,"disp_manage_cost": "4,700円","manage_cost": 4700,"city_id": 13101,"address": "東京都千代田区岩本町","traffic": "山手線秋葉原駅 徒歩6分","house_plan": "1K","disp_area": "24.27㎡","area": 24.27,"completion_date": "2006年3月","house_age": "築11年","trader_id": "317000","new_build": false,"new_arrival": true,"latitude": 128502420,"longitude": 503194678,"building_kind":"マンション"},{"property_full_id": 300039160000594004720,"firm_side_code": "1-021894101-07010","disp_name": "Ｓ．Ｇｒａｃｅ","property_name": "Ｓ．Ｇｒａｃｅ","property_images": [{"kind": 1,"url": "e-heya.kentaku.net/directImage/021/894/101/021894101-07010-M.gif","comment":"間取図"},{"kind": 2,"url": "e-heya.kentaku.net/directImage/021/894/101/021894101-G.jpg","comment":"外観"}],"disp_price": "16.4万円","price": 164000,"disp_manage_cost": "8,000円","manage_cost": 8000,"city_id": 13101,"address": "東京都千代田区神田紺屋町","traffic": "山手線神田駅 徒歩3分","house_plan": "1LDK","disp_area": "45.78㎡","area": 45.78,"completion_date": "2017年9月","house_age": "築1年","trader_id": "317000","new_build": false,"new_arrival": true,"latitude": 128493424,"longitude": 503184040,"building_kind":"マンション"}]}
"""
        val adapter = moshi.adapter(GetListPropertyResponse::class.java)
        val response = adapter.fromJson(json)
        assertNotNull(response)
        response?.run {
            assertEquals(totalCount, 2)
            properties?.run {
                assertEquals(2, size)
                assertEquals("300039160000012000068", this[0].propertyFullId)
                assertEquals(24.27f, this[0].area)
                assertEquals("300039160000594004720", this[1].propertyFullId)
                assertEquals(45.78f, this[1].area)
            }
        }
        println(response)
    }

    @Test
    fun testGetListCityNumberProperty() {
        val cityIds = listOf(
                listOf("13102"),
                listOf("13101"),
                listOf("13102", "13103", "13104")
        )

        cityIds.forEach {
            val url = "/kentakuapi/callApp.jsp?function=GetListProperty&auth_code=218993f4634&entry_date=201708301655&start_number=1&max_count=100&" + it.map {
                "city_id=" + it
            }.joinToString("&")

            val responseBody = api.getListProperty(url)
                    .subscribeOn(Schedulers.io())
                    .test()
                    .await()
                    .assertNoErrors()
                    .values().first()

            println(responseBody)
            println(responseBody?.properties?.size)
            responseBody?.properties?.forEach { println("id=${it.propertyFullId}, name=${it.dispName}") }
        }
    }
}