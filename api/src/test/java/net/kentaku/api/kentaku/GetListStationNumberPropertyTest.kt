/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import org.junit.Test

/**
 * Created by tsuyosh on 17/12/03.
 */
class GetListStationNumberPropertyTest: KentakuApiTest() {
    @Test
    fun testGetListStationNumberProperty() {
        val url = "/kentakuapi/callApp.jsp?function=GetListStationNumberProperty&auth_code=218993f4634&entry_date=201708301655&line_id=0&add_count=1&add_noproperty=1"
        val response = api.getListStationNumberProperty(url)
                .subscribeOn(Schedulers.io())
                .test()
                .await()
                .assertNoErrors()
                .values().first()

        response.stations.forEach { stationsItem ->
            println(stationsItem)
        }
    }
}