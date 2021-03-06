package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetSamePropertyTraderListResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "property_name"
    )
    val propertyName: String,
    @Json(
        name = "trader_num"
    )
    val traderNum: Int,
    @Json(
        name = "traders"
    )
    val traders: List<TradersItem>
) : DktApiResponse {
  @JsonSerializable
  data class TradersItem(
      @Json(
          name = "trader_id"
      )
      val traderId: Int,
      @Json(
          name = "name"
      )
      val name: String,
      @Json(
          name = "images"
      )
      val images: ImagesItem,
      @Json(
          name = "address"
      )
      val address: String,
      @Json(
          name = "nearest_station"
      )
      val nearestStation: String,
      @Json(
          name = "traffic"
      )
      val traffic: String,
      @Json(
          name = "tel"
      )
      val tel: String,
      @Json(
          name = "open_hour"
      )
      val openHour: String,
      @Json(
          name = "latitude"
      )
      val latitude: Int? = null,
      @Json(
          name = "longitude"
      )
      val longitude: Int? = null,
      @Json(
          name = "freecall_num"
      )
      val freecallNum: String? = null,
      @Json(
          name = "property_full_id"
      )
      val propertyFullId: String,
      @Json(
          name = "firm_side_code"
      )
      val firmSideCode: String
  ) {
    @JsonSerializable
    data class ImagesItem(@Json(
        name = "kind"
    )
    val kind: Int, @Json(
        name = "url"
    )
    val url: String)
  }
}
