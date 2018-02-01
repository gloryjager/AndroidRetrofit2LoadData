/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.property.model.search.Sort

/**
 * Created by tsuyosh on 17/11/01.
 */

fun Sort.toQueryParams(): List<Pair<String, String>> {
    val param = when (this) {
        Sort.PriceAsc -> Pair("order_price", "1")
        Sort.PriceDesc -> Pair("order_price", "2")
        Sort.AreaAsc -> Pair("order_area", "1")
        Sort.AreaDesc -> Pair("order_area", "2")
        Sort.HousePlanAsc -> Pair("order_hplan", "1")
        Sort.HousePlanDesc -> Pair("order_hplan", "2")
        Sort.HouseAgeAsc -> Pair("order_age", "1")
        Sort.HouseAgeDesc -> Pair("order_age", "2")
        Sort.UpStartAsc -> Pair("order_upstart", "1")
        Sort.UpStartDesc -> Pair("order_upstart", "2")
        Sort.WalkAsc -> Pair("order_walk", "1")
        Sort.BusAsc -> Pair("order_bus", "1")
        Sort.Address -> Pair("order_addr", "1")
    }
    return listOf(param)
}
