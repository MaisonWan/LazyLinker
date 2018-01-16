package com.domker.lazylinker

import com.domker.lazylinker.widget.MainFrame
import com.domker.lazylinker.widget.getFrameLocation
import com.domker.lazylinker.widget.getFrameSize
import javax.swing.JFrame

fun main(args: Array<String>) {
    val frame = MainFrame("Lazy Linker")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.size = getFrameSize()
    frame.location = getFrameLocation()
    frame.isVisible = true
}