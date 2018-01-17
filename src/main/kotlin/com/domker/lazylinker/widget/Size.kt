package com.domker.lazylinker.widget

import java.awt.Dimension
import java.awt.Point
import java.awt.Toolkit

const val FRAME_WIDTH = 800
const val FRAME_HEIGHT = 600

fun getFrameSize(): Dimension = Dimension(FRAME_WIDTH, FRAME_HEIGHT)

/**
 * 获取窗口的位置
 */
fun getFrameLocation(): Point {
    val point = Point()
    val kit = Toolkit.getDefaultToolkit()
    point.x = (kit.screenSize.width - FRAME_WIDTH) / 2
    point.y = (kit.screenSize.height - FRAME_HEIGHT) / 2
    return point
}