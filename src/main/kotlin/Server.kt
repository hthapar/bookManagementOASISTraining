import db.books
import db.pens
import org.http4k.core.*
import org.http4k.core.Method.*
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes


val server = routes(
    "book" bind GET to { req: Request ->
        Response(OK)
            .body("${getBookNameUsingBookId(req.query("bookId")?.toInt())}")
    },
    "pen" bind GET to { req: Request ->
        req.extractId("penId")?.let { id ->
            getPenDetails(id)?.let { Response(OK).body(it) } ?: Response(Status.NOT_FOUND)
        } ?: Response(Status.BAD_REQUEST).body("ERROR : Please Enter a valid ID!")

    }
)

private fun getBookNameUsingBookId(bookId: Int?) = books[bookId]

private fun getPenDetails(penId: Int) = pens[penId]?.name

private fun Request.extractId(name: String) = query(name)?.toIntOrNull()

