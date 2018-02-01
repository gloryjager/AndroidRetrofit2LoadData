/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.model

/**
 * Created by tsuyosh on 17/11/19.
 */
data class Credential(
        val authCode: String,
        val entryDate: String
) {
    fun toPairList(): List<Pair<String, String>> {
        return listOf(
                Pair("auth_code", authCode),
                Pair("entry_date", entryDate)
        )
    }
}