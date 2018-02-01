package net.kentaku.api.portal.urlbuilder

import net.kentaku.api.shared.urlbuilder.CredentialFactory
import net.kentaku.api.shared.urlbuilder.DktUrlBuilder

/**
 * UrlBuilder of GetDetailMergeProperty
 */
class GetDetailMergeProperty(
        private val path: String,
        private val credentialFactory: CredentialFactory,
        private val propertyFullIds: List<String>,
        private val deviceType: Int,
        private val randomFlag: Int
) : DktUrlBuilder {
    override fun build(): String {
        val params = mutableListOf(
                Pair("function", "GetDetailMergeProperty")
        ).apply {
            addAll(credentialFactory.create().toPairList())
            addAll(propertyFullIds.map {
                Pair("property_full_id", it)
            })
            add(Pair("device_type", deviceType.toString()))
            add(Pair("random_flag", randomFlag.toString()))
        }

        return build(path, params)
    }
}
