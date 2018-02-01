package net.kentaku.api.portal

import io.reactivex.Single
import kotlin.String
import net.kentaku.api.portal.model.DeleteFavoritePropertyResponse
import net.kentaku.api.portal.model.GetAccessTokenResponse
import net.kentaku.api.portal.model.GetCityInfoResponse
import net.kentaku.api.portal.model.GetDetailMergePropertyResponse
import net.kentaku.api.portal.model.GetDetailPropertyResponse
import net.kentaku.api.portal.model.GetDetailTraderTerminalResponse
import net.kentaku.api.portal.model.GetFavoritePropertyListResponse
import net.kentaku.api.portal.model.GetHistoryPropertyListResponse
import net.kentaku.api.portal.model.GetListCityNumberMergePropertyResponse
import net.kentaku.api.portal.model.GetListCityNumberTraderResponse
import net.kentaku.api.portal.model.GetListMergeLineResponse
import net.kentaku.api.portal.model.GetListMergePropertyResponse
import net.kentaku.api.portal.model.GetListStationCommutingResponse
import net.kentaku.api.portal.model.GetListStationNumberMergePropertyResponse
import net.kentaku.api.portal.model.GetListStationNumberTraderResponse
import net.kentaku.api.portal.model.GetListSuggestKeyWordResponse
import net.kentaku.api.portal.model.GetListTownNumberMergePropertyResponse
import net.kentaku.api.portal.model.GetListTraderTerminalResponse
import net.kentaku.api.portal.model.GetMatchPropNumberCommuteResponse
import net.kentaku.api.portal.model.GetMatchPropertyNumberResponse
import net.kentaku.api.portal.model.GetMemberInfoResponse
import net.kentaku.api.portal.model.GetSamePropertyTraderListResponse
import net.kentaku.api.portal.model.GetStorageConditionListResponse
import net.kentaku.api.portal.model.SendDataInquiryTerminalResponse
import net.kentaku.api.portal.model.SetFavoritePropertyListResponse
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * ポータル版API
 */
interface DktPortalApi {
  /**
   * GetListCityNumberMergeProperty
   */
  @GET
  fun getListCityNumberMergeProperty(@Url url: String): Single<GetListCityNumberMergePropertyResponse>

  /**
   * GetListTownNumberMergeProperty
   */
  @GET
  fun getListTownNumberMergeProperty(@Url url: String): Single<GetListTownNumberMergePropertyResponse>

  /**
   * GetListStationCommuting
   */
  @GET
  fun getListStationCommuting(@Url url: String): Single<GetListStationCommutingResponse>

  /**
   * GetListCityNumberTrader
   */
  @GET
  fun getListCityNumberTrader(@Url url: String): Single<GetListCityNumberTraderResponse>

  /**
   * GetListStationNumberTrader
   */
  @GET
  fun getListStationNumberTrader(@Url url: String): Single<GetListStationNumberTraderResponse>

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
   * GetListMergeProperty
   */
  @GET
  fun getListMergeProperty(@Url url: String): Single<GetListMergePropertyResponse>

  /**
   * GetDetailProperty
   */
  @GET
  fun getDetailProperty(@Url url: String): Single<GetDetailPropertyResponse>

  /**
   * GetDetailMergeProperty
   */
  @GET
  fun getDetailMergeProperty(@Url url: String): Single<GetDetailMergePropertyResponse>

  /**
   * GetSamePropertyTraderList
   */
  @GET
  fun getSamePropertyTraderList(@Url url: String): Single<GetSamePropertyTraderListResponse>

  /**
   * GetListMergeLine
   */
  @GET
  fun getListMergeLine(@Url url: String): Single<GetListMergeLineResponse>

  /**
   * GetListStationNumberMergeProperty
   */
  @GET
  fun getListStationNumberMergeProperty(@Url url: String): Single<GetListStationNumberMergePropertyResponse>

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
  fun deleteFavoriteProperty(@Url url: String): Single<DeleteFavoritePropertyResponse> /**
   * DeleteFavoriteProperty
   */
  @GET
  fun getGetSamePropertyTraderList(@Url url: String): Single<GetSamePropertyTraderListResponse>
}
