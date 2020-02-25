import db.books
import db.pens
import org.http4k.core.*


val server1: HttpHandler = { req: Request -> Response(Status.OK)
                            .body("${getBookNameUsingBookId(req.query("bookId")?.toInt())}") }

private fun getBookNameUsingBookId(bookId: Int?)= books[bookId]


val server =
    { req: Request ->
        req.extractId("penId")?.let { id ->
            getPenDetails(id)?.let { Response(Status.OK).body(it) } ?: Response(Status.NOT_FOUND)
        } ?: Response(Status.BAD_REQUEST).body("ERROR : Please Enter a valid ID!")

    }


private fun getPenDetails(penId: Int) = pens[penId]

private fun Request.extractId(name: String) = query(name)?.toIntOrNull()

