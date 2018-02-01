/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetDetailTraderTerminalResponse
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

        TraderDetail(
                traderId = trader.traderId.toString(),
                dispName = trader.dispName,
                tradeName = trader.tradeName,
                firmName = trader.firmName,
                branchName = trader.branchName,
                images = images,
                location = Location.create(trader.latitude, trader.longitude),
                address = trader.address,
                traffic = trader.traffic,
                tel = trader.tel,
                fax = trader.fax,
                openHour = trader.openHour,
                place = trader.place,
                staff = trader.staff,
                otherService = trader.otherService,
                serviceArea = trader.serviceArea,
                licenceNo = trader.licenceNo,
                group = trader.group,
                sell = trader.sell,
                rent = trader.rent,
                promotion = trader.promotion,
                remark = trader.remark,
                freecallNum = trader.freecallNum,
                firmSideFirmId = trader.firmSideFirmId,
                dispTelNumber = dispTelNumber,
                dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber)
        )
    }
}
