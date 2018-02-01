/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.exception

/**
 * Created by tsuyosh on 17/11/02.
 */
class ConversionException(
        message: String?,
        throwable: Throwable?
): RuntimeException(message, throwable) {
    constructor(message: String): this(message, null)
    constructor(throwable: Throwable): this(null, throwable)
}