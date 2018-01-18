package com.domker.lazylinker.command

import com.domker.lazylinker.data.Linker
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 执行命令
 */
object Command {

    /**
     * 执行一个命令
     */
    fun invoke(linker: Linker) {
        val process = Runtime.getRuntime().exec(linker.content, null, File(linker.runPath))
        val ir = InputStreamReader(process.inputStream)
        val input = BufferedReader(ir)

        var line = input.readLine()
        while (line != null) {
            println(line)
            line = input.readLine()
        }
    }
}