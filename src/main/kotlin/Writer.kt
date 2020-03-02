interface Writer {
    val name: String
    val brand: String
    val color: String
    val availability: Int
    val price: Double
}

abstract class AbstractWriter(
    override val name: String,
    override val brand: String,
    override val color: String,
    override val availability: Int,
    override val price: Double
) : Writer

class Pencil(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)

class Pen(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)

class SketchPen(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)

class Marker(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)

class WhiteBoardMarker(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)

class PermanentMarker(
    name: String,
    brand: String,
    color: String,
    availability: Int,
    price: Double
) : AbstractWriter(name, brand, color, availability, price)
