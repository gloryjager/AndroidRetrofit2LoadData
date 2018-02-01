/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal.converter

import net.kentaku.api.portal.model.GetListMergeLineResponse
import net.kentaku.train.model.Line

/**
 * Created by tsuyosh on 17/12/03.
 */
fun GetListMergeLineResponse.toLineList(): List<Line> {
    return lineData.map { lineDataItem ->
        lineDataItem.lines.map { linesItem ->
            Line(
                    id = linesItem.lineId.toString(),
                    prefectureId = linesItem.prefectureId,
                    name = linesItem.lineName,
                    propertyCount = linesItem.propertyCount,
                    lineKind = lineDataItem.lineKind
            )
        }
    }.flatten()
}