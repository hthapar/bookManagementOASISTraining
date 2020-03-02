interface Writer {
    val name: String
    val brand: String
    val color: String
    fun decorator(): String
    fun write(text: String): String
}

abstract class AbstractWriter(override val name: String, override val brand: String, override val color: String) : Writer {

    override fun decorator(): String = "Write using $name from $brand of $color color. \n********************\n{text}\n********************\n"

    override fun write(text: String): String = decorator().replace("{text}", text)
}

class Pencil(name: String, brand : String, color: String) : AbstractWriter(name,brand,color)

class Pen(name: String, brand : String, color: String): AbstractWriter(name,brand,color)

class SketchPen(name: String, brand : String, color: String) : AbstractWriter(name,brand,color)

class Marker(name: String, brand : String, color: String) : AbstractWriter(name,brand,color)

class WhiteBoardMarker(name: String, brand : String, color: String) : AbstractWriter(name,brand,color)

class PermanentMarker(name: String, brand : String, color: String) : AbstractWriter(name,brand,color)
