/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared

import io.reactivex.Completable
import io.reactivex.Single
import net.kentaku.area.model.City
import net.kentaku.area.model.Town
import net.kentaku.inquiry.model.Inquiry
import net.kentaku.property.model.CityInfo
import net.kentaku.property.model.Property
import net.kentaku.property.model.PropertyDetail
import net.kentaku.property.model.search.KeywordSuggestionResult
import net.kentaku.property.model.search.PropertySearchCondition
import net.kentaku.property.model.search.PropertySearchResult
import net.kentaku.trader.model.TraderDetail
import net.kentaku.trader.model.SamePropertyTraderList
import net.kentaku.train.model.Line
import net.kentaku.train.model.LineKind
import net.kentaku.train.model.Station

/**
 * 建託版・ポータル版APIの抽象化ラッパー
 * Created by tsuyosh on 17/11/01.
 */
interface DktApiWrapper {
    /**
     * kentaku: GetListCityNumberProperty
     * portal: GetListCityNumberMergeProperty
     */
    fun getListCityNumberProperty(prefectureId: Int, renewDate: String? = null): Single<List<City>>

    /**
     * kentaku: GetListTownNumberProperty
     * portal: GetListTownNumberMergeProperty
     */
    fun getListTownNumberProperty(cityId: Int, renewDate: String? = null): Single<List<Town>>

    /**
     * kentaku: GetListLine
     * portal: GetListMergeLine
     */
    fun getListLine(prefectureId: Int, renewDate: String? = null, lineKind: LineKind): Single<List<Line>>

    /**
     * kentaku: GetListStationNumberProperty
     * portal: GetListStationNumberMergeProperty
     */
    fun getListStationNumberProperty(renewDate: String? = null, lineId: String): Single<List<Station>>

    /**
     * kentaku/portal: GetListStationCommuting
     */
    fun getListStationCommuting()

    /**
     * kentaku: GetListProperty
     * portal: GetListMergeProperty
     */
    fun getListProperty(
            searchCondition: PropertySearchCondition,
            offset: Int,
            limit: Int
    ): Single<PropertySearchResult>

    /**
     * kentaku/portal: GetCityInfo
     */
    fun getCityInfo(cityId: Int): Single<CityInfo>

    /**
     * kentaku/portal: SendDataInquiryTerminal
     */
    fun sendDataInquiryTerminal(inquiry: Inquiry): Completable

    /**
     * kentaku: GetDetailPropertyTerminal
     * portal: GetDetailMergeProperty
     */
    fun getDetailProperty(propertyFullIds: List<String>): Single<List<PropertyDetail>>

    /**
     * お気に入り物件や閲覧物件の情報を取得するためのAPI
     * 通常のDetail APIだと複数物件に対応していなかったりdisp_nameが空だったりして使い物にならないので
     * GetDetailProperty APIを利用しています。
     *
     * kentaku: GetDetailProperty
     * portal: GetDetailProperty
     */
    fun getPropertyById(propertyFullIds: List<String>): Single<List<Property>>

    /**
     * kentaku/portal: GetListTraderTerminal
     */
    fun getListTrader()

    /**
     * kentaku/portal: GetDetailTraderTerminal
     */
    fun getDetailTrader(traderIds: List<String>): Single<List<TraderDetail>>

    /**
     * kentaku: GetCampaignList
     */
    fun getCampaignList()

    /**
     * kentaku/portal: GetFavoritePropertyList
     */
    fun getFavoritePropertyList()

    /**
     * kentaku/portal: GetHistoryPropertyList
     */
    fun getHistoryPropertyList()

    /**
     * kentaku/portal: GetStorageConditionList
     */
    fun getStorageConditionList()

    /**
     * kentaku/portal: GetMatchPropertyNumber
     */
    fun getMatchPropertyNumber(searchCondition: PropertySearchCondition, renewDate: String? = null): Single<Int>

    /**
     * kentaku/portal: GetListSuggestKeyWord
     */
    fun getListSuggestKeyWord(renewDate: String? = null, prefectureId: Int? = null, inputWord: String, mode: Int = 0): Single<KeywordSuggestionResult>

    /**
     * kentaku/portal: GetMatchPropNumberCommute
     */
    fun getMatchPropNumberCommute()

    /**
     * kentaku/portal: GetAccessToken
     */
    fun getAccessToken()

    /**
     * kentaku/portal: GetMemberInfo
     */
    fun getMemberInfo()

    /**
     * kentaku/portal: SetFavoritePropertyList
     */
    fun setFavoritePropertyList()

    /**
     * kentaku/portal: DeleteFavoriteProperty
     */
    fun deleteFavoriteProperty()

    /**
     * portal: GetListCityNumberTrader
     */
    fun getListCityNumberTrader(prefectureId: Int, renewDate: String? = null): Single<List<City>>

    /**
     * portal: GetListStationNumberTrader
     */
    fun getListStationNumberTrader(renewDate: String? = null, prefectureId: Int, lineId: String): Single<List<Station>>

    /**
     * portal: GetSamePropertyTraderList
     */
    fun getSamePropertyTraderList(property_full_id: String): Single<SamePropertyTraderList>
}