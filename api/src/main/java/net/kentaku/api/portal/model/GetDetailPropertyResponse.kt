/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetDetailPropertyResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "properties"
    )
    val properties: List<PropertiesItem>
) : DktApiResponse {
  @JsonSerializable
  data class PropertiesItem(
      @Json(
          name = "property_full_id"
      )
      val propertyFullId: String,
      @Json(
          name = "disp_name"
      )
      val dispName: String,
      @Json(
          name = "property_name"
      )
      val propertyName: String,
      @Json(
          name = "property_images"
      )
      val propertyImages: List<PropertyImagesItem>,
      @Json(
          name = "address"
      )
      val address: String,
      @Json(
          name = "latitude"
      )
      val latitude: Int? = null,
      @Json(
          name = "longitude"
      )
      val longitude: Int? = null,
      @Json(
          name = "traffic"
      )
      val traffic: List<String>,
      @Json(
          name = "house_plan"
      )
      val housePlan: String,
      @Json(
          name = "disp_area"
      )
      val dispArea: String,
      @Json(
          name = "area"
      )
      val area: Float,
      @Json(
          name = "disp_price"
      )
      val dispPrice: String,
      @Json(
          name = "price"
      )
      val price: Int,
      @Json(
          name = "disp_manage_cost"
      )
      val dispManageCost: String,
      @Json(
          name = "manage_cost"
      )
      val manageCost: Int? = null,
      @Json(
          name = "disp_deposit"
      )
      val dispDeposit: String,
      @Json(
          name = "deposit"
      )
      val deposit: Float? = null,
      @Json(
          name = "deposit_unit"
      )
      val depositUnit: String,
      @Json(
          name = "disp_key_money"
      )
      val dispKeyMoney: String,
      @Json(
          name = "key_money"
      )
      val keyMoney: Float? = null,
      @Json(
          name = "keymoney_unit"
      )
      val keymoneyUnit: Int,
      @Json(
          name = "disp_repair_cost"
      )
      val dispRepairCost: String,
      @Json(
          name = "repair_cost"
      )
      val repairCost: Float? = null,
      @Json(
          name = "repaircost_unit"
      )
      val repaircostUnit: Int,
      @Json(
          name = "completion_date"
      )
      val completionDate: String,
      @Json(
          name = "house_age"
      )
      val houseAge: String,
      @Json(
          name = "parking"
      )
      val parking: String,
      @Json(
          name = "floor"
      )
      val floor: String,
      @Json(
          name = "equipments"
      )
      val equipments: List<String>,
      @Json(
          name = "window_direction"
      )
      val windowDirection: String,
      @Json(
          name = "into_date"
      )
      val intoDate: String,
      @Json(
          name = "building_kind"
      )
      val buildingKind: String,
      @Json(
          name = "building_structure"
      )
      val buildingStructure: String,
      @Json(
          name = "firm_side_code"
      )
      val firmSideCode: String,
      @Json(
          name = "condition"
      )
      val condition: List<String>,
      @Json(
          name = "insurance"
      )
      val insurance: String,
      @Json(
          name = "exchange_style"
      )
      val exchangeStyle: String,
      @Json(
          name = "sales_point"
      )
      val salesPoint: String,
      @Json(
          name = "special_remark"
      )
      val specialRemark: List<String>,
      @Json(
          name = "remarks"
      )
      val remarks: List<String>,
      @Json(
          name = "cosigner"
      )
      val cosigner: String,
      @Json(
          name = "up_start_date"
      )
      val upStartDate: String,
      @Json(
          name = "up_end_date"
      )
      val upEndDate: String,
      @Json(
          name = "new_build"
      )
      val newBuild: Boolean,
      @Json(
          name = "new_arrival"
      )
      val newArrival: Boolean,
      @Json(
          name = "traders"
      )
      val traders: List<TradersItem>
  ) {
    @JsonSerializable
    data class PropertyImagesItem(@Json(
        name = "kind"
    )
    val kind: Int, @Json(
        name = "url"
    )
    val url: String)

    @JsonSerializable
    data class TradersItem(
        @Json(
            name = "trader_id"
        )
        val traderId: String,
        @Json(
            name = "name"
        )
        val name: String,
        @Json(
            name = "tel"
        )
        val tel: String,
        @Json(
            name = "address"
        )
        val address: String,
        @Json(
            name = "freecall_num"
        )
        val freecallNum: String? = null
    )
  }
}
