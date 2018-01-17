package com.domker.lazylinker.data

import com.google.gson.annotations.SerializedName

/**
 * Linker的分页
 */
class LinkerPage {
    val linkers = mutableListOf<Linker>()

    @SerializedName("page_name")
    lateinit var pageName: String

    /**
     * Linker的数量
     */
    fun getLinkerCount() = linkers.count()

    /**
     * 获取Linker的列表
     */
    fun getLinkerList() = linkers

    internal fun addLinker(linker: Linker) {
        linkers.add(linker)
    }

    /**
     * 设置分页的名字
     */
    internal fun setPageName(name: String) {
        pageName = name
    }

    internal fun getPageName() = pageName
}