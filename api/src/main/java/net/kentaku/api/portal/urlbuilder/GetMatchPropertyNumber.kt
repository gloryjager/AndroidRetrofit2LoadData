package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.api.shared.urlbuilder.HouseKindMapper
import net.kentaku.api.shared.urlbuilder.toQueryParams
import net.kentaku.property.model.search.PropertySearchCondition

/**
 * UrlBuilder of GetMatchPropertyNumber
 */
class GetMatchPropertyNumber(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val searchCondition: PropertySearchCondition,
        private val houseKindMapper: HouseKindMapper
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetMatchPropertyNumber")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            if (renewDate != null)
                add(Pair("renew_date", renewDate))
            addAll(searchCondition.toQueryParams(houseKindMapper))
        }

        return build(path, params)
    }
}
