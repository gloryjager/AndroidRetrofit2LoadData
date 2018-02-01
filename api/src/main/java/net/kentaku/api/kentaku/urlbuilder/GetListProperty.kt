package net.kentaku.api.kentaku.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.api.shared.urlbuilder.HouseKindMapper
import net.kentaku.api.shared.urlbuilder.toQueryParams
import net.kentaku.property.model.search.PropertySearchCondition

/**
 * UrlBuilder of GetListProperty
 */
class GetListProperty(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val searchCondition: PropertySearchCondition,
        private val offset: Int,
        private val limit: Int,
        private val houseKindMapper: HouseKindMapper
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetListProperty"))
            addAll(credentialFactory.create().toPairList())
            addAll(searchCondition.toQueryParams(houseKindMapper))
            add(Pair("start_number", (offset + 1).toString()))
            add(Pair("max_count", limit.toString()))
        }

        return build(path, params)
    }
}
