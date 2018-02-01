package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetCityInfoResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "city_info"
    )
    val cityInfo: CityInfoItem
) : DktApiResponse {
  @JsonSerializable
  data class CityInfoItem(
      @Json(
          name = "city_name"
      )
      val cityName: String,
      @Json(
          name = "name_english"
      )
      val nameEnglish: String,
      @Json(
          name = "name_kana"
      )
      val nameKana: String,
      @Json(
          name = "profile"
      )
      val profile: String,
      @Json(
          name = "population"
      )
      val population: String,
      @Json(
          name = "city_address"
      )
      val cityAddress: String,
      @Json(
          name = "city_tel"
      )
      val cityTel: String,
      @Json(
          name = "city_page"
      )
      val cityPage: String,
      @Json(
          name = "tokusan_info"
      )
      val tokusanInfo: String,
      @Json(
          name = "event_info"
      )
      val eventInfo: String,
      @Json(
          name = "gas_info"
      )
      val gasInfo: List<GasInfoItem>,
      @Json(
          name = "water_info"
      )
      val waterInfo: List<WaterInfoItem>,
      @Json(
          name = "sewage_info"
      )
      val sewageInfo: List<SewageInfoItem>,
      @Json(
          name = "hazardmap_info"
      )
      val hazardmapInfo: String,
      @Json(
          name = "hazardmap_url"
      )
      val hazardmapUrl: String,
      @Json(
          name = "citypark_num"
      )
      val cityparkNum: String,
      @Json(
          name = "library_num"
      )
      val libraryNum: String,
      @Json(
          name = "childiryojosei_age1"
      )
      val childiryojoseiAge1: String,
      @Json(
          name = "childiryojosei_futan1"
      )
      val childiryojoseiFutan1: String,
      @Json(
          name = "childiryojosei_furanremark1"
      )
      val childiryojoseiFuranremark1: String,
      @Json(
          name = "childiryojosei_income1"
      )
      val childiryojoseiIncome1: String,
      @Json(
          name = "childiryojosei_income_1"
      )
      val childiryojoseiIncome_1: String,
      @Json(
          name = "childiryojosei_age2"
      )
      val childiryojoseiAge2: String,
      @Json(
          name = "childiryojosei_futan2"
      )
      val childiryojoseiFutan2: String,
      @Json(
          name = "childiryojosei_furanremark2"
      )
      val childiryojoseiFuranremark2: String,
      @Json(
          name = "childiryojosei_income2"
      )
      val childiryojoseiIncome2: String,
      @Json(
          name = "childiryojosei_income_2"
      )
      val childiryojoseiIncome_2: String,
      @Json(
          name = "babygift"
      )
      val babygift: String,
      @Json(
          name = "babygift_remark"
      )
      val babygiftRemark: String,
      @Json(
          name = "nurseryschool"
      )
      val nurseryschool: String,
      @Json(
          name = "nurseryschool_u0"
      )
      val nurseryschoolU0: String,
      @Json(
          name = "private_nurseryschool"
      )
      val privateNurseryschool: String,
      @Json(
          name = "private_nurseryschool_u0"
      )
      val privateNurseryschoolU0: String,
      @Json(
          name = "wating_child"
      )
      val watingChild: String,
      @Json(
          name = "kindergarten_pub"
      )
      val kindergartenPub: String,
      @Json(
          name = "kindergarten_pro"
      )
      val kindergartenPro: String,
      @Json(
          name = "elementaryschool_num"
      )
      val elementaryschoolNum: String,
      @Json(
          name = "juniorhighscool_num"
      )
      val juniorhighscoolNum: String,
      @Json(
          name = "hospital_num"
      )
      val hospitalNum: String,
      @Json(
          name = "child_rearing_related"
      )
      val childRearingRelated: String
  ) {
    @JsonSerializable
    data class GasInfoItem(@Json(
        name = "gas_item"
    )
    val gasItem: String, @Json(
        name = "gas_price"
    )
    val gasPrice: String)

    @JsonSerializable
    data class WaterInfoItem(@Json(
        name = "water_item"
    )
    val waterItem: String, @Json(
        name = "water_price"
    )
    val waterPrice: String)

    @JsonSerializable
    data class SewageInfoItem(@Json(
        name = "sewage_item"
    )
    val sewageItem: String, @Json(
        name = "sewage_price"
    )
    val sewagePrice: String)
  }
}
