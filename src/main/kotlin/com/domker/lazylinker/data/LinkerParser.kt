package com.domker.lazylinker.data

//import com.google.gson.Gson
import com.google.gson.Gson
import java.io.File
import java.io.FileReader

class LinkerParser {

    /**
     * 解析
     */
    fun parser(): List<LinkerPage> {
        val data = readJsonData()
        val list = parserJson(data) as MutableList //mutableListOf<LinkerPage>()
        list.add(LinkerPage("编译"))
        list.add(LinkerPage("拷贝"))
        list.add(LinkerPage("安装"))
        return list
    }

    private fun parserJson(data: String?): List<LinkerPage> {
        val linkerPages = mutableListOf<LinkerPage>()
        data?.let {
            val gson = Gson()
            val d = gson.fromJson(data, LinkerPage::class.java)
            linkerPages.add(d)
        }
        return linkerPages
    }

    /**
     * 读取配置文件
     */
    private fun readJsonData(): String? {
        var reader: FileReader? = null
        return try {
            reader = FileReader(File("./linker.json"))
            reader.readLines().reduce { acc, s -> acc + s }
        } catch (e: Exception) {
            null
        } finally {
            reader?.close()
        }
    }
}