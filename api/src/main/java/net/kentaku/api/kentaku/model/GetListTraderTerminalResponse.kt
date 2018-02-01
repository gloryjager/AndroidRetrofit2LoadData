package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListTraderTerminalResponse(
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
        name = "traders"
    )
    val traders: List<TradersItem>
) : DktApiResponse {
  @JsonSerializable
  data class TradersItem(
      @Json(
          name = "trader_id"
      )
      val traderId: String,
      @Json(
          name = "prefecture_id"
      )
      val prefectureId: Int,
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
          name = "tel"
      )
      val tel: String,
      @Json(
          name = "free_dial"
      )
      val freeDial: String,
      @Json(
          name = "web_calling"
      )
      val webCalling: String,
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
      val freecallNum: String? = null
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
