package com.example.ktdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.tencent.mmkv.MMKV

class MainActivity : AppCompatActivity() {
    private lateinit var mTrueList: MutableList<MiaoItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        mTrueList = SaveData.get("id").miaoList
        val bean = MiaoItem("$title:${mTrueList.size}", itemGroupPosition = mTrueList.size)
        bean.childList = mutableListOf(MiaoChildItem("child${mTrueList.size}"))
        mTrueList.add(bean)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.linear().setup {
            addType<MiaoItem>(R.layout.item_miao)
            addType<MiaoChildItem>(R.layout.item_miao_child)
        }.models = mTrueList
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        SaveData.save()
    }
}