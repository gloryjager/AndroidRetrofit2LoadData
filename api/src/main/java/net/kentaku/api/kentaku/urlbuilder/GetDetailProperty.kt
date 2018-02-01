/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetDetailProperty
 */
class GetDetailProperty(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val propertyFullIds: List<String>
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetDetailProperty"))
            addAll(credentialFactory.create().toPairList())
            addAll(propertyFullIds.map { Pair("property_full_id", it) })
        }
        return build(path, params)
    }
}
