/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.kentaku.converter

import net.kentaku.api.kentaku.model.GetListLineResponse
import net.kentaku.train.model.Line

/**
 * Created by tsuyosh on 17/12/03.
 */

fun GetListLineResponse.toLineList(): List<Line> {
    System.out.println(this)
    return lineData.map { lineDataItem ->
        if (lineDataItem != null) {
            lineDataItem.lines
                    .map { linesItem ->
                        Line(
                                id = linesItem.lineId,
                                prefectureId = linesItem.prefectureId,
                                name = linesItem.lineName,
                                propertyCount = linesItem.propertyCount,
                                lineKind = lineDataItem.lineKind
                        )
                    }
                    .filterNotNull()
        } else {
            emptyList<Line>()
        }
    }.flatten()
}