package db

import Pen
import com.fasterxml.jackson.databind.JsonNode
import org.http4k.format.Jackson

val json = Jackson

val booksJson: JsonNode = json.obj(
    "1" to json.string("Immortals of Meluha"),
    "2" to json.string("Sutble art of not giving a fuck"),
    "3" to json.string("Art of War"),
    "4" to json.string("Scion of Ishvaku"),
    "5" to json.string("Treasure Island")
)