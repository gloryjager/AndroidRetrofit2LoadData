package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetListStationNumberTrader
 */
class GetListStationNumberTrader(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val prefectureId: Int,
        private val lineId: String
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetListStationNumberTrader"))
            addAll(credentialFactory.create().toPairList())
            if (renewDate != null) add(Pair("renew_date", renewDate))
            add(Pair("prefecture_id", prefectureId.toString()))
            add(Pair("line_id", lineId))
        }
        return build(path, params)
    }
}
