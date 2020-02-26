interface Writer {
    val name: String
    fun decorator(): String
    fun write(text: String): String
}

abstract class AbstractWriter(override val name: String) : Writer {

    override fun decorator(): String = "Write using $name\n********************\n{text}\n********************"

    override fun write(text: String): String = decorator().replace("{text}", text)

    fun print(text: String) = println(write(text))
}

class Pen(name: String): AbstractWriter(name)

class SketchPen(name: String) : AbstractWriter(name)

class Pencil(name: String) : AbstractWriter(name)

class Marker(name: String) : AbstractWriter(name)

class WhiteBoardMarker(name: String) : AbstractWriter(name)

class PermanentMarker(name: String) : AbstractWriter(name)
