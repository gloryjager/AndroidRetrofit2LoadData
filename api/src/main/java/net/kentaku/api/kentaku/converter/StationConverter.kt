/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetListStationNumberPropertyResponse
import net.kentaku.train.model.Station

/**
 * Created by tsuyosh on 17/12/03.
 */

fun GetListStationNumberPropertyResponse.toStationList(): List<Station> {
    return stations.map { stationsItem ->
        Station(
                id = stationsItem.stationId,
                prefectureId = stationsItem.prefectureId,
                name = stationsItem.stationName,
                propertyCount = stationsItem.propertyCount
        )
    }
}