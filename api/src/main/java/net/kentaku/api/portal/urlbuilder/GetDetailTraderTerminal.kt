package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetDetailTraderTerminal
 */
class GetDetailTraderTerminal(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val traderIds: List<String>,
        private val deviceType: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetDetailTraderTerminal")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            addAll(traderIds.map {
                Pair("trader_id", it)
            })
            add(Pair("device_type", deviceType.toString()))
        }

        return build(path, params)
    }
}
