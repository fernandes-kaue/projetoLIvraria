package Library

data class Book(val title: String, val author:String, val ISBN: String) {
    override fun toString() = "Title: $title Author: $author ISBN: $ISBN";
}