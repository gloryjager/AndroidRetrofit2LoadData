/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal

import io.reactivex.schedulers.Schedulers
import net.kentaku.api.portal.converter.toPropertyList
import net.kentaku.api.portal.model.GetDetailMergePropertyResponse
import org.junit.Assert
import org.junit.Test

/**
 * Created by tsuyosh on 17/10/12.
 */

class GetDetailPropertyTest : PortalApiTest() {
    fun testMoshi() {
        val json = """
{"result": 0,"message": "","properties": [{"property_full_id": 300127611000190000001,"disp_name": "茗荷谷駅　1R　2階","property_name": "光風荘","room_number_text": "2-12","property_images": [{"kind": 1,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_1_1.jpg"},{"kind": 10,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_10_1.jpg"},{"kind": 15,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_15_1.jpg"},{"kind": 4,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_4_1.jpg"},{"kind": 19,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_19_1.jpg"},{"kind": 19,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_19_2.jpg"},{"kind": 15,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_15_2.jpg"},{"kind": 15,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_15_3.jpg"},{"kind": 15,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_15_4.jpg"},{"kind": 13,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_13_1.jpg"},{"kind": 13,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_13_2.jpg"},{"kind": 13,"url": "www.eheya.net/propertyimage/000/000/300/127/611/000/190/000/001/000000300127611000190000001_13_3.jpg"}],"same_property_num": 1,"address": "東京都文京区小日向３丁目","latitude": 128575382,"longitude": 503037246,"traffic": ["東京地下鉄丸ノ内線茗荷谷駅 徒歩7分","東京地下鉄有楽町線護国寺駅 徒歩8分","東京地下鉄東西線神楽坂駅 徒歩18分"],"house_plan": "1R（和室4.5畳）","disp_area": "10","area": 10,"disp_price": "2.5万円","price": 25000,"disp_manage_cost": "1,500円","manage_cost": 1500,"disp_deposit": "1.0ヶ月","deposit": 1,"deposit_unit": 2,"disp_key_money": "1.0ヶ月","key_money": 1.0,"keymoney_unit": 2,"disp_repair_cost": "-","repair_cost": null,"repaircost_unit": 1,"completion_date": "1955年1月","house_age": "築62年","parking": "無し","floor": "2階 / 2階建 部屋番号:2-12","equipments": ["都市ガス","駐輪場有り","ガスコンロ","コンロ2口以上","押入","光ファイバー","インターネット"],"window_direction": "北","into_date": "即入居可","building_kind":"アパート","building_structure": "木造","firm_side_code": "D11129","condition": ["普通賃借契約 (契約期間2年）","最上階"],"insurance": "-","exchange_style": "仲介","sales_point": "★文京区に賃料3万円以内で住もう♪初期費用は約10万＋前家賃★水道代込　複数路線利用可能で便利です！","special_remark": ["★「ネオプラ池袋」で検索★","雑費月額：1,450円"],"remarks": ["★お部屋探しは「ネオプラ」で決まり★"],"cosigner": "不要 保証人代行：（任意） 全保連 初回保証料：家賃総額の50%～","up_start_date": "2016年11月11日","up_end_date": "2017年11月2日","new_build": false,"new_arrival": false,"traders": [{"trader_id": 12761,"name": "株式会社ネオ・プランニング　","tel": "03-5985-4401","address": "東京都豊島区南池袋１丁目１８-２３","freecall_num":null}]}]}
"""
        val adapter = moshi.adapter(GetDetailMergePropertyResponse::class.java)
        val response = adapter.fromJson(json)
        Assert.assertNotNull(response)
        response?.run {
            Assert.assertEquals(result, 0)
            properties?.run {
                Assert.assertEquals(1, size)
                Assert.assertEquals("300127611000190000001", this[0].propertyFullId)
                Assert.assertEquals(10f, this[0].area)
            }
        }
        println(response)
    }

    @Test
    fun testGetDetailPropertyTerminal() {
        val propertyList = api.getListMergeProperty("/portalapi/callApp.jsp?function=GetListMergeProperty&auth_code=218993f4634&entry_date=201708301655&start_number=1&max_count=100&city_id=13102&city_id=13103&city_id=13104&city_id=13105")
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()

        val propertyFullIds = propertyList.properties
                .map {
                    it.sameBuildingProperties.map {
                        it.propertyFullId
                    }
                }
                .flatten()
                .slice(0 until 4)

        val params = propertyFullIds.map { "property_full_id=" + it }.joinToString("&")
        val url = "/portalapi/callApp.jsp?function=GetDetailProperty&auth_code=218993f4634&entry_date=201708301655&" + params
        println(baseUrl + url)
        val propertyDetailResponse = api.getDetailProperty(url)
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()
        println(propertyDetailResponse)
        println(propertyDetailResponse.toPropertyList())
    }
}