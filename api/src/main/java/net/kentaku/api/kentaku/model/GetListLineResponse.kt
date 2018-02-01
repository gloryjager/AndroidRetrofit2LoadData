package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListLineResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "line_data"
    )
    val lineData: List<LineDataItem?>
) : DktApiResponse {
  @JsonSerializable
  data class LineDataItem(@Json(
      name = "line_kind"
  )
  val lineKind: String, @Json(
      name = "lines"
  )
  val lines: List<LinesItem>) {
    @JsonSerializable
    data class LinesItem(
        @Json(
            name = "prefecture_id"
        )
        val prefectureId: Int,
        @Json(
            name = "line_id"
        )
        val lineId: String,
        @Json(
            name = "line_name"
        )
        val lineName: String,
        @Json(
            name = "property_count"
        )
        val propertyCount: Int
    )
  }
}
