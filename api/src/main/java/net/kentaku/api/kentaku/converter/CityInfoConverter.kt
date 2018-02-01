/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetCityInfoResponse
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

        // 一部数値の項目をtoString()しているのはポータル版APIの出力に合わせたため
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
                cityParkNum = it.cityparkNum.toString(),
                libraryNum = it.libraryNum.toString(),
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
                nurseryschool = it.nurseryschool.toString(),
                nurseryschoolU0 = it.nurseryschoolU0.toString(),
                privateNurseryschool = it.privateNurseryschool.toString(),
                privateNurseryschoolU0 = it.privateNurseryschoolU0.toString(),
                watingChild = it.watingChild.toString(),
                kindergartenPub = it.kindergartenPub.toString(),
                kindergartenPro = it.kindergartenPro.toString(),
                elementaryschoolNum = it.elementaryschoolNum.toString(),
                juniorhighschoolNum = it.juniorhighscoolNum.toString(),
                hospitalNum = it.hospitalNum.toString(),
                childRearingRelated = it.childRearingRelated
        )
    }
}