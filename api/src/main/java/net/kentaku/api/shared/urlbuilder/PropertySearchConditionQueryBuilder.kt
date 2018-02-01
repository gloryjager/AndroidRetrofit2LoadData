/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.property.model.search.PropertySearchCondition

/**
 * Created by tsuyosh on 17/11/01.
 */

fun PropertySearchCondition.toQueryParams(houseKindMapper: HouseKindMapper)
        = range.toQueryParams() + filter.toQueryParams(houseKindMapper) + sort.toQueryParams()
