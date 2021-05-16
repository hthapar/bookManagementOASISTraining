import org.http4k.server.SunHttp
import org.http4k.server.asServer

fun main() {
    val port = 8000
    print("Starting Server ... \nPort : $port \nURL: http://localhost:8000" )
    app().asServer(SunHttp(port)).start()
}
