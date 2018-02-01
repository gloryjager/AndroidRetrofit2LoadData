package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import kotlin.String
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.api.shared.urlbuilder.toQueryParams

/**
 * UrlBuilder of GetSamePropertyTraderList
 */
class GetSamePropertyTraderList(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val property_full_id: String,
        private val deviceType: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetSamePropertyTraderList"))
            addAll(credentialFactory.create().toPairList())
            add(Pair("property_full_id", property_full_id))
            add(Pair("device_type", deviceType.toString()))
        }
        return build(path, params)
    }
}
