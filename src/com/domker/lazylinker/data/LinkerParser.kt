package com.domker.lazylinker.data

class LinkerParser {

    /**
     * 解析
     */
    fun parser(): List<LinkerPage> {
        val list = mutableListOf<LinkerPage>()
        list.add(LinkerPage("编译"))
        list.add(LinkerPage("拷贝"))
        list.add(LinkerPage("安装"))
        return list
    }
}