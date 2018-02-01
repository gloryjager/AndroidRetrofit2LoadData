package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetListStationNumberMergeProperty
 */
class GetListStationNumberMergeProperty(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val lineId: String,
        private val addCount: Int = 1,
        private val addNoProperty: Int = 1
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetListStationNumberMergeProperty"))
            addAll(credentialFactory.create().toPairList())
            if (renewDate != null) add(Pair("renew_date", renewDate))
            add(Pair("line_id", lineId))
            add(Pair("add_count", addCount.toString()))
            add(Pair("add_noproperty", addNoProperty.toString()))
        }
        return build(path, params)
    }
}
