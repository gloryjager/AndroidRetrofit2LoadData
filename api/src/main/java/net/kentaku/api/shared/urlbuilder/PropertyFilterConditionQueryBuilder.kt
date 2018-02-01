/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.property.model.search.*

/**
 * Created by tsuyosh on 17/11/01.
 */

fun PropertyFilterCondition.toQueryParams(houseKindMapper: HouseKindMapper): List<Pair<String, String>> {
    val list = mutableListOf<Pair<String, String>>()

    val add = fun(key: String, value: Any?) {
        if (value is Boolean) {
            if (value) list.add(Pair(key, "1"))
        } else if (value is Int) {
            list.add(Pair(key, value.toString()))
        } else if (value is String) {
            list.add(Pair(key, value))
        } else if (value != null) {
            list.add(Pair(key, value.toString()))
        }
    }

    // 基本条件
    add("min_price", minPrice)
    add("max_price", maxPrice)
    add("manage_cost", manageCost)
    housePlan?.let { list.addAll(it.toQueryParams()) }
    houseKind?.let {
        // house_kindの値は建託版とポータル版で仕様が異なるため
        list.addAll(it.map {
            Pair("house_kind", houseKindMapper.value(it))
        })
    }
    houseStructure?.let { list.addAll(it.toQueryParams()) }
    add("house_age", houseAge)
    add("walk_time", walkTime)
    add("bus_time", busTime)
    add("min_area", minArea)
    add("max_area", maxArea)
    add("up_start", upStart)

    // 基本条件/お得な条件(ポータルのみ)
    add("ls_renewal", isRenewal)
    add("reform", reform)
    add("renovation", renovation)
    add("designers", designers)
    add("cosigner", cosigner)
    add("recovery_cost", recoveryCost)
    add("management", management)
    add("renewal_cost", renewalCost)
    add("special_rental", specialRental)
    add("lots_sale", lotsSale)
    creditPay?.let { list.addAll(it.toQueryParams()) }

    // こだわり条件/こだわり条件(ポータルのみ)
    add("room_share", roomShare)
    add("sex_condition", sexCondition)
    add("guarantor", guarantor)
    add("freerent", freerent)
    add("elder", elder)
    add("office_use", officeUse)
    add("fixed_time_none", fixedTimeNone)

    // こだわり条件/キッチン
    gasStove?.let { list.addAll(it.toQueryParams()) }
    add("ih_cooker", ihCooker)
    kitchen?.let { list.addAll(it.toQueryParams()) }
    add("water_purifier", waterPurifier)

    // こだわり条件/バス・トイレ
    add("bath_toilet", bathToilet)
    add("reboil_bath", reboilBath)
    add("washlet", washlet)
    add("warmlet", warmlet)
    add("shampoo_dresser", shampooDresser)
    add("dresser_separate", dresserSeparate)
    add("bath_drier", bathDrier)

    // こだわり条件/冷暖房
    add("aircon", aircon)
    add("floor_heater", floorHeater)
    add("kerosene_heater", keroseneHeater)
    add("kerosene_ff", keroseneFf)
    add("gas_haeter", gasHaeter)

    // こだわり条件/収納
    add("trunk_room", trunkRoom)
    add("closet_underfloor", closetUnderfloor)
    add("walkin_closet", walkinCloset)
    add("shoes_box", shoesBox)

    // こだわり条件/テレビ・通信
    add("bs", bs)
    add("cs", cs)
    add("catv", catv)
    add("internet", internet)
    add("internet_free", internetFree)
    add("optical_fiber", opticalFiber)

    // こだわり条件/セキュリティ
    add("auto_lock", autoLock)
    add("tv_interphone", tvInterphone)
    add("dimple_key", dimpleKey)
    add("derivery_box", deriveryBox)
    add("24_management", _24Management)
    add("manager", manager)
    add("crime_prev_camera", crimePrevCamera)

    // 室内設備
    add("room_washing_machine", roomWashingMachine)
    add("flooring", flooring)
    add("loft", loft)
    add("barrier_free", barrierFree)

    // 建物設備
    add("bicycle_parking", bicycleParking)
    add("moto_parking", motoParking)
    add("elevator", elevator)
    add("tile_wall", tileWall)
    gasElectric?.let { list.addAll(it.toQueryParams()) }
    add("private_yard", privateYard)
    balcony?.let { list.addAll(it.toQueryParams()) }
    add("private_dust_box", privateDustBox)

    // こだわり条件/画像
    add("panorama_type", panoramaType)
    add("panorama", panorama)
    add("images", images)
    add("house_plan_image", housePlanImage)

    // 契約パターン
    add("cleaning_prepayment", cleaningPrepayment)
    add("cleaning_defepayment", cleaningDefepayment)
    add("exit_payment", exitPayment)

    // 位置
    add("south_face", southFace)
    roomFloor?.let { list.addAll(it.toQueryParams()) }
    add("corner_room", cornerRoom)

    // 契約プラン
    add("zero_deposit", zeroDeposit)
    add("zero_keymoney", zeroKeymoney)
    add("zero_renewalcost", zeroRenewalcost)
    add("rakuraku_plan", rakurakuPlan)
    add("support_plan", supportPlan)
    add("support_plan_clean", supportPlanClean)
    add("support_plan_restore", supportPlanRestore)

    // その他
    parking?.let { list.addAll(it.toQueryParams()) }
    add("with_pet", withPet)
    add("musical", musical)
    add("into_house", intoHouse)
    add("cleaning", cleaning)
    add("earthquake_resist", earthquakeResist)
    add("washing_machine", washingMachine)
    add("maisonette", maisonette)

    return list
}

/**
 * Onの場合だけパラメータを返す
 */
fun FilterSwitch.toQueryValue() = when (this) {
    FilterSwitch.On -> "1"
    else -> null
}

fun HousePlan.toQueryValue() = when (this) {
    HousePlan._1R -> "1R"
    HousePlan._1K -> "1K"
    HousePlan._1DK -> "1DK"
    HousePlan._1LDK -> "1LDK"
    HousePlan._2K -> "2K"
    HousePlan._2DK -> "2DK"
    HousePlan._2LDK -> "2LDK"
    HousePlan._3K -> "3K"
    HousePlan._3DK -> "3DK"
    HousePlan._3LDK -> "3LDK"
    HousePlan._3LDK_more -> "3LDK_more"
    HousePlan._4K_more -> "4K_more"
}

fun Array<HousePlan>.toQueryParams() = this.map {
    Pair("house_plan", it.toQueryValue())
}

fun HouseStructure.toQueryValue() = when (this) {
    HouseStructure.Rebar -> "1"
    HouseStructure.IronFrame -> "2"
    HouseStructure.Wooden -> "3"
    HouseStructure.BlockEtc -> "4"
}

fun Array<HouseStructure>.toQueryParams() = this.map {
    Pair("house_structure", it.toQueryValue())
}

fun CreditPay.toQueryValue() = when (this) {
    CreditPay.InitialOnly -> "1"
    CreditPay.RentOnly -> "2"
    CreditPay.InitialAndRent -> "3"
}

fun Array<CreditPay>.toQueryParams() = this.map {
    Pair("credit_pay", it.toQueryValue())
}

fun GasStove.toQueryValue() = when (this) {
    GasStove.One -> "1"
    GasStove.TwoOrMore -> "2"
}

fun Array<GasStove>.toQueryParams() = this.map {
    Pair("gas_stove", it.toQueryValue())
}

fun Kitchen.toQueryValue() = when (this) {
    Kitchen.SystemKitchen -> "1"
    Kitchen.CounterKitchen -> "2"
}

fun Array<Kitchen>.toQueryParams() = this.map {
    Pair("kitchen", it.toQueryValue())
}

fun GasElectric.toQueryValue() = when (this) {
    GasElectric.CityGas -> "1"
    GasElectric.PropaneGas -> "2"
    GasElectric.Electric -> "3" // ポータルのみ
}

fun Array<GasElectric>.toQueryParams() = this.map {
    Pair("gas_electric", it.toQueryValue())
}

fun Balcony.toQueryValue() = when (this) {
    Balcony.Balcony -> "1"
    Balcony.RoofBalcony -> "2"
}

fun Array<Balcony>.toQueryParams() = this.map {
    Pair("balcony", it.toQueryValue())
}

fun RoomFloor.toQueryValue() = when (this) {
    RoomFloor.FirstFloor -> "1"
    RoomFloor.SecondOrHigherFloor -> "2"
    RoomFloor.TopFloor -> "3"
}

fun Array<RoomFloor>.toQueryParams() = this.map {
    Pair("room_floor", it.toQueryValue())
}

fun Parking.toQueryValue() = when (this) {
    Parking.InHouseParing -> "1"
    Parking.ParkingSpace -> "2" // ポータルのみ
}

fun Array<Parking>.toQueryParams() = this.map {
    Pair("parking", it.toQueryValue())
}
