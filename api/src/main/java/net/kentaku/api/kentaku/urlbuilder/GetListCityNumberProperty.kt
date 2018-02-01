package net.kentaku.api.kentaku.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetListCityNumberProperty
 */
class GetListCityNumberProperty(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val prefectureId: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetListCityNumberProperty")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            add(Pair("prefecture_id", prefectureId.toString()))
            if (renewDate != null)
                add(Pair("renew_date", renewDate))
            add(Pair("add_noproperty", "1")) // 物件0の市区町村も取得
        }
        return build(path, params)
    }
}
