package net.kentaku.api.kentaku.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import net.kentaku.api.shared.urlbuilder.toQueryParams
import net.kentaku.inquiry.model.Inquiry

/**
 * UrlBuilder of SendDataInquiryTerminal
 */
class SendDataInquiryTerminal(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val inquiry: Inquiry,
        private val deviceType: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "SendDataInquiryTerminal"))
            addAll(credentialFactory.create().toPairList())
            addAll(inquiry.toQueryParams())
            add(Pair("device_type", deviceType.toString()))
        }
        return build(path, params)
    }
}
