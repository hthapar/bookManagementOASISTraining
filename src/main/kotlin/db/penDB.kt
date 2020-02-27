package db

import Marker
import Pen
import Pencil
import PermanentMarker
import SketchPen
import WhiteBoardMarker
import Writer

val pens:Map<Int,Writer> = mapOf (

    1 to Pen("Lexi Pen", "Lexi","Blue"),
    2 to Pen("Luxor Pen","Luxor","Blue"),
    3 to Pen("Parker Pen","Parker","Blue"),
    4 to Pen("Cello Pen","Cello","Blue"),

    5 to SketchPen("Reynolds Sketch Pen","Reynolds","Blue"),
    6 to SketchPen("Faber Sketch Pen","Reynolds","Blue"),
    7 to SketchPen("Cello Sketch Pen","Reynolds","Blue"),
    8 to SketchPen("Color lib Sketch Pen","Reynolds","Blue"),

    9 to Pencil("Apsara Pencil","Reynolds","Blue"),
    10 to Pencil("DOMS Pencil","Reynolds","Blue"),
    11 to Pencil("Nataraj Pencil","Reynolds","Blue"),
    12 to Pencil("Camlin Pencil","Reynolds","Blue"),

    13 to Marker("Reynolds Marker","Reynolds","Blue"),
    14 to Marker("Camlin Marker","Reynolds","Blue"),
    15 to Marker("DOMS Marker","Reynolds","Blue"),
    16 to Marker("Luxor Marker","Reynolds","Blue"),

    17 to WhiteBoardMarker("Camlin White Board Marker","Reynolds","Blue"),
    18 to WhiteBoardMarker("Doms White Board Marker","Reynolds","Blue"),
    19 to WhiteBoardMarker("Faber White Board Marker","Reynolds","Blue"),
    20 to WhiteBoardMarker("Reynolds White Board Marker","Reynolds","Blue"),

    21 to PermanentMarker("Reynolds Permanent Marker","Reynolds","Blue"),
    22 to PermanentMarker("Faber Permanent Marker","Reynolds","Blue"),
    23 to PermanentMarker("Doms Permanent Marker","Reynolds","Blue"),
    24 to PermanentMarker("Camlin Permanent Marker","Reynolds","Blue")

)