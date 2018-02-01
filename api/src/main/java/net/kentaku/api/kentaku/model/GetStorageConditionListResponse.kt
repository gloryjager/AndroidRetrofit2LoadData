package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetStorageConditionListResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "condition_total"
    )
    val conditionTotal: Int,
    @Json(
        name = "condition_list"
    )
    val conditionList: List<ConditionListItem>,
    @Json(
        name = "message"
    )
    override val message: String
) : DktApiResponse {
  @JsonSerializable
  data class ConditionListItem(
      @Json(
          name = "condition_id"
      )
      val conditionId: String,
      @Json(
          name = "storage_date"
      )
      val storageDate: String,
      @Json(
          name = "total"
      )
      val total: Int,
      @Json(
          name = "new_total"
      )
      val newTotal: Int,
      @Json(
          name = "disp_city_name"
      )
      val dispCityName: List<String>,
      @Json(
          name = "disp_station_name"
      )
      val dispStationName: List<String>,
      @Json(
          name = "disp_price"
      )
      val dispPrice: String,
      @Json(
          name = "disp_deposit"
      )
      val dispDeposit: String,
      @Json(
          name = "disp_key_money"
      )
      val dispKeyMoney: String,
      @Json(
          name = "disp_manage_cost"
      )
      val dispManageCost: String,
      @Json(
          name = "disp_house_plan"
      )
      val dispHousePlan: List<String>,
      @Json(
          name = "disp_condition"
      )
      val dispCondition: List<String>,
      @Json(
          name = "cond_url"
      )
      val condUrl: String
  )
}
