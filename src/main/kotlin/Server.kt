import db.books
import db.pens

import org.http4k.core.*
import org.http4k.core.Method.*
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes


val server = routes(
    "/book" bind GET to { req: Request ->
        Response(OK)
            .body("${getBookNameUsingBookId(req.query("bookId")?.toInt())}")
    },
    "/pen" bind routes(
        "/detail/" bind GET to { req: Request ->
            req.extractId("penId")?.let { id ->
                getPenDetails(id)?.let { Response(OK).body(it) } ?: Response(Status.NOT_FOUND)
            } ?: Response(Status.BAD_REQUEST).body("ERROR : Please Enter a valid ID!")
        },
        "/filter-by-color/" bind GET to { req: Request ->
            Response(OK).body(getPenNameByColor(req.query("inkColor")))
        },
        "filter-by-brand" bind GET to { req: Request ->
            Response(OK).body(getPenNameByBrand(req.query("brand")))
        }
    ),

    "/pens" bind GET to {
        Response(OK)
            .body(getAllPenNames().toString())
    }
)

private fun getBookNameUsingBookId(bookId: Int?) = books[bookId]

private fun getPenDetails(penId: Int) = pens[penId]?.name

private fun Request.extractId(name: String) = query(name)?.toIntOrNull()

private fun getAllPenNames(): List<String> = pens.values.map { it.name }

private fun getPenNameByColor(color: String?): String =
    pens.values.map { it }.filter { it.color == color }.map { it.name }.toString()

private fun getPenNameByBrand(brandName: String?): String =
    pens.values.map { it }.filter { it.brand == brandName }.map { it.name }.toString()