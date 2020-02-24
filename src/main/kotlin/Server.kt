import db.books
import org.http4k.core.*

val server: HttpHandler = { req: Request -> Response(Status.OK)
                            .body("${getBookNameUsingBookId(req.query("id")?.toInt())}") }

private fun getBookNameUsingBookId(bookId: Int?): String? {
    return books[bookId]
}