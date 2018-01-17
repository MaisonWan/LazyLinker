package com.domker.lazylinker.widget

import com.domker.lazylinker.data.LinkerPage
import javax.swing.JPanel

class WidgetCreator {

    /**
     * 创建分类Pane
     */
    fun createTabs(linkerPages: List<LinkerPage>): Map<String, JPanel> {
        val panels = mutableMapOf<String, JPanel>()
        linkerPages.forEach {
            panels[it.pageName] = JPanel()
        }
        return panels
    }
}