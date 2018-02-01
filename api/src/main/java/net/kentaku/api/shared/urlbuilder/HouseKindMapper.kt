/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.property.model.search.HouseKind

/**
 * Created by tsuyosh on 17/11/01.
 */
interface HouseKindMapper {
    fun value(houseKind: HouseKind): String

    companion object {
        val Kentaku = object: HouseKindMapper {
            override fun value(houseKind: HouseKind): String = when(houseKind) {
                    HouseKind.Mansion -> "1"
                    HouseKind.Apartment -> "2"
                    HouseKind.House -> "3"
            }
        }
        val Portal = object : HouseKindMapper {
            override fun value(houseKind: HouseKind): String = when(houseKind) {
                HouseKind.Mansion -> "2"
                HouseKind.Apartment -> "1"
                HouseKind.House -> "3"
            }
        }
    }
}