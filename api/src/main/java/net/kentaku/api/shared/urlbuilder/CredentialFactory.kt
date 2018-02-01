/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.api.shared.model.Credential

/**
 * Created by tsuyosh on 17/11/19.
 */
interface CredentialFactory {
    fun create(): Credential
}