/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetDetailTraderTerminalResponse
import net.kentaku.api.shared.converter.toUrlWithScheme
import net.kentaku.geo.model.Location
import net.kentaku.trader.model.FreeCallNumberDetector
import net.kentaku.trader.model.TraderDetail
import net.kentaku.trader.model.TraderImage
import net.kentaku.trader.model.TraderImageKind

/**
 * Created by tsuyosh on 17/11/28.
 */

fun GetDetailTraderTerminalResponse.toTraderDetail(): List<TraderDetail> {
    return traders.map { trader ->
        val images = trader.images.map { image ->
            TraderImage(
                    kind = when(image.kind) {
                        1 -> TraderImageKind.Staff
                        2 -> TraderImageKind.Exterior
                        3 -> TraderImageKind.Map
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

        TraderDetail(
                traderId = trader.traderId,
                branchName = trader.branchName,
                images = images,
                location = Location.create(trader.latitude, trader.longitude),
                address = trader.address,
                tel = trader.tel,
                fax = trader.fax,
                openHour = trader.openHour,
                holiday = trader.holiday,
                licenceNo = trader.licenceNo,
                promotion = trader.promotion,
                freecallNum = trader.freecallNum,
                freeDial = trader.freeDial,
                dispTelNumber = dispTelNumber,
                dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber),
                dispName = DispNameFormatter.format(trader.branchName)
        )
    }
}
