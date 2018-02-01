package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetCityInfo
 */
class GetCityInfo(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val cityId: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetCityInfo")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            add(Pair("city_id", cityId.toString()))
        }

        return build(path, params)
    }
}
