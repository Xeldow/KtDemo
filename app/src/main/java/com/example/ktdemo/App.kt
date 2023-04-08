package com.example.ktdemo

import android.app.Application
import com.drake.brv.utils.BRV
import com.tencent.mmkv.MMKV

/**
 * @description:
 *
 * @author: xiaozhenlin
 * @date: 2023/4/8
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        BRV.modelId = BR.item
    }
}