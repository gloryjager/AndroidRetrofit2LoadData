/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetListCityNumberMergePropertyResponse
import net.kentaku.api.portal.model.GetListCityNumberTraderResponse
import net.kentaku.area.model.City

/**
 * Created by tsuyosh on 17/11/29.
 */

fun GetListCityNumberMergePropertyResponse.toCityList(): List<City> {
    return cities.map { city ->
        City(
                id = city.cityId,
                prefectureId = city.prefectureId,
                name = city.cityName,
                propertyCount = city.propertyCount
        )
    }
}

fun GetListCityNumberTraderResponse.toCityList(): List<City> {
    return cities.map { city ->
        City(
                id = city.cityId,
                prefectureId = city.prefectureId,
                name = city.cityName,
                traderCount = city.shopCount
        )
    }
}