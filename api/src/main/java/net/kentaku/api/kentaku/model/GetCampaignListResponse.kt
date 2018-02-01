package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetCampaignListResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "campaigns"
    )
    val campaigns: List<CampaignsItem>
) : DktApiResponse {
  @JsonSerializable
  data class CampaignsItem(
      @Json(
          name = "campaign_id"
      )
      val campaignId: Int,
      @Json(
          name = "url_data"
      )
      val urlData: UrlDataItem,
      @Json(
          name = "order"
      )
      val order: Int
  ) {
    @JsonSerializable
    data class UrlDataItem(@Json(
        name = "top_img_url"
    )
    val topImgUrl: String, @Json(
        name = "detail_web_view_url"
    )
    val detailWebViewUrl: String)
  }
}
