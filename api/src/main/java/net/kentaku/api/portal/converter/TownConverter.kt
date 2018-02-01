/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetListTownNumberMergePropertyResponse
import net.kentaku.area.model.Town

/**
 * Created by tsuyosh on 17/12/04.
 */

fun GetListTownNumberMergePropertyResponse.toTownList(): List<Town> {
    return towns.map { townsItem ->
        Town(
                id = townsItem.townId,
                cityId = townsItem.cityId,
                name = townsItem.townName,
                propertyCount = townsItem.propertyCount
        )
    }
}