package db

import BookDetails
import okhttp3.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.CachingFilters

class BooksDB {
    private val booksDB = hashMapOf(
        1 to BookDetails("Immortals of Meluha",1),
        2 to BookDetails("Sutble art of not giving a fuck", 2),
        3 to BookDetails("Art of War", 3),
        4 to BookDetails("Scion of Ishvaku", 4),
        5 to BookDetails("Treasure Island",5)
    )

    fun getAllBooks() = booksDB

    fun getBookNameUsingBookId(bookId : Int) = booksDB.getValue(bookId).name

    fun updateValue(bookId: Int, newBookDetails: BookDetails): BookDetails? {
        booksDB.put(bookId, BookDetails( newBookDetails.name,newBookDetails.id ))
        return booksDB[bookId]
    }

    fun addBook(bookId: Int, bookName: String){
        booksDB[bookId] = BookDetails(name = bookName, id = bookId)
    }

    fun delete(id: Int) {
        booksDB.remove(id)
    }
}
