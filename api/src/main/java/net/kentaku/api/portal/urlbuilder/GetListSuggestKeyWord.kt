package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetListSuggestKeyWord
 */
class GetListSuggestKeyWord(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val renewDate: String? = null,
        private val prefectureId: Int? = null,
        private val inputWord: String,
        private val mode: Int = 0
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetListSuggestKeyWord"))
            addAll(credentialFactory.create().toPairList())
            if (renewDate != null) add(Pair("renew_date", renewDate))
            if (prefectureId != null) add(Pair("prefecture_id", prefectureId.toString()))
            add(Pair("input_word", inputWord))
            add(Pair("mode", mode.toString()))
        }

        return build(path, params)
    }
}
