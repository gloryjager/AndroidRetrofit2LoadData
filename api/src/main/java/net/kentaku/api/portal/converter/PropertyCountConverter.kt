/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetMatchPropNumberCommuteResponse
import net.kentaku.api.portal.model.GetMatchPropertyNumberResponse

/**
 * Created by tsuyosh on 17/11/29.
 */
fun GetMatchPropertyNumberResponse.toCount(): Int {
    return this.total
}

fun GetMatchPropNumberCommuteResponse.toCount(): Int {
    return this.total
}