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
data class GetFavoritePropertyListResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "fav_total"
    )
    val favTotal: Int,
    @Json(
        name = "properties"
    )
    val properties: List<PropertiesItem>,
    @Json(
        name = "message"
    )
    override val message: String
) : DktApiResponse {
  @JsonSerializable
  data class PropertiesItem(@Json(
      name = "site_kind"
  )
  val siteKind: Int, @Json(
      name = "property_list"
  )
  val propertyList: List<PropertyListItem>) {
    @JsonSerializable
    data class PropertyListItem(
        @Json(
            name = "property_full_id"
        )
        val propertyFullId: String,
        @Json(
            name = "property_images"
        )
        val propertyImages: List<PropertyImagesItem>,
        @Json(
            name = "insert_date"
        )
        val insertDate: String,
        @Json(
            name = "property_name"
        )
        val propertyName: String,
        @Json(
            name = "address"
        )
        val address: String,
        @Json(
            name = "price"
        )
        val price: Int,
        @Json(
            name = "manage_cost"
        )
        val manageCost: Int? = null,
        @Json(
            name = "deposit"
        )
        val deposit: Float? = null,
        @Json(
            name = "deposit_unit"
        )
        val depositUnit: Int,
        @Json(
            name = "key_money"
        )
        val keyMoney: Float? = null,
        @Json(
            name = "keymoney_unit"
        )
        val keymoneyUnit: Int,
        @Json(
            name = "guarantee"
        )
        val guarantee: Int,
        @Json(
            name = "guarantee_unit"
        )
        val guaranteeUnit: Int,
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
            name = "area"
        )
        val area: Float,
        @Json(
            name = "window_direction"
        )
        val windowDirection: String,
        @Json(
            name = "into_date"
        )
        val intoDate: String,
        @Json(
            name = "traffic"
        )
        val traffic: List<String>,
        @Json(
            name = "completion_date"
        )
        val completionDate: String,
        @Json(
            name = "building_kind"
        )
        val buildingKind: String,
        @Json(
            name = "building_structure"
        )
        val buildingStructure: String,
        @Json(
            name = "house_age"
        )
        val houseAge: String,
        @Json(
            name = "floor"
        )
        val floor: String,
        @Json(
            name = "all_floor"
        )
        val allFloor: String,
        @Json(
            name = "new_build"
        )
        val newBuild: Boolean,
        @Json(
            name = "new_arrival"
        )
        val newArrival: Boolean,
        @Json(
            name = "cleaning"
        )
        val cleaning: Boolean,
        @Json(
            name = "key_exchange_free"
        )
        val keyExchangeFree: Boolean,
        @Json(
            name = "liveup"
        )
        val liveup: Boolean,
        @Json(
            name = "credit"
        )
        val credit: Int,
        @Json(
            name = "liveup2"
        )
        val liveup2: Int
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
}
