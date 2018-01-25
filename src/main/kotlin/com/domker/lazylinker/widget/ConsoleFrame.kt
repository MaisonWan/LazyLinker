package com.domker.lazylinker.widget

import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.*
import javax.swing.border.EmptyBorder

/**
 * 控制台
 */
class ConsoleFrame(title: String?) : JFrame(title) {
    private val buttonClear = JButton("清空")
    private val buttonClose = JButton("关闭")

    private val textArea = JTextArea()

    private fun initWidget() {
        // 显示panel
        val contentPane = JPanel()
        contentPane.border = EmptyBorder(5, 5, 5, 5)
        contentPane.layout = BorderLayout(0, 0)
        this.contentPane = contentPane

        // 显示标题panel
        val panelTitle = JPanel()
        val layout = panelTitle.layout as FlowLayout
        layout.alignment = FlowLayout.LEFT
        panelTitle.add(JLabel("Console..."))
        contentPane.add(panelTitle, BorderLayout.NORTH)

        val panelConsole = JPanel()
        panelConsole.add(buttonClear)
        buttonClear.addActionListener {
            textArea.text = ""
        }
        panelConsole.add(buttonClose)
        buttonClose.addActionListener {
            isVisible = false
        }
        contentPane.add(panelConsole, BorderLayout.SOUTH)

        val scrollPane = JScrollPane()
        contentPane.add(scrollPane, BorderLayout.CENTER)
        scrollPane.setViewportView(textArea)

        textArea.isDoubleBuffered = true
        this.isVisible = true
    }

    /**
     * 显示一行
     */
    fun append(line: String) {
        textArea.append(line)
        textArea.append("\n")
    }

    init {
        initWidget()
    }
}