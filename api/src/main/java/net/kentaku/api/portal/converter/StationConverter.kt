/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetListStationNumberMergePropertyResponse
import net.kentaku.api.portal.model.GetListStationNumberTraderResponse
import net.kentaku.train.model.Station

/**
 * Created by tsuyosh on 17/12/03.
 */

fun GetListStationNumberMergePropertyResponse.toStationList(): List<Station> {
    return stations.map { stationsItem ->
        Station(
                id = stationsItem.stationId.toString(),
                prefectureId = stationsItem.prefectureId,
                name = stationsItem.stationName,
                propertyCount = stationsItem.propertyCount
        )
    }
}

fun GetListStationNumberTraderResponse.toStationList(): List<Station> {
    return stations.map { stationsItem ->
        Station(
                id = stationsItem.stationId.toString(),
                name = stationsItem.stationName,
                traderCount = stationsItem.shopCount
        )
    }
}