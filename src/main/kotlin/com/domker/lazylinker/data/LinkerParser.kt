package com.domker.lazylinker.data

//import com.google.gson.Gson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader

class LinkerParser {

    /**
     * 解析
     */
    fun parser(): List<LinkerPage> {
        val data = readJsonData()
        println(data)
        return parserJson(data) as MutableList
    }

    private fun parserJson(data: String?): List<LinkerPage> {
        val linkerPages = mutableListOf<LinkerPage>()
        data?.let {
            val gson = Gson()
            val t = object : TypeToken<MutableList<LinkerPage>>() {}.type
            val d: MutableList<LinkerPage> = gson.fromJson(data, t)
            linkerPages.addAll(d)
        }
        return linkerPages
    }

    /**
     * 读取配置文件
     */
    private fun readJsonData(): String? {
        var reader: FileReader? = null
        return try {
            val path = javaClass.getResource("/linker.json").path
            reader = FileReader(File(path))
            reader.readLines().reduce { acc, s -> acc + s }
        } catch (e: Exception) {
            null
        } finally {
            reader?.close()
        }
    }
}