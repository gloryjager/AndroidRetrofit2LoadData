/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetListTownNumberPropertyResponse
import net.kentaku.area.model.Town

/**
 * Created by tsuyosh on 17/12/04.
 */

fun GetListTownNumberPropertyResponse.toTownList(): List<Town> {
    return towns.map { townsItem ->
        Town(
                id = townsItem.townId,
                cityId = townsItem.cityId,
                name = townsItem.townName,
                propertyCount = townsItem.propertyCount
        )
    }
}