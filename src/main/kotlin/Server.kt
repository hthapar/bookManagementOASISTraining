import db.books
import db.pens
import org.http4k.core.*


val server: HttpHandler = { req: Request -> Response(Status.OK)
                            .body("${getBookNameUsingBookId(req.query("bookId")?.toInt())}") }

private fun getBookNameUsingBookId(bookId: Int?)= books[bookId]


val serverPen: HttpHandler = { req: Request -> Response(Status.OK)
                            .body("${getPenDetails(req.query("penId")?.toInt())}") }

private fun getPenDetails(penId: Int?) = pens[penId]
