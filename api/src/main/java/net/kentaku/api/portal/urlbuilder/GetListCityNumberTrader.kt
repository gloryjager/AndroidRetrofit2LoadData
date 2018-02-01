package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetListCityNumberTrader
 */
class GetListCityNumberTrader(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val prefectureId: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetListCityNumberTrader")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            add(Pair("prefecture_id", prefectureId.toString()))
            if (renewDate != null)
                add(Pair("renew_date", renewDate))
        }
        return build(path, params)
    }
}
