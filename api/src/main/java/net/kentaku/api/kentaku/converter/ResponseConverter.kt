/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.exception.ConversionException
import net.kentaku.api.kentaku.model.GetDetailPropertyResponse
import net.kentaku.api.kentaku.model.GetDetailPropertyTerminalResponse
import net.kentaku.api.kentaku.model.GetListPropertyResponse
import net.kentaku.api.shared.converter.toUrlWithScheme
import net.kentaku.geo.model.Location
import net.kentaku.property.model.*
import net.kentaku.property.model.search.CreditPay
import net.kentaku.property.model.search.PropertySearchResult
import net.kentaku.trader.model.FreeCallNumberDetector

/**
 * APIのResponseをDomain Modelに変換する拡張関数を定義します。
 * 拡張関数にしているのはResponseを自動生成しているためです
 * Created by tsuyosh on 17/11/01.
 */

fun GetListPropertyResponse.toPropertySearchResult(): PropertySearchResult {
    try {
        val properties = this.properties.map { property ->
            val propertyImages = property.propertyImages.map { image ->
                PropertyImage(
                        url = image.url.toUrlWithScheme(),
                        kind = when (image.kind) {
                            1 -> PropertyImageKind.Layout
                            2 -> PropertyImageKind.Exterior
                            3 -> PropertyImageKind.Interior
                            else -> PropertyImageKind.Etc
                        },
                        comment = image.comment
                )
            }
            val rooms = listOf(
                    Property.Room(
                            propertyFullId = property.propertyFullId,
                            firmSizeCode = property.firmSideCode,
                            dispPrice = property.dispPrice,
                            dispManageCost = property.dispManageCost,
                            housePlan = property.housePlan,
                            dispArea = property.dispArea,
                            traderId = property.traderId,
                            newArrival = property.newArrival,
                            cityId = property.cityId
                    )
            )
            Property(
                    dispName = property.dispName,
                    traffic = property.traffic,
                    address = property.address,
                    houseAge = property.houseAge,
                    completionDate = property.completionDate,
                    newBuild = property.newBuild,
                    buildingKind = property.buildingKind,
                    cityId = property.cityId,
                    location = Location.create(property.latitude, property.longitude),
                    propertyImages = propertyImages,
                    rooms = rooms
            )
        }

        return PropertySearchResult(
                totalCount = totalCount,
                startNumber = startNumber,
                properties = properties
        )
    } catch (t: Throwable) {
        throw ConversionException(
                "Coversion to PropertySearchResult was failed:source=" + this.toString(), t)
    }
}

fun GetDetailPropertyTerminalResponse.toPropertyDetailList(): List<PropertyDetail> {
    try {
        return properties.map {
            val propertyImages = it.propertyImages.map { image ->
                PropertyImage(
                        url = image.url.toUrlWithScheme(),
                        kind = when (image.kind) {
                            1 -> PropertyImageKind.Layout
                            2 -> PropertyImageKind.Exterior
                            3 -> PropertyImageKind.Interior
                            else -> PropertyImageKind.Etc
                        },
                        comment = image.comment
                )
            }
            val traders = it.traders.map { trader ->
                val dispTelNumber = if (trader.freecallNum != null && trader.freecallNum.isNotEmpty()) {
                    trader.freecallNum
                } else {
                    trader.tel
                }

                PropertyTrader(
                        traderId = trader.traderId,
                        name = trader.name,
                        tel = trader.tel,
                        address = trader.address,
                        freecallNum = trader.freecallNum,
                        holiday = trader.holiday,
                        openHour = trader.openHour,
                        freeDial = trader.freeDial,
                        webCalling = trader.webCalling,
                        dispTelNumber = dispTelNumber,
                        dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber),
                        dispName = DispNameFormatter.format(trader.name)
                )
            }

            PropertyDetail(
                    propertyFullId = it.propertyFullId,
                    firmSideCode = it.firmSideCode,
                    dispName = it.dispName,
                    propertyImages = propertyImages,
                    dispPrice = it.dispPrice,
                    dispManageCost = it.dispManageCost,
                    dispDeposit = it.dispDeposit,
                    dispKeyMoney = it.dispKeyMoney,
                    housePlan = it.housePlan,
                    dispArea = it.dispArea,
                    traffic = it.traffic,
                    address = it.address,
                    location = Location.create(it.latitude, it.longitude),
                    completionDate = it.completionDate,
                    houseAge = it.houseAge,
                    parking = it.parking,
                    floor = it.floor,
                    equipments = it.equipments,
                    windowDirection = it.windowDirection,
                    intoDate = it.intoDate,
                    buildingKind = it.buildingKind,
                    buildingStructure = it.buildingStructure,
                    condition = it.condition,
                    insurance = it.insurance,
                    dispTownCost = it.dispTownCost,
                    exchangeStyle = it.exchangeStyle,
                    dispStandardRate = it.dispStandardRate,
                    salesPoint = it.salesPoint,
                    specialRemark = it.specialRemark,
                    remarks = it.remarks,
                    upStartDate = it.upStartDate,
                    upRenewDate = it.upRenewDate,
                    newBuild = it.newBuild,
                    newArrival = it.newArrival,
                    traders = traders,
                    keyMoneyZero = it.keyMoney == null || it.keyMoney == 0f,
                    cleaning = it.cleaning,
                    keyExchangeFree = it.keyExchangeFree,
                    liveup2 = it.liveup2 == 1,
                    creditPay = when (it.credit) {
                        0 -> CreditPay.InitialOnly
                        1 -> CreditPay.InitialAndRent
                        else -> null
                    }
            )
        }
    } catch (t: Throwable) {
        throw ConversionException("Could not convert to PropertyDetail", t)
    }
}

