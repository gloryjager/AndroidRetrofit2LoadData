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
data class GetListMergePropertyResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "total_count"
    )
    val totalCount: Int,
    @Json(
        name = "start_number"
    )
    val startNumber: Int,
    @Json(
        name = "properties"
    )
    val properties: List<PropertiesItem>
) : DktApiResponse {
  @JsonSerializable
  data class PropertiesItem(
      @Json(
          name = "disp_name"
      )
      val dispName: String,
      @Json(
          name = "property_name"
      )
      val propertyName: String,
      @Json(
          name = "room_number_text"
      )
      val roomNumberText: String,
      @Json(
          name = "traffic"
      )
      val traffic: String,
      @Json(
          name = "address"
      )
      val address: String,
      @Json(
          name = "all_floor_num"
      )
      val allFloorNum: String,
      @Json(
          name = "house_age"
      )
      val houseAge: String,
      @Json(
          name = "completion_date"
      )
      val completionDate: String,
      @Json(
          name = "new_build"
      )
      val newBuild: Boolean,
      @Json(
          name = "building_kind"
      )
      val buildingKind: String,
      @Json(
          name = "city_id"
      )
      val cityId: Int,
      @Json(
          name = "latitude"
      )
      val latitude: Int? = null,
      @Json(
          name = "longitude"
      )
      val longitude: Int? = null,
      @Json(
          name = "property_images"
      )
      val propertyImages: List<PropertyImagesItem>,
      @Json(
          name = "same_building_num"
      )
      val sameBuildingNum: Int,
      @Json(
          name = "same_building_properties"
      )
      val sameBuildingProperties: List<SameBuildingPropertiesItem>
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
    data class SameBuildingPropertiesItem(
        @Json(
            name = "property_full_id"
        )
        val propertyFullId: String,
        @Json(
            name = "firm_side_code"
        )
        val firmSideCode: String,
        @Json(
            name = "floor"
        )
        val floor: String,
        @Json(
            name = "room_number_text"
        )
        val roomNumberText: String,
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
        val depositUnit: Int,
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
            name = "trader_id"
        )
        val traderId: Int,
        @Json(
            name = "new_arrival"
        )
        val newArrival: Boolean
    )
  }
}
