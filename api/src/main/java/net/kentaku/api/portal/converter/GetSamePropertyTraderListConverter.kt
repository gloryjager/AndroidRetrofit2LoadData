/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetSamePropertyTraderListResponse
import net.kentaku.api.shared.converter.toUrlWithScheme
import net.kentaku.trader.model.*

/**
 * Created by homepage on 2017/12/27.
 */
fun GetSamePropertyTraderListResponse.toSamePropertyTraderList(): SamePropertyTraderList {


    var newTraders = traders.map { trader ->
        var imageList = arrayListOf(trader.images)
        val images = imageList.map { image ->
            TraderImage(
                    kind = when (image.kind) {
                        1 -> TraderImageKind.Exterior
                        3 -> TraderImageKind.CompanyLogo
                        4 -> TraderImageKind.Map
                        5 -> TraderImageKind.Staff
                        else -> TraderImageKind.Etc
                    },
                    url = image.url.toUrlWithScheme()
            )

        }

        val dispTelNumber = if (trader.freecallNum != null && trader.freecallNum.isNotEmpty()) {
            trader.freecallNum
        } else {
            trader.tel
        }

        Trader(
                traderId = trader.traderId.toString(),
                prefectureId = 0,
                dispName = trader.name,
                name = trader.name,
                images = images,
                address = trader.address,
                tel = trader.tel,
                openHour = trader.openHour,
                freecallNum = trader.freecallNum,
                dispTelNumber = dispTelNumber,
                dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber)
        )


    }
    return SamePropertyTraderList(propertyName, traderNum, newTraders)
}
