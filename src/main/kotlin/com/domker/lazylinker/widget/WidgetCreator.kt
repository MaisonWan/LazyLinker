package com.domker.lazylinker.widget

import com.domker.lazylinker.command.Command
import com.domker.lazylinker.data.Linker
import com.domker.lazylinker.data.LinkerPage
import com.domker.lazylinker.data.TYPE_COMMAND
import java.awt.FlowLayout
import java.awt.Label
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class WidgetCreator {

    /**
     * 创建分类Pane
     */
    fun createTabs(linkerPages: List<LinkerPage>): Map<String, JPanel> {
        val panels = mutableMapOf<String, JPanel>()
        linkerPages.forEach {
            val panel = JPanel()
            panels[it.pageName] = panel
            createPageItems(panel, it)
        }
        return panels
    }

    /**
     * 给定数据的描述，生成Page里面每个Item到JPanel中
     */
    private fun createPageItems(panel: JPanel, linkerPage: LinkerPage) {
        panel.layout = FlowLayout()

        linkerPage.linkers.forEach {
            val item = createItem(it)
            if (item != null) {
                panel.add(item)
            }
        }
    }

    private fun createItem(linker: Linker): JPanel? {
        return when (linker.type) {
            TYPE_COMMAND -> {
                val panel = JPanel(true)
                panel.layout = FlowLayout()
                panel.add(Label(linker.content))

                val button = JButton(linker.name)
                button.addActionListener {
                    val frame = showConsoleFrame()
                    Command.invoke(linker, {
                        frame.append(it)
                    })
                }
                panel.add(button)
                panel
            }
            else -> null
        }
    }

    /**
     * 显示控制台
     */
    private fun showConsoleFrame(): ConsoleFrame {
        val frame = ConsoleFrame("Console")
        frame.size = getFrameSize()
        frame.location = getFrameLocation()
        frame.isVisible = true
        return frame
    }
}