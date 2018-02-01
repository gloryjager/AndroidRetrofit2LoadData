package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.train.model.LineKind

/**
 * UrlBuilder of GetListMergeLine
 */
class GetListMergeLine(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val prefectureId: Int,
        private val lineKind: LineKind,
        private val addCount: Int = 1,
        private val addNoProperty: Int = 1
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetListMergeLine"))
            addAll(credentialFactory.create().toPairList())
            if (renewDate != null) add(Pair("renew_date", renewDate))
            add(Pair("prefecture_id", prefectureId.toString()))
            val lineKindValue = when (lineKind) {
                LineKind.All -> "all"
                LineKind.Jr -> "jr"
                LineKind.Subway -> "subway"
                LineKind.Private -> "private"
            }
            add(Pair("line_kind", lineKindValue))
            add(Pair("add_count", addCount.toString()))
            add(Pair("add_noproperty", addNoProperty.toString()))
        }
        return build(path, params)
    }
}
