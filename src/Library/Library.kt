package Library

data class Library(
    private val books: MutableList<Book> = mutableListOf()
) {
    fun removeBook(book: Book) {
        books.remove(book)
    }

    fun removeBook(index: Int) {
        books.removeAt(index)
    }

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBook(title: String) = books.removeIf { it.title == title }

    fun findBook(title: String) = books.find { it.title == title }?.let {
        books.indexOf(it)
    }

    fun listAllBooks(): List<String> = books.map { it.toString() }

    override fun toString(): String {
        val bookList = StringBuilder()
        for (book in books) {
            bookList.append(book).append("\n")
        }
        return bookList.toString()
    }

    fun isEmpty(): Boolean = books.isEmpty()
}