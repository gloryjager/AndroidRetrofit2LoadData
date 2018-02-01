/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

/**
 * Created by tsuyosh on 17/12/27.
 */
object DispNameFormatter {
    fun format(name: String): String {
        return name.replace("大東建託リーシング株式会社", "").trim()
    }
}