package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListPropertyResponse(
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
          name = "property_full_id"
      )
      val propertyFullId: String,
      @Json(
          name = "firm_side_code"
      )
      val firmSideCode: String,
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
          name = "city_id"
      )
      val cityId: Int,
      @Json(
          name = "address"
      )
      val address: String,
      @Json(
          name = "traffic"
      )
      val traffic: String,
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
          name = "completion_date"
      )
      val completionDate: String,
      @Json(
          name = "house_age"
      )
      val houseAge: String,
      @Json(
          name = "trader_id"
      )
      val traderId: String,
      @Json(
          name = "new_build"
      )
      val newBuild: Boolean,
      @Json(
          name = "new_arrival"
      )
      val newArrival: Boolean,
      @Json(
          name = "latitude"
      )
      val latitude: Int? = null,
      @Json(
          name = "longitude"
      )
      val longitude: Int? = null,
      @Json(
          name = "building_kind"
      )
      val buildingKind: String
  ) {
    @JsonSerializable
    data class PropertyImagesItem(
        @Json(
            name = "kind"
        )
        val kind: Int,
        @Json(
            name = "url"
        )
        val url: String,
        @Json(
            name = "comment"
        )
        val comment: String
    )
  }
}
