/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.kentaku.exception.ConversionException
import net.kentaku.api.portal.model.GetDetailMergePropertyResponse
import net.kentaku.api.portal.model.GetDetailPropertyResponse
import net.kentaku.api.portal.model.GetListMergePropertyResponse
import net.kentaku.api.shared.converter.toUrlWithScheme
import net.kentaku.geo.model.Location
import net.kentaku.property.model.*
import net.kentaku.property.model.search.PropertySearchResult
import net.kentaku.trader.model.FreeCallNumberDetector

/**
 * Created by tsuyosh on 17/11/01.
 */

fun GetListMergePropertyResponse.toPropertySearchResult(): PropertySearchResult {
    val properties = this.properties.map { property ->
        val propertyImages = property.propertyImages.map { image ->
            PropertyImage(
                    url = image.url.toUrlWithScheme(),
                    kind = when (image.kind) {
                        1 -> PropertyImageKind.Layout
                        10 -> PropertyImageKind.Exterior
                        else -> PropertyImageKind.Etc
                    }
            )
        }

        val rooms = property.sameBuildingProperties.map { room ->
            Property.Room(
                    propertyFullId = room.propertyFullId,
                    firmSizeCode = room.firmSideCode,
                    floor = room.floor,
                    roomNumberText = room.roomNumberText,
                    dispPrice = room.dispPrice,
                    dispManageCost = room.dispManageCost,
                    dispDeposit = room.dispDeposit,
                    dispKeyMoney = room.dispKeyMoney,
                    dispRepairCost = room.dispRepairCost,
                    housePlan = room.housePlan,
                    dispArea = room.dispArea,
                    traderId = room.traderId.toString(), // TODO traderIdの型をStringに変更
                    newArrival = room.newArrival,
                    cityId = property.cityId,
                    allFloorNum = property.allFloorNum
            )
        }
        Property(
                dispName = property.dispName,
                traffic = property.traffic,
                address = property.address,
                allFloorNum = property.allFloorNum,
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
}

fun GetDetailMergePropertyResponse.toPropertyDetailList(): List<PropertyDetail> {
    try {
        return properties.map {
            val propertyImages = it.propertyImages.map { image ->
                PropertyImage(
                        url = image.url.toUrlWithScheme(),
                        kind = when (image.kind) {
                            1 -> PropertyImageKind.Layout
                            10 -> PropertyImageKind.Exterior
                            2 -> PropertyImageKind.Entrance
                            3 -> PropertyImageKind.LivingRoom
                            4 -> PropertyImageKind.Kitchen
                            5 -> PropertyImageKind.BedRoom
                            6 -> PropertyImageKind.Bath
                            7 -> PropertyImageKind.Veranda
                            8 -> PropertyImageKind.REINS
                            9 -> PropertyImageKind.Flyer
                            11 -> PropertyImageKind.Map
                            12 -> PropertyImageKind.Landmark
                            13 -> PropertyImageKind.Etc
                            14 -> PropertyImageKind.Environment
                            15 -> PropertyImageKind.JapaneseStyleRoom
                            16 -> PropertyImageKind.KidsRoom
                            17 -> PropertyImageKind.Toilet
                            18 -> PropertyImageKind.Lavatory
                            19 -> PropertyImageKind.Closet
                            20 -> PropertyImageKind.Garden
                            21 -> PropertyImageKind.Security
                            22 -> PropertyImageKind.WesternStyleRoom
                            else -> PropertyImageKind.Etc
                        }
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
                        dispTelNumber = dispTelNumber,
                        dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber),
                        dispName = trader.name
                )
            }

            PropertyDetail(
                    propertyFullId = it.propertyFullId,
                    firmSideCode = it.firmSideCode,
                    dispName = it.dispName,
                    propertyImages = propertyImages,
                    samePropertyNum = it.samePropertyNum,
                    dispPrice = it.dispPrice,
                    dispManageCost = it.dispManageCost,
                    dispDeposit = it.dispDeposit,
                    dispKeyMoney = it.dispKeyMoney,
                    dispRepairCost = it.dispRepairCost,
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
                    exchangeStyle = it.exchangeStyle,
                    salesPoint = it.salesPoint,
                    specialRemark = it.specialRemark,
                    remarks = it.remarks,
                    upStartDate = it.upStartDate,
                    upRenewDate = it.upEndDate,
                    newBuild = it.newBuild,
                    newArrival = it.newArrival,
                    traders = traders,
                    keyMoneyZero = it.keyMoney == null || it.keyMoney == 0f
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
                            else -> PropertyImageKind.Etc
                        }
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
                        dispTelNumber = dispTelNumber,
                        dispTelNumberFree = FreeCallNumberDetector.isFreeCallNumber(dispTelNumber),
                        dispName = trader.name
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