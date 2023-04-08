package com.example.ktdemo

import com.drake.brv.item.ItemExpand
import kotlinx.serialization.*
import kotlinx.serialization.encoding.*

/**
 * @description: $
 * @author: xiaozhenlin
 * @date: 2023/3/27
 */
@Serializable
data class MiaoItem(
    @SerialName("content") var content: String = "",
    @SerialName("childList") var childList: List<MiaoChildItem> = mutableListOf(),
    @SerialName("itemExpand") override var itemExpand: Boolean = true,
    @SerialName("itemGroupPosition") override var itemGroupPosition: Int = 0,
) : ItemExpand {
    @kotlinx.serialization.Transient
    override var itemSublist: List<Any?>?
        get() = childList
        set(value) {
            childList = value as List<MiaoChildItem>
        }

}