fun GetDetailPropertyResponse.toPropertyList(): List<Property> {
    try {
        return properties.map {
            val propertyImages = it.propertyImages.map { image ->
                PropertyImage(
                        url = image.url.toUrlWithScheme(),
                        kind = when (image.kind) {
                            1 -> PropertyImageKind.Layout
                            2 -> PropertyImageKind.Exterior
                            3 -> PropertyImageKind.Interior
                            else -> PropertyImageKind.Etc
                        },
                        comment = image.comment
                )
            }
            val traders = it.traders.map { trader ->
                val dispTelNumber = if (trader.freecallNum != null && trader.freecallNum.isNotEmpty()) {
                    trader.freecallNum
                } else {
                    trader.tel
                }

                PropertyTrader(
                        traderId = trader.traderId,
                        name = trader.name,
                        tel = trader.tel,
                        address = trader.address,
                        freecallNum = trader.freecallNum,
                        holiday = trader.holiday,
                        openHour = trader.openHour,
                        freeDial = trader.freeDial,
                        webCalling = trader.webCalling,
                        dispTelNumber = dispTelNumber,
                        dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber),
                        dispName = DispNameFormatter.format(trader.name)
                )
            }

            val floorInfo = PropertyDetail.FloorInfo.createFloorInfo(it.floor)
            val rooms = listOf(Property.Room(
                    propertyFullId = it.propertyFullId,
                    firmSizeCode = it.firmSideCode,
                    floor = floorInfo.floor,
                    roomNumberText = "", // TODO
                    dispPrice = it.dispPrice,
                    dispManageCost = it.dispManageCost,
                    dispDeposit = it.dispDeposit,
                    dispKeyMoney = it.dispKeyMoney,
                    housePlan = it.housePlan,
                    dispArea = it.dispArea,
                    traderId = traders.first().traderId,
                    newArrival = it.newArrival,
                    cityId = 0,
                    allFloorNum = floorInfo.allFloorNum
            ))

            Property(
                    dispName = it.dispName,
                    traffic = it.traffic.firstOrNull() ?: "",
                    address = it.address,
                    allFloorNum = floorInfo.allFloorNum,
                    houseAge = it.houseAge,
                    completionDate = it.completionDate,
                    newBuild = it.newBuild,
                    buildingKind = it.buildingKind,
                    cityId = 0,
                    location = Location.create(it.latitude, it.longitude),
                    propertyImages = propertyImages,
                    rooms = rooms
            )
        }
    } catch (t: Throwable) {
        throw ConversionException("Could not convert to PropertyDetail", t)
    }
}