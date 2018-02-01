/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import net.kentaku.api.kentaku.model.GetListCityNumberPropertyResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by tsuyosh on 17/10/12.
 */

class GetListCityNumberPropertyTest : KentakuApiTest() {
    @Test
    fun testMoshi() {
        val json = """
{"result":0,"message":"","cities":[{"prefecture_id":13,"city_id":13101,"city_name":"千代田区","property_count":2},{"prefecture_id":13,"city_id":13102,"city_name":"中央区","property_count":2},{"prefecture_id":13,"city_id":13103,"city_name":"港区","property_count":1},{"prefecture_id":13,"city_id":13104,"city_name":"新宿区","property_count":6},{"prefecture_id":13,"city_id":13105,"city_name":"文京区","property_count":3},{"prefecture_id":13,"city_id":13106,"city_name":"台東区","property_count":11},{"prefecture_id":13,"city_id":13107,"city_name":"墨田区","property_count":27},{"prefecture_id":13,"city_id":13108,"city_name":"江東区","property_count":39},{"prefecture_id":13,"city_id":13109,"city_name":"品川区","property_count":7},{"prefecture_id":13,"city_id":13110,"city_name":"目黒区","property_count":33},{"prefecture_id":13,"city_id":13111,"city_name":"大田区","property_count":92},{"prefecture_id":13,"city_id":13112,"city_name":"世田谷区","property_count":55},{"prefecture_id":13,"city_id":13113,"city_name":"渋谷区","property_count":7},{"prefecture_id":13,"city_id":13114,"city_name":"中野区","property_count":35},{"prefecture_id":13,"city_id":13115,"city_name":"杉並区","property_count":24},{"prefecture_id":13,"city_id":13116,"city_name":"豊島区","property_count":5},{"prefecture_id":13,"city_id":13117,"city_name":"北区","property_count":11},{"prefecture_id":13,"city_id":13118,"city_name":"荒川区","property_count":13},{"prefecture_id":13,"city_id":13119,"city_name":"板橋区","property_count":54},{"prefecture_id":13,"city_id":13120,"city_name":"練馬区","property_count":106},{"prefecture_id":13,"city_id":13121,"city_name":"足立区","property_count":184},{"prefecture_id":13,"city_id":13122,"city_name":"葛飾区","property_count":42},{"prefecture_id":13,"city_id":13123,"city_name":"江戸川区","property_count":28},{"prefecture_id":13,"city_id":13201,"city_name":"八王子市","property_count":682},{"prefecture_id":13,"city_id":13202,"city_name":"立川市","property_count":90},{"prefecture_id":13,"city_id":13203,"city_name":"武蔵野市","property_count":6},{"prefecture_id":13,"city_id":13204,"city_name":"三鷹市","property_count":15},{"prefecture_id":13,"city_id":13205,"city_name":"青梅市","property_count":149},{"prefecture_id":13,"city_id":13206,"city_name":"府中市","property_count":68},{"prefecture_id":13,"city_id":13207,"city_name":"昭島市","property_count":86},{"prefecture_id":13,"city_id":13208,"city_name":"調布市","property_count":33},{"prefecture_id":13,"city_id":13209,"city_name":"町田市","property_count":165},{"prefecture_id":13,"city_id":13210,"city_name":"小金井市","property_count":13},{"prefecture_id":13,"city_id":13211,"city_name":"小平市","property_count":35},{"prefecture_id":13,"city_id":13212,"city_name":"日野市","property_count":80},{"prefecture_id":13,"city_id":13213,"city_name":"東村山市","property_count":31},{"prefecture_id":13,"city_id":13214,"city_name":"国分寺市","property_count":20},{"prefecture_id":13,"city_id":13215,"city_name":"国立市","property_count":17},{"prefecture_id":13,"city_id":13218,"city_name":"福生市","property_count":65},{"prefecture_id":13,"city_id":13219,"city_name":"狛江市","property_count":14},{"prefecture_id":13,"city_id":13220,"city_name":"東大和市","property_count":71},{"prefecture_id":13,"city_id":13221,"city_name":"清瀬市","property_count":38},{"prefecture_id":13,"city_id":13222,"city_name":"東久留米市","property_count":41},{"prefecture_id":13,"city_id":13223,"city_name":"武蔵村山市","property_count":73},{"prefecture_id":13,"city_id":13224,"city_name":"多摩市","property_count":21},{"prefecture_id":13,"city_id":13225,"city_name":"稲城市","property_count":27},{"prefecture_id":13,"city_id":13227,"city_name":"羽村市","property_count":38},{"prefecture_id":13,"city_id":13228,"city_name":"あきる野市","property_count":74},{"prefecture_id":13,"city_id":13229,"city_name":"西東京市","property_count":36},{"prefecture_id":13,"city_id":13303,"city_name":"西多摩郡瑞穂町","property_count":19},{"prefecture_id":13,"city_id":13305,"city_name":"西多摩郡日の出町","property_count":19}]}
"""
        val adapter = moshi.adapter(GetListCityNumberPropertyResponse::class.java)
        val response = adapter.fromJson(json)
        println(response)
        response?.run {
            assertTrue(isSuccess())
            assertEquals(51, cities.size)
            assertEquals(13101, cities[0].cityId)
            assertEquals("千代田区", cities[0].cityName)
            assertEquals(2, cities[0].propertyCount)
        }
    }

    @Test
    fun testGetListCityNumberProperty() {
        val response = api.getListCityNumberProperty("/kentakuapi/callApp.jsp?function=GetListCityNumberProperty&auth_code=218993f4634&entry_date=201708301655&prefecture_id=13")
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()
        println(response)
        response?.run {
            println(cities.size)
            cities.forEach { println("id=${it.cityId}, name=${it.cityName}") }
        }
    }
}