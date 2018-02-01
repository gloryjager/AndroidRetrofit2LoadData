package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetDetailTraderTerminalResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
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
          name = "branch_name"
      )
      val branchName: String,
      @Json(
          name = "images"
      )
      val images: List<ImagesItem>,
      @Json(
          name = "latitude"
      )
      val latitude: Int? = null,
      @Json(
          name = "longitude"
      )
      val longitude: Int? = null,
      @Json(
          name = "address"
      )
      val address: String,
      @Json(
          name = "tel"
      )
      val tel: String,
      @Json(
          name = "open_hour"
      )
      val openHour: String,
      @Json(
          name = "holiday"
      )
      val holiday: String,
      @Json(
          name = "fax"
      )
      val fax: String,
      @Json(
          name = "promotion"
      )
      val promotion: String,
      @Json(
          name = "licence_no"
      )
      val licenceNo: String,
      @Json(
          name = "free_dial"
      )
      val freeDial: String,
      @Json(
          name = "web_calling"
      )
      val webCalling: String,
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
