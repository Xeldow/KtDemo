package com.example.ktdemo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @description: $
 * @author: xiaozhenlin
 * @date: 2023/3/27
 */
@Serializable
data class MiaoChildItem(
    @SerialName("content") var content: String = ""
) {

}