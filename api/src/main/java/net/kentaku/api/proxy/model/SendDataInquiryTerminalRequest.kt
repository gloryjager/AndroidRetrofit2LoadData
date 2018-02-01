/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.model

import com.squareup.moshi.Json
import net.kentaku.api.shared.model.Credential
import net.kentaku.inquiry.model.Inquiry
import net.kentaku.inquiry.model.InquiryType
import net.kentaku.inquiry.model.RequestKind
import se.ansman.kotshi.JsonSerializable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by tsuyosh on 17/12/13.
 */
@JsonSerializable
data class SendDataInquiryTerminalRequest(
        @Json(name = "function")
        val function: String,

        @Json(name = "auth_code")
        val authCode: String,

        @Json(name = "entry_date")
        val entryDate: String,

        @Json(name = "request_kind")
        val requestKind: String,

        @Json(name = "request_date")
        val requestDate: String,

        @Json(name = "device_type")
        val deviceType: String,

        @Json(name = "content")
        val content: List<Content>?
) {
    companion object {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)
        const val nameFormat = "%s　%s"

        fun create(
                credential: Credential,
                inquiry: Inquiry,
                deviceType: Int
        ): SendDataInquiryTerminalRequest {
            val inquiryTypes = inquiry.inquiryTypes
            val content = when (inquiry.requestKind) {
                RequestKind.PropertyInquiry -> {
                    inquiry.propertyItems?.map { item ->
                        Content(
                                deviceType = deviceType.toString(),
                                propertyFullId = item.propertyFullId,
                                firmSideCode = item.firmSideCode,
                                buildingName = item.buildingName,
                                traderId = item.traderId,
                                name = inquiry.name,
                                tel = inquiry.tel,
                                mail = inquiry.mail,
                                buildingCheck = inquiryTypes.getValue(InquiryType.BuildingCheck),
                                vacancyInfo = inquiryTypes.getValue(InquiryType.VacancyInfo),
                                roomArrangemant = inquiryTypes.getValue(InquiryType.RoomArrangement),
                                shopVisit = inquiryTypes.getValue(InquiryType.ShopVisit),
                                consultationMoving = inquiryTypes.getValue(InquiryType.ConsultationMoving),
                                surroundingInfo = inquiryTypes.getValue(InquiryType.SurroundingInfo),
                                buildingIntroduction = inquiryTypes.getValue(InquiryType.BuildingIntroduction),
                                etc = inquiryTypes.getValue(InquiryType.Etc),
                                remark = inquiry.remark
                        )
                    }
                }
                RequestKind.TraderInquiry -> {
                    inquiry.traderItem?.let { item ->
                        listOf(Content(
                                deviceType = deviceType.toString(),
                                traderId = item.traderId,
                                name = inquiry.name,
                                tel = inquiry.tel,
                                mail = inquiry.mail,
                                buildingCheck = inquiryTypes.getValue(InquiryType.BuildingCheck),
                                vacancyInfo = inquiryTypes.getValue(InquiryType.VacancyInfo),
                                roomArrangemant = inquiryTypes.getValue(InquiryType.RoomArrangement),
                                shopVisit = inquiryTypes.getValue(InquiryType.ShopVisit),
                                consultationMoving = inquiryTypes.getValue(InquiryType.ConsultationMoving),
                                surroundingInfo = inquiryTypes.getValue(InquiryType.SurroundingInfo),
                                buildingIntroduction = inquiryTypes.getValue(InquiryType.BuildingIntroduction),
                                etc = inquiryTypes.getValue(InquiryType.Etc),
                                remark = inquiry.remark
                        ))
                    }
                }
            }

            return SendDataInquiryTerminalRequest(
                    function = "SendDataInquiryTerminal",
                    authCode = credential.authCode,
                    entryDate = credential.entryDate,
                    requestKind = when (inquiry.requestKind) {
                        RequestKind.PropertyInquiry -> "1"
                        RequestKind.TraderInquiry -> "2"
                    },
                    requestDate = dateFormat.format(inquiry.requestDate),
                    deviceType = deviceType.toString(),
                    content = content
            )
        }

        private fun List<InquiryType>.getValue(type: InquiryType): String? {
            if (contains(type)) {
                return "1"
            } else {
                return "0"
            }
        }
    }

    @JsonSerializable
    data class Content(
            @Json(name = "device_type")
            val deviceType: String,

            @Json(name = "property_full_id")
            val propertyFullId: String? = null,

            @Json(name = "firm_side_code")
            val firmSideCode: String? = null,

            @Json(name = "building_name")
            val buildingName: String? = null,

            @Json(name = "trader_id")
            val traderId: String,

            @Json(name = "name")
            val name: String,

            @Json(name = "furigana")
            val furigana: String? = null,

            @Json(name = "tel")
            val tel: String?,

            @Json(name = "mail")
            val mail: String?,

            @Json(name = "is_building_check")
            val buildingCheck: String?,

            @Json(name = "is_vacancy_info")
            val vacancyInfo: String?,

            @Json(name = "is_room_arrangemant")
            val roomArrangemant: String?,

            @Json(name = "is_shop_visit")
            val shopVisit: String?,

            @Json(name = "is_consultation_moving")
            val consultationMoving: String?,

            @Json(name = "is_surrounding_info")
            val surroundingInfo: String?,

            @Json(name = "is_building_introduction")
            val buildingIntroduction: String?,

            @Json(name = "is_etc")
            val etc: String?,

            @Json(name = "remark")
            val remark: String? = null
    )
}