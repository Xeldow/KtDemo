package com.example.ktdemo

import com.tencent.mmkv.MMKV
import kotlinx.serialization.SerialName

/**
 * @description: $
 * @author: xiaozhenlin
 * @date: 2023/3/27
 */
@kotlinx.serialization.Serializable
class SaveData private constructor() {
    companion object {
        private var instance: SaveData? = null

        fun get(id: String): SaveData {
            val json = MMKV.defaultMMKV()?.decodeString("myId") ?: "{}"
            instance = JsonUtil.getObject(json)
            return instance!!
        }

        fun save() {
            val json = JsonUtil.saveObject(instance)
            MMKV.defaultMMKV()?.encode("myId", json)
        }

    }

    @SerialName("miao_id")
    var id: String = ""
        private set

    @SerialName("miao_list")
    var miaoList: MutableList<MiaoItem> = mutableListOf()

}
