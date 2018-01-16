package com.domker.lazylinker

import com.domker.lazylinker.frame.MainFrame
import javax.swing.JFrame

fun main(args: Array<String>) {
    val frame = MainFrame("Test")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(800, 600)
    frame.setLocation(200, 300)
    frame.pack()
    frame.isVisible = true
}