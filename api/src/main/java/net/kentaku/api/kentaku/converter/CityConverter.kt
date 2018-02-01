/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetListCityNumberPropertyResponse
import net.kentaku.area.model.City

/**
 * Created by tsuyosh on 17/11/29.
 */

fun GetListCityNumberPropertyResponse.toCityList(): List<City> {
    return cities.map { city ->
        City(
                id = city.cityId,
                prefectureId = city.prefectureId,
                name = city.cityName,
                propertyCount = city.propertyCount
        )
    }
}