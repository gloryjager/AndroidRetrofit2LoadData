/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.api.shared.urlbuilder.HouseKindMapper
import net.kentaku.api.shared.urlbuilder.toQueryParams
import net.kentaku.property.model.search.PropertySearchCondition

/**
 * UrlBuilder of GetListPropertyStationCommuting
 * Created by tsuyosh on 17/12/21.
 */
class GetListPropertyStationCommuting(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val searchCondition: PropertySearchCondition,
        private val offset: Int,
        private val limit: Int,
        private val houseKindMapper: HouseKindMapper
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            addAll(credentialFactory.create().toPairList())
            addAll(searchCondition.toQueryParams(houseKindMapper))
            add(Pair("start_number", (offset + 1).toString()))
            add(Pair("max_count", limit.toString()))
        }

        return build(path, params)
    }
}