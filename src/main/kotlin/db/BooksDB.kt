package db

import BookDetails
import org.http4k.core.Status.Companion.NOT_FOUND

class BooksDB {
    private val booksDB = hashMapOf<Int?, BookDetails>(
        1 to BookDetails("Immortals of Meluha", 1),
        2 to BookDetails("Sutble art of not giving a fuck", 2),
        3 to BookDetails("Art of War", 3),
        4 to BookDetails("Scion of Ishvaku", 4),
        5 to BookDetails("Treasure Island", 5)
    )

    fun getAllBooks() = booksDB

    fun getBookNameUsingBookId(bookId: Int?): String? {
        return if (checkBookIdExistence(bookId)) booksDB.getValue(bookId).name else NOT_FOUND.toString()
    }

    fun updateValue(bookId: Int?, newBookDetails: BookDetails): Boolean = if (checkBookIdExistence(bookId)) {
        booksDB[bookId] = BookDetails(newBookDetails.name, newBookDetails.id)
        true
    } else
        false

    fun addBook(bookId: Int, bookName: String): String {

        if (checkBookIdExistence(bookId)) {
            return "Book id Already Exist!!"
        } else
            booksDB[bookId] = BookDetails(name = bookName, id = bookId)
        return "Book added"
    }

    fun delete(id: Int): String = if (checkBookIdExistence(id)) {
            booksDB.remove(id)
            "Book Deleted"
        } else
            "Book Not Found"

    private fun checkBookIdExistence(bookId : Int?) = booksDB.contains(bookId)

}
