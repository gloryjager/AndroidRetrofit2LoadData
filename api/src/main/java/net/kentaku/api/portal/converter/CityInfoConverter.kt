/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetCityInfoResponse
import net.kentaku.property.model.CityInfo

/**
 * Created by tsuyosh on 17/11/20.
 */

fun GetCityInfoResponse.toCityInfo(): CityInfo {
    return cityInfo.let {
        val gasInfo = it.gasInfo.map {
            CityInfo.GasInfo(
                    gasItem = it.gasItem,
                    gasPrice = it.gasPrice
            )
        }.first()
        val waterInfo = it.waterInfo.map {
            CityInfo.WaterInfo(
                    waterItem = it.waterItem,
                    waterPrice = it.waterPrice
            )
        }.first()
        val sewageInfo = it.sewageInfo.map {
            CityInfo.SewageInfo(
                    sewageItem = it.sewageItem,
                    sewagePrice = it.sewagePrice
            )
        }.first()

        CityInfo(
                cityName = it.cityName,
                profile = it.profile,
                population = it.population,
                cityAddress = it.cityAddress,
                cityTel = it.cityTel,
                cityPage = it.cityPage,
                tokusanInfo = it.tokusanInfo,
                eventInfo = it.eventInfo,
                gasInfo = gasInfo,
                waterInfo = waterInfo,
                sewageInfo = sewageInfo,
                hazardmapInfo = it.hazardmapInfo,
                hazardmapUrl = it.hazardmapUrl,
                cityParkNum = it.cityparkNum,
                libraryNum = it.libraryNum,
                childiryojoseiAge1 = it.childiryojoseiAge1,
                childiryojoseiFutan1 = it.childiryojoseiFutan1,
                childiryojoseiFuranremark1 = it.childiryojoseiFuranremark1,
                childiryojoseiIncome1 = it.childiryojoseiIncome1,
                childiryojoseiIncome_1 = it.childiryojoseiIncome_1,
                childiryojoseiAge2 = it.childiryojoseiAge2,
                childiryojoseiFutan2 = it.childiryojoseiFutan2,
                childiryojoseiFuranremark2 = it.childiryojoseiFuranremark2,
                childiryojoseiIncome2 = it.childiryojoseiIncome2,
                childiryojoseiIncome_2 = it.childiryojoseiIncome_2,
                babygift = it.babygift,
                babygiftRemark = it.babygiftRemark,
                nurseryschool = it.nurseryschool,
                nurseryschoolU0 = it.nurseryschoolU0,
                privateNurseryschool = it.privateNurseryschool,
                privateNurseryschoolU0 = it.privateNurseryschoolU0,
                watingChild = it.watingChild,
                kindergartenPub = it.kindergartenPub,
                kindergartenPro = it.kindergartenPro,
                elementaryschoolNum = it.elementaryschoolNum,
                juniorhighschoolNum = it.juniorhighscoolNum,
                hospitalNum = it.hospitalNum,
                childRearingRelated = it.childRearingRelated
        )
    }
}