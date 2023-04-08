package com.example.ktdemo

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * @description: $
 * @author: xiaozhenlin
 * @date: 2023/3/27
 */
object JsonUtil {
    val defaultJsonConfig = Json {
        ignoreUnknownKeys = true // JSON和数据模型字段可以不匹配
        coerceInputValues = true // 如果JSON字段是Null则使用默认值
        //宽松解析
        isLenient = true
    }

    inline fun <reified T> getObject(key: String): T {
        return defaultJsonConfig.decodeFromString<T>(key)
    }

    inline fun <reified T> saveObject(value: T): String {
        return defaultJsonConfig.encodeToString(value)
    }

}