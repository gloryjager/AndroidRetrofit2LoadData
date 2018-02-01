package net.kentaku.api.portal.model

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
      val traderId: Int,
      @Json(
          name = "disp_name"
      )
      val dispName: String,
      @Json(
          name = "trade_name"
      )
      val tradeName: String,
      @Json(
          name = "firm_name"
      )
      val firmName: String,
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
          name = "traffic"
      )
      val traffic: List<String>,
      @Json(
          name = "tel"
      )
      val tel: String,
      @Json(
          name = "fax"
      )
      val fax: String,
      @Json(
          name = "open_hour"
      )
      val openHour: String,
      @Json(
          name = "place"
      )
      val place: List<String>,
      @Json(
          name = "staff"
      )
      val staff: List<String>,
      @Json(
          name = "other_service"
      )
      val otherService: List<String>,
      @Json(
          name = "service_area"
      )
      val serviceArea: List<String>,
      @Json(
          name = "licence_no"
      )
      val licenceNo: String,
      @Json(
          name = "group"
      )
      val group: String,
      @Json(
          name = "sell"
      )
      val sell: List<String>,
      @Json(
          name = "rent"
      )
      val rent: List<String>,
      @Json(
          name = "promotion"
      )
      val promotion: String,
      @Json(
          name = "remark"
      )
      val remark: String,
      @Json(
          name = "freecall_num"
      )
      val freecallNum: String? = null,
      @Json(
          name = "firm_side_firm_id"
      )
      val firmSideFirmId: String
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
