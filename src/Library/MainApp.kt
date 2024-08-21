package Library

import java.awt.*
import javax.swing.*
import kotlin.system.exitProcess

private val library = Library()
private val frame = JFrame("Library App")
private val panel = JPanel()
private val gbc = GridBagConstraints()
private val btnSize = Dimension(200, 40)
private val txtArea = JTextArea().apply { isEditable = false }
private val scrPanel = JScrollPane(txtArea).apply { isVisible = false }

fun main(args: Array<String>) {

    with(frame) {
        size = Dimension(600, 400)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        layout = BorderLayout()
    }

    with(panel) {
        layout = GridBagLayout()
    }

    with(gbc) {
        insets = Insets(10, 10, 10, 10)
        gridx = 0
        gridy = GridBagConstraints.RELATIVE
        anchor = GridBagConstraints.CENTER
    }

    val addBook = JButton("Add a Book").apply { preferredSize = btnSize }
    val removeBook = JButton("Remove a Book").apply { preferredSize = btnSize }
    val findBook = JButton("Find a Book").apply { preferredSize = btnSize }
    val listAllBooks = JButton("List All Books").apply { preferredSize = btnSize }
    val exit = JButton("Exit").apply { preferredSize = btnSize }

    panel.apply {
        add(addBook, gbc)
        add(removeBook, gbc)
        add(findBook, gbc)
        add(listAllBooks, gbc)
        add(exit, gbc)
    }

    frame.add(panel, BorderLayout.CENTER)
    frame.add(scrPanel, BorderLayout.SOUTH)

    addBook.onClick { item1() }
    removeBook.onClick { item2() }
    findBook.onClick { item3() }
    listAllBooks.onClick { item4() }
    exit.onClick { item5() }

    frame.isVisible = true

}

private fun item1() {
    library.addBook(
        Book(
            JOptionPane.showInputDialog("What's the name of the book you want to add?"),
            JOptionPane.showInputDialog("Who's the author of the said book?"),
            JOptionPane.showInputDialog("What's the ISBN of the said book?"),
        )
    )
    JOptionPane.showMessageDialog(null, "Book added successfully!")
}

private fun item2() {
    val isRemoved = library.removeBook(
        JOptionPane.showInputDialog("What's the name of the book you want to remove?")
    )
    if (!isRemoved) JOptionPane.showMessageDialog(null, "Book not found!")
}

private fun item3() {
    val index = library.findBook(JOptionPane.showInputDialog("What's the name of the book you want to find?"))
    index?.let { JOptionPane.showMessageDialog(null, "Book found at index: ${index + 1}") }
        ?: JOptionPane.showMessageDialog(null, "Book not found!")
}

private fun item4() {
    if (library.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No books available.")
    } else {
        JOptionPane.showMessageDialog(null, library.toString(), "List of Books", JOptionPane.INFORMATION_MESSAGE)
    }
}

private fun item5() {
    JOptionPane.showMessageDialog(null, "Exiting the application...")
    exitProcess(0)
}

private fun JButton.onClick(callback: () -> Unit) {
    this.addActionListener {
        scrPanel.isVisible = true
        callback()
    }
}