import org.http4k.server.SunHttp
import org.http4k.server.asServer

fun main() {
    print(server().asServer(SunHttp(port = 8000)).start())
}