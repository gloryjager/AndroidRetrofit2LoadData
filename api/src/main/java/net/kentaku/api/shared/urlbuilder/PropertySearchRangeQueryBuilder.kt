/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.property.model.search.CommutingCondition
import net.kentaku.property.model.search.PropertySearchRange

/**
 * Created by tsuyosh on 17/11/01.
 */

fun PropertySearchRange.toQueryParams(): List<Pair<String, String>> {
    val list = mutableListOf<Pair<String, String>>().apply {
        cities?.map { city ->
            Pair("city_id", city.id.toString())
        }?.let { list ->
            addAll(list)
        }

        towns?.map { town ->
            Pair("town_id", town.id)
        }?.let { list ->
            addAll(list)
        }

        trainSearchCondition?.let {
            val stations = it.lineAndStationsList
                    .filter {
                        !it.allStations
                    }
                    .map {
                        it.stations
                    }
                    .flatten()
                    .map {
                        Pair("station_id", it.id)
                    }
            addAll(stations)

            val lines = it.lineAndStationsList
                    .filter {
                        it.allStations
                    }
                    .map {
                        it.line
                    }
                    .map {
                        Pair("line_id", it.id)
                    }
            addAll(lines)
        }

        wordSearchCondition?.let { condition ->
            condition.city?.let { city ->
                add(Pair("city_id", city.id.toString()))
            }
            condition.station?.let { station ->
                add(Pair("val_code", station.valCode))
            }
        }

        commutingConditions?.let { conditions ->
            conditions.getOrNull(0)?.let { condition ->
                addAll(condition.toQueryParams())
            }
            conditions.getOrNull(1)?.let { condition ->
                addAll(condition.toQueryParams())
            }
        }

        place?.location?.let { location ->
            addAll(location.toQueryParams())
        }

        addAll(
                listOfNotNull(
                        range?.let { Pair("range", it.toString()) },
                        traderId?.let { Pair("trader_id", it) }
                )
        )
    }

    return list
}

fun CommutingCondition.toQueryParams(): List<Pair<String, String>> {
    return listOf(
            Pair("val_code", station.valCode),
            Pair("time", rideTime.toString()),
            Pair("exchange", if (transferCount != null) {
                transferCount.toString()
            } else {
                ""
            })
    )
}