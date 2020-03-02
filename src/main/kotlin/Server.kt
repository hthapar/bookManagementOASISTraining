import db.books
import db.pens

import org.http4k.core.*
import org.http4k.core.Method.*
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes


val server = routes(

    "/book/" bind GET to { req: Request ->
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
        "/filter-by-brand/" bind GET to { req: Request ->
            Response(OK).body(getPenNameByBrand(req.query("brand")))
        },
        "/qty/" bind GET to { req: Request ->
            Response(OK).body(getQtyByPenName(req.query("qty")))
        },
        "/price/" bind GET to { req: Request ->
            Response(OK).body(getPriceByPenName(req.query("price")))
        }
    ),

    "/pens/" bind GET to {
        Response(OK)
            .body(getAllPenNames().toString())
    }
)


private fun getBookNameUsingBookId(bookId: Int?) = books[bookId]


private fun getPenDetails(penId: Int) = pens[penId]?.name


private fun Request.extractId(name: String) = query(name)?.toIntOrNull()


private fun getAllPenNames(): List<String> = pens.values.map { it.name }


private fun getPenNameByBrand(brandName: String?) =

    convertListToString( pens.filter { entry -> entry.value.brand == brandName }
        .map { entry -> entry.value.name } )


private fun getPenNameByColor(colorRequested: String?) =
    convertListToString( pens.filter { entry -> entry.value.color == colorRequested }
        .map { entry -> entry.value.name } )

private fun getQtyByPenName(penName: String?) =
    convertListToString( pens.filter { entry -> entry.value.name == penName }.map { it.value.availability } )


private fun getPriceByPenName(penName: String?) =
    convertListToString( pens.filter { entry -> entry.value.name == penName }.map { it.value.price } )


private fun convertListToString(list: List<Any>) = list.toString()