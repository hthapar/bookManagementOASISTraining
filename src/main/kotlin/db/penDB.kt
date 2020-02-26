package db

import Marker
import Pen
import Pencil
import PermanentMarker
import SketchPen
import WhiteBoardMarker
import Writer

val pens:Map<Int,Writer> = mapOf (

    1 to Pen("Lexi Pen"),
    2 to Pen("Luxor Pen"),
    3 to Pen("Parker Pen"),
    4 to Pen("Cello Pen"),

    5 to SketchPen("Reynolds Sketch Pen"),
    6 to SketchPen("Faber Sketch Pen"),
    7 to SketchPen("Cello Sketch Pen"),
    8 to SketchPen("Color lib Sketch Pen"),

    9 to Pencil("Apsara Pencil"),
    10 to Pencil("DOMS Pencil"),
    11 to Pencil("Nataraj Pencil"),
    12 to Pencil("Camlin Pencil"),

    13 to Marker("Reynolds Marker"),
    14 to Marker("Camlin Marker"),
    15 to Marker("DOMS Marker"),
    16 to Marker("Luxor Marker"),

    17 to WhiteBoardMarker("Camlin White Board Marker"),
    18 to WhiteBoardMarker("Doms White Board Marker"),
    19 to WhiteBoardMarker("Faber White Board Marker"),
    20 to WhiteBoardMarker("Reynolds White Board Marker"),

    21 to PermanentMarker("Reynolds Permanent Marker"),
    22 to PermanentMarker("Faber Permanent Marker"),
    23 to PermanentMarker("Doms Permanent Marker"),
    24 to PermanentMarker("Camlin Permanent Marker")

)