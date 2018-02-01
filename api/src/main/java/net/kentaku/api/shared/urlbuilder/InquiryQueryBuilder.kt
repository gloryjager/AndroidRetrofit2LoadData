/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.inquiry.model.Inquiry
import net.kentaku.inquiry.model.InquiryType
import net.kentaku.inquiry.model.RequestKind
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by tsuyosh on 17/12/04.
 */

fun RequestKind.toQueryParam(): Pair<String, String> {
    val value = when (this) {
        RequestKind.PropertyInquiry -> "1"
        RequestKind.TraderInquiry -> "2"
    }
    return Pair("request_kind", value)
}

fun InquiryType.toQueryParam(): Pair<String, String> {
    val key = when (this) {
        InquiryType.BuildingCheck -> "is_building_check"
        InquiryType.VacancyInfo -> "is_vacancy_info"
        InquiryType.RoomArrangement -> "is_room_arrangemant"
        InquiryType.ShopVisit -> "is_shop_visit"
        InquiryType.ConsultationMoving -> "is_consultation_moving"
        InquiryType.SurroundingInfo -> "is_surrounding_info"
        InquiryType.BuildingIntroduction -> "is_building_introduction"
        InquiryType.Etc -> "is_etc"
    }
    return Pair(key, "1")
}

val dateFormatter: DateFormat = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)

fun Inquiry.toQueryParams(): List<Pair<String, String>> {
    return mutableListOf<Pair<String, String>>().apply {
        add(requestKind.toQueryParam())
        val dateString = dateFormatter.format(Date())

        propertyItems?.let { items ->
            val params = items.map(Inquiry.PropertyInquiryItem::toQueryParams)
                    .flatten()
            addAll(params)
        }

        traderItem?.let { item ->
            addAll(item.toQueryParams())
        }

        add(Pair("request_date", dateString))
        add(Pair("name", name))
        tel?.let { tel -> add(Pair("tel", tel)) }
        mail?.let { mail -> add(Pair("mail", mail)) }
        addAll(inquiryTypes.map(InquiryType::toQueryParam))
        remark?.let { remark -> add(Pair("remark", remark)) }
    }
}

fun Inquiry.PropertyInquiryItem.toQueryParams(): List<Pair<String, String>> {
    return listOf(
            Pair("property_full_id", propertyFullId),
            Pair("firm_side_code", firmSideCode),
            Pair("building_name", buildingName),
            Pair("trader_id", traderId)
    )
}

fun Inquiry.TraderInquiryItem.toQueryParams(): List<Pair<String, String>> {
    return listOf(
            Pair("trader_id", traderId)
    )
}