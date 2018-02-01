/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku

import io.reactivex.schedulers.Schedulers
import net.kentaku.api.kentaku.converter.toPropertyList
import net.kentaku.api.kentaku.model.GetDetailPropertyTerminalResponse
import org.junit.Assert
import org.junit.Test

/**
 * Created by tsuyosh on 17/10/12.
 */

class GetDetailPropertyTest : KentakuApiTest() {
    fun testMoshi() {
        val json = """
{"result": 0,"message": "","properties": [{"property_full_id": 300059800000092000629,"firm_side_code": "1-017504201-04030","disp_name": "エーデルシュタイン","property_name": "エーデルシュタイン","property_images" :[{"kind": 2,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-G.jpg","comment":"外観"},{"kind": 1,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-M.gif","comment":"間取図"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N1.jpg","comment":"居室"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N2.jpg","comment":"キッチン"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N3.jpg","comment":"風呂"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N4.jpg","comment":"洗面所"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N5.jpg","comment":"収納"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N6.jpg","comment":"玄関"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N7.jpg","comment":"トイレ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N8.jpg","comment":"セキュリティ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N9.jpg","comment":"その他設備"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N10.jpg","comment":"その他部屋・スペース"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N11.jpg","comment":"その他（画像）"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-04030-N12.jpg","comment":"バルコニー"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E1.jpg","comment":"下落合駅まで190ｍ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E2.jpg","comment":"ローソンまで165ｍ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E3.jpg","comment":"マルエツプチまで250ｍ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E4.jpg","comment":"高田馬場駅まで1190ｍ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E5.jpg","comment":"ドラッグぱぱすまで320ｍ"},{"kind": 3,"url": "e-heya.kentaku.net/directImage/017/504/201/017504201-E6.jpg","comment":"クリーニングまで195ｍ"}],"disp_price": "8.7万円","price": 87000,"disp_manage_cost": "3,000円","manage_cost": 3000,"disp_deposit": "0円","deposit": 0,"deposit_unit": 0,"disp_key_money": "1ヶ月","key_money": 1,"keymoney_unit": 2,"house_plan": "1K","disp_area": "27.09㎡","area": 27.09,"traffic": ["西武鉄道新宿線下落合駅 徒歩4分","東京都大江戸線中井駅 徒歩8分","山手線高田馬場駅 徒歩18分"],"address": "東京都新宿区上落合１丁目","latitude": 128576829,"longitude": 502893840,"completion_date": "2012年3月","house_age": "築5年","parking": "無し","floor": "4階/4階建","equipments": ["バス・トイレ別","浴室","シャワー","エアコン","クローゼット","洗面所独立","洗髪洗面化粧台","洗面化粧台","追い焚き","モニタ付インターホン","浴室乾燥","24時間換気システム","オートロック","セキュリティーキー","温水洗浄便座","暖房便座","BS","CATV","システムキッチン","ガス2口","室内洗濯機置場","都市ガス","バルコニー","フローリング","照明","駐輪場","浄水器","給湯","専用ゴミ置場","シューズボックス","外壁タイル貼り","24時間管理"],"window_direction": "南","into_date": "即入居可","building_kind":"マンション","building_structure": "鉄筋コンクリート","condition": ["更新手数料なし","更新料なし","敷金０","借家契約指定なし"],"insurance": "火災保険へのご加入をお願いいたします。","disp_town_cost": "25円","town_cost": 25,"exchange_style": "仲介","disp_standard_rate": "91,812円","standard_rate": 91812,"sales_point": "大東建託Ｌ池袋西口駅前店へ／最上階・南向き／更新料０／鍵交換費０／敷０／保証人不要／クレジットカード払いＯＫ／入居後も安心２４時間サポート付","special_remark": ["・保証会社原則加入 保証委託料 契約時：12,000円 月額：賃料総額の2%又は2.5%必要。\n・月額保証委託料：1,800円 (2％プランの場合)\n・契約時にクリーニング費として、￥32，400（税込）が必要となります。\n・鍵交換費用無料\n・[共益費等明細]\n共益費 3,000円"],"remarks": ["西武線の下落合駅まで徒歩２分・大江戸線の中井駅まで徒歩８分です。２線２駅利用可能。ＪＲ線の高田馬場駅まで乗車２分のアクセス。近隣にはスーパーマルエツが出来ました。新宿区のお部屋探しも大東建託Ｌ池袋西口駅前店にお任せください。"],"up_start_date": "2017年10月27日","up_renew_date": "2017年11月3日","new_build": false,"new_arrival": true,"cleaning":true,"key_exchange_free":true,"liveup":true, "credit":1, "liveup2":1,"traders": [{"trader_id": "305000","name": "大東建託リーシング株式会社  池袋西口駅前店","tel": "03-5950-0211","holiday": "なし:夏季／冬季休暇有り","open_hour": "10:15～19:00(10月4・11・18・25日は10:15～17:30となります)","address": "東京都豊島区西池袋１丁目１４番３号 ＩＮビル２階","free_dial": "0120-976-440","web_calling": "305000","freecall_num":"0800-100-5778"}]}]}
"""
        val adapter = moshi.adapter(GetDetailPropertyTerminalResponse::class.java)
        val response = adapter.fromJson(json)
        Assert.assertNotNull(response)
        response?.run {
            Assert.assertEquals(result, 0)
            properties?.run {
                Assert.assertEquals(1, size)
                Assert.assertEquals("300059800000092000629", this[0].propertyFullId)
                Assert.assertEquals(27.09f, this[0].area)
            }
        }
        println(response)
    }

    @Test
    fun testGetDetailPropertyTerminal() {
        val propertyList = api.getListProperty("/kentakuapi/callApp.jsp?function=GetListProperty&auth_code=218993f4634&entry_date=201708301655&start_number=1&max_count=100&city_id=13102&city_id=13103&city_id=13104&city_id=13105")
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()

        propertyList.properties.map {
            it.propertyFullId
        }.forEach {
            val url = "/kentakuapi/callApp.jsp?function=GetDetailProperty&auth_code=218993f4634&entry_date=201708301655&property_full_id=" + it
            println(baseUrl + url)
            val propertyDetailResponse = api.getDetailProperty(url)
                    .subscribeOn(Schedulers.io())
                    .test().await().assertNoErrors().values().first()
            println(propertyDetailResponse)
            println(propertyDetailResponse.toPropertyList())
        }
    }
}