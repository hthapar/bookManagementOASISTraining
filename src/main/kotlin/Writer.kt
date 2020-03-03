interface Writer {
    val name: String
    val brand: String
    val color: String
    val price: Double
}

abstract class AbstractWriter(
    override val name: String,
    override val brand: String,
    override val color: String,
    override val price: Double
) : Writer

class Pencil(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)

class Pen(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)

class SketchPen(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)

class Marker(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)

class WhiteBoardMarker(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)

class PermanentMarker(
    name: String,
    brand: String,
    color: String,
    price: Double
) : AbstractWriter(name, brand, color, price)
