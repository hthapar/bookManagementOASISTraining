import db.BooksDB
import db.pens
import org.http4k.core.Method.*
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes

val dao = BooksDB()

fun app() = routes(

//query method se id extract
    "/" bind GET to {Response(OK).body("Hello!")},

    "/books" bind GET to {
        Response(OK).body(dao.getAllBooks().toString())
    },

    "/book" bind GET to { req: Request ->
        Response(OK)
            .body("${req.query("bookId")?.let { dao.getBookNameUsingBookId(it.toInt()) }}")
    },

//path params se id extract

    "/book" bind routes(

        "/list" bind GET to { Response(OK).body(dao.getAllBooks().toString()) },

        "/id/{id}" bind GET to { req: Request ->

            val bookId = getId(req)

            Response(OK).body("${ dao.getBookNameUsingBookId(bookId) }")
        },

        "/update/{id}" bind PATCH to { req: Request ->

            val bookId= getId(req)

            Response(OK).body("${dao.updateValue(bookId, BookDetails(req.bodyString(),bookId))}")

        },

        "/delete/{id}" bind DELETE to { req: Request ->
            Response(OK).body("${getId(req)?.let { dao.delete(it) }}")
        },

        "/add/{id}" bind POST to { req: Request ->
            Response(OK).body("${getId(req)?.let { dao.addBook(it, req.bodyString())}}")
        }

    ),

    "/pen" bind routes(
        "/detail/" bind GET to { req: Request ->
            req.extractId("penId")?.let { id ->
                getPenDetails(id)?.let { Response(OK).body(it) } ?: Response(NOT_FOUND)
            } ?: Response(BAD_REQUEST).body("ERROR : Please Enter a valid ID!")
        },

        "/filter" bind GET to { req: Request ->

            when (val queryName = req.uri.query.substringBefore("=")) {

                "inkColor" -> req.query(queryName)?.let { inkColor: String ->
                    getPenNameByColor(inkColor).let { Response(OK).body(it) } ?: Response(NOT_FOUND)
                } ?: Response(BAD_REQUEST).body("ERROR : Please Enter a valid color!")

                "brand" -> req.query(queryName)?.let { brand: String ->
                    getPenNameByBrand(brand).let { Response(OK).body(it) } ?: Response(NOT_FOUND)
                } ?: Response(BAD_REQUEST).body("ERROR : Please Enter a valid brand name!")

                else -> Response(NOT_FOUND).body("ERROR : URL NOT FOUND!")
            }
        },

        "/price/" bind GET to { req: Request ->
            Response(OK).body(getPriceByPenName(req.query("penName")))
        },
        "/cart-total/" bind GET to { req: Request ->
            Response(OK).body(
                getTotal(req.query("penId"), req.query("qty")).toString()
            )
        }
    ),

    "/pens/" bind GET to {
        Response(OK)
            .body(getAllPenNames().toString())
    }
)

//pens
private fun getPenDetails(penId: Int) = pens[penId]?.name

private fun Request.extractId(name: String) = query(name)?.toIntOrNull()

private fun getId(req: Request): Int? = req.path("id")?.toIntOrNull()

private fun getAllPenNames(): List<String> = pens.values.map { it.name }


private fun getPenNameByBrand(brandName: String?):String =

    convertListToString(pens.filter { entry -> entry.value.brand == brandName }
        .map { entry -> entry.value.name })


private fun getPenNameByColor(colorRequested: String?):String =
    convertListToString(pens.filter { entry -> entry.value.color == colorRequested }
        .map { entry -> entry.value.name })


private fun getPriceByPenName(penName: String?) =
    convertListToString(pens.filter { entry -> entry.value.name == penName }.map { it.value.price })


private fun getTotal(penId: String?, quantity: String?): Double? {

    return penId?.let { getPriceByPenId(penId)?.times(quantity!!.toDouble()) }
}


private fun getPriceByPenId(penId: String) = pens[penId.toInt()]?.price


private fun convertListToString(list: List<Any>) = list.toString()
