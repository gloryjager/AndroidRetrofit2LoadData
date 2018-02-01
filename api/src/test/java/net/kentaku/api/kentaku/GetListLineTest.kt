/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import org.junit.Test

/**
 * Created by tsuyosh on 17/12/03.
 */
class GetListLineTest: KentakuApiTest() {
    @Test
    fun testGetListLineTest() {
        val url = "/kentakuapi/callApp.jsp?function=GetListLine&auth_code=218993f4634&entry_date=201708301655&prefecture_id=0&line_kind=all&add_count=1&add_noproperty=1"
        val response = api.getListLine(url)
                .subscribeOn(Schedulers.io())
                .test()
                .await()
                .assertNoErrors()
                .values().first()

        response.lineData.forEach { lineDataItem ->
            println("--------")
            println("kind: ${lineDataItem.lineKind}")
            lineDataItem.lines.forEach { linesItem ->
                println(linesItem)
            }
            println("--------")
        }
    }
}