/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetListSuggestKeyWordResponse
import net.kentaku.area.model.City
import net.kentaku.property.model.search.KeywordSuggestionResult
import net.kentaku.property.model.search.SuggestedStation

/**
 * Created by tsuyosh on 17/12/06.
 */

fun GetListSuggestKeyWordResponse.toKeywordSuggestionResult(): KeywordSuggestionResult {
    return KeywordSuggestionResult(
            cities = cities.map { city ->
                City(
                        id = city.cityId,
                        prefectureId = city.prefectureId,
                        name = city.cityName
                )
            },
            stations = stations.map { station ->
                SuggestedStation(
                        valCode = station.valCode.toString(),
                        name = station.stationName
                )
            }
    )
}