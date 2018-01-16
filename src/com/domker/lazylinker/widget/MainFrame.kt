package com.domker.lazylinker.widget

import com.domker.lazylinker.data.LinkerParser
import java.awt.BorderLayout
import java.awt.Label
import java.awt.Panel
import javax.swing.JFrame
import javax.swing.JTabbedPane

class MainFrame(title: String?) : JFrame(title) {
    private lateinit var tabPanel: JTabbedPane
    private val mLinkerParser = LinkerParser()
    private val mWidgetCreator = WidgetCreator()

    private fun initWidget() {
        tabPanel = JTabbedPane(JTabbedPane.TOP)
        layeredPane.layout = BorderLayout()

        // 标题
        val titlePane = Panel()
        titlePane.add(Label("Select Linker"))
        layeredPane.add(titlePane, BorderLayout.NORTH)

        layeredPane.add(tabPanel, BorderLayout.CENTER)
    }

    private fun initTabs() {
        val linkerPages = mLinkerParser.parser()
        if (linkerPages.isEmpty()) {
            isVisible = false
            return
        }
        val tabs = mWidgetCreator.createTabs(linkerPages)
        linkerPages.forEach {
            tabPanel.add(tabs[it.pageName], it.pageName)
        }
    }

    init {
        initWidget()
        initTabs()
    }
}