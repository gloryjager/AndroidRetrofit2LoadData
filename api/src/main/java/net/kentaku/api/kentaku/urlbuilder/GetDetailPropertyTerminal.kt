package net.kentaku.api.kentaku.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetDetailPropertyTerminal
 */
class GetDetailPropertyTerminal(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val propertyFullIds: List<String>,
        private val deviceType: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf<Pair<String, String>>().apply {
            add(Pair("function", "GetDetailPropertyTerminal"))
            addAll(credentialFactory.create().toPairList())
            addAll(propertyFullIds.map {
                Pair("property_full_id", it)
            })
            add(Pair("device_type", deviceType.toString()))
        }

        return build(path, params)
    }
}
