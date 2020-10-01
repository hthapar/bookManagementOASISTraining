import db.booksJson
import db.pens
import org.http4k.core.Method.GET
import org.http4k.core.Method.PUT
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes

fun server() = routes(

    "/book" bind GET to { req: Request ->
        Response(OK)
            .body("${req.query("bookId")?.let { getBookNameUsingBookId(it) }}")
    },

    "/book/{id}" bind PUT to { req: Request ->

        val bookId: String? = req.path("id").toString()
        val newBookName : String? = req.bodyString()

        updateValue(bookId, newBookName)?.let { Response(OK).body(it) }
            ?: Response(BAD_REQUEST).body("ERROR : Please Enter a valid ID!")
    },

    "/books" bind GET to {
        Response(OK).body(getAllBooks().toPrettyString())
    },

    "/pen" bind routes(
        "/detail/" bind GET to { req: Request ->
            req.extractId("penId")?.let { id ->
                getPenDetails(id)?.let { Response(OK).body(it) } ?: Response(Status.NOT_FOUND)
            } ?: Response(BAD_REQUEST).body("ERROR : Please Enter a valid ID!")
        },
        "/filter-by-color/" bind GET to { req: Request ->
            Response(OK).body(getPenNameByColor(req.query("inkColor")))
        },
        "/filter-by-brand/" bind GET to { req: Request ->
            Response(OK).body(getPenNameByBrand(req.query("brand")))
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

fun updateValue(pathId: String?, newBookName: String?): String? {
    return "${booksJson[pathId].toPrettyString()} will be updated to \"$newBookName\""
}

//books
private fun getBookNameUsingBookId(bookId: String) = booksJson.get(bookId)

fun getAllBooks() = booksJson

//pens
private fun getPenDetails(penId: Int) = pens[penId]?.name


private fun Request.extractId(name: String) = query(name)?.toIntOrNull()


private fun getAllPenNames(): List<String> = pens.values.map { it.name }


private fun getPenNameByBrand(brandName: String?) =

    convertListToString(pens.filter { entry -> entry.value.brand == brandName }
        .map { entry -> entry.value.name })


private fun getPenNameByColor(colorRequested: String?) =
    convertListToString(pens.filter { entry -> entry.value.color == colorRequested }
        .map { entry -> entry.value.name })


private fun getPriceByPenName(penName: String?) =
    convertListToString(pens.filter { entry -> entry.value.name == penName }.map { it.value.price })


private fun getTotal(penId: String?, quantity: String?): Double? {

    return penId?.let { getPriceByPenId(penId)?.times(quantity!!.toDouble()) }
}


private fun getPriceByPenId(penId: String) = pens[penId.toInt()]?.price


private fun convertListToString(list: List<Any>) = list.toString()
