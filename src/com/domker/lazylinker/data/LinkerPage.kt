package com.domker.lazylinker.data

/**
 * Linker的分页
 */
class LinkerPage(var pageName: String) {

    private val linkers = mutableListOf<Linker>()

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
}