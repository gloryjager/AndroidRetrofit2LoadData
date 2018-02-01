package net.kentaku.api.kentaku

import io.reactivex.Single
import kotlin.String
import net.kentaku.api.kentaku.model.DeleteFavoritePropertyResponse
import net.kentaku.api.kentaku.model.GetAccessTokenResponse
import net.kentaku.api.kentaku.model.GetCampaignListResponse
import net.kentaku.api.kentaku.model.GetCityInfoResponse
import net.kentaku.api.kentaku.model.GetDetailPropertyResponse
import net.kentaku.api.kentaku.model.GetDetailPropertyTerminalResponse
import net.kentaku.api.kentaku.model.GetDetailTraderTerminalResponse
import net.kentaku.api.kentaku.model.GetFavoritePropertyListResponse
import net.kentaku.api.kentaku.model.GetHistoryPropertyListResponse
import net.kentaku.api.kentaku.model.GetListCityNumberPropertyResponse
import net.kentaku.api.kentaku.model.GetListLineResponse
import net.kentaku.api.kentaku.model.GetListPropertyResponse
import net.kentaku.api.kentaku.model.GetListStationCommutingResponse
import net.kentaku.api.kentaku.model.GetListStationNumberPropertyResponse
import net.kentaku.api.kentaku.model.GetListSuggestKeyWordResponse
import net.kentaku.api.kentaku.model.GetListTownNumberPropertyResponse
import net.kentaku.api.kentaku.model.GetListTraderTerminalResponse
import net.kentaku.api.kentaku.model.GetMatchPropNumberCommuteResponse
import net.kentaku.api.kentaku.model.GetMatchPropertyNumberResponse
import net.kentaku.api.kentaku.model.GetMemberInfoResponse
import net.kentaku.api.kentaku.model.GetStorageConditionListResponse
import net.kentaku.api.kentaku.model.SendDataInquiryTerminalResponse
import net.kentaku.api.kentaku.model.SetFavoritePropertyListResponse
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * 建託版API
 */
interface DktKentakuApi {
  /**
   * GetListCityNumberProperty
   */
  @GET
  fun getListCityNumberProperty(@Url url: String): Single<GetListCityNumberPropertyResponse>

  /**
   * GetListTownNumberProperty
   */
  @GET
  fun getListTownNumberProperty(@Url url: String): Single<GetListTownNumberPropertyResponse>

  /**
   * GetListLine
   */
  @GET
  fun getListLine(@Url url: String): Single<GetListLineResponse>

  /**
   * GetListStationNumberProperty
   */
  @GET
  fun getListStationNumberProperty(@Url url: String): Single<GetListStationNumberPropertyResponse>

  /**
   * GetListStationCommuting
   */
  @GET
  fun getListStationCommuting(@Url url: String): Single<GetListStationCommutingResponse>

  /**
   * GetListProperty
   */
  @GET
  fun getListProperty(@Url url: String): Single<GetListPropertyResponse>

  /**
   * GetDetailProperty
   */
  @GET
  fun getDetailProperty(@Url url: String): Single<GetDetailPropertyResponse>

  /**
   * GetCityInfo
   */
  @GET
  fun getCityInfo(@Url url: String): Single<GetCityInfoResponse>

  /**
   * SendDataInquiryTerminal
   */
  @GET
  fun sendDataInquiryTerminal(@Url url: String): Single<SendDataInquiryTerminalResponse>

  /**
   * GetDetailPropertyTerminal
   */
  @GET
  fun getDetailPropertyTerminal(@Url url: String): Single<GetDetailPropertyTerminalResponse>

  /**
   * GetListTraderTerminal
   */
  @GET
  fun getListTraderTerminal(@Url url: String): Single<GetListTraderTerminalResponse>

  /**
   * GetDetailTraderTerminal
   */
  @GET
  fun getDetailTraderTerminal(@Url url: String): Single<GetDetailTraderTerminalResponse>

  /**
   * GetCampaignList
   */
  @GET
  fun getCampaignList(@Url url: String): Single<GetCampaignListResponse>

  /**
   * GetFavoritePropertyList
   */
  @GET
  fun getFavoritePropertyList(@Url url: String): Single<GetFavoritePropertyListResponse>

  /**
   * GetHistoryPropertyList
   */
  @GET
  fun getHistoryPropertyList(@Url url: String): Single<GetHistoryPropertyListResponse>

  /**
   * GetStorageConditionList
   */
  @GET
  fun getStorageConditionList(@Url url: String): Single<GetStorageConditionListResponse>

  /**
   * GetMatchPropertyNumber
   */
  @GET
  fun getMatchPropertyNumber(@Url url: String): Single<GetMatchPropertyNumberResponse>

  /**
   * GetListSuggestKeyWord
   */
  @GET
  fun getListSuggestKeyWord(@Url url: String): Single<GetListSuggestKeyWordResponse>

  /**
   * GetMatchPropNumberCommute
   */
  @GET
  fun getMatchPropNumberCommute(@Url url: String): Single<GetMatchPropNumberCommuteResponse>

  /**
   * GetAccessToken
   */
  @GET
  fun getAccessToken(@Url url: String): Single<GetAccessTokenResponse>

  /**
   * GetMemberInfo
   */
  @GET
  fun getMemberInfo(@Url url: String): Single<GetMemberInfoResponse>

  /**
   * SetFavoritePropertyList
   */
  @GET
  fun setFavoritePropertyList(@Url url: String): Single<SetFavoritePropertyListResponse>

  /**
   * DeleteFavoriteProperty
   */
  @GET
  fun deleteFavoriteProperty(@Url url: String): Single<DeleteFavoritePropertyResponse>
}
