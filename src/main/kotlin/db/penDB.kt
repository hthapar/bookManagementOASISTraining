package db

import Marker
import Pen
import Pencil
import PermanentMarker
import SketchPen
import WhiteBoardMarker
import Writer

val pens:Map<Int,Writer> = mapOf (

    1 to Pen("Lexi Pen", "Lexi","blue"),
    2 to Pen("Luxor Pen","Luxor","black"),
    3 to Pen("Parker Pen","Parker","black"),
    4 to Pen("Cello Pen","Cello","red"),

    5 to SketchPen("Reynolds Sketch Pen","Reynolds","black"),
    6 to SketchPen("Faber Sketch Pen","Faber","black"),
    7 to SketchPen("Cello Sketch Pen","Cello","green"),
    8 to SketchPen("Color lib Sketch Pen","Color lib","red"),

    9 to Pencil("Apsara Pencil","Apsara","black"),
    10 to Pencil("DOMS Pencil","DOMS","green"),
    11 to Pencil("Nataraj Pencil","Nataraj","blue"),
    12 to Pencil("Camlin Pencil","Camlin","red"),

    13 to Marker("Reynolds Marker","Reynolds", "red"),
    14 to Marker("Camlin Marker","Camlin", "yellow"),
    15 to Marker("DOMS Marker","DOMS", "green"),
    16 to Marker("Luxor Marker","Luxor", "blue"),

    17 to WhiteBoardMarker("Camlin White Board Marker","Camlin","blue"),
    18 to WhiteBoardMarker("Doms White Board Marker","Doms","green"),
    19 to WhiteBoardMarker("Faber White Board Marker", "Faber","red"),
    20 to WhiteBoardMarker("Reynolds White Board Marker","Reynolds","black"),

    21 to PermanentMarker("Reynolds Permanent Marker","Reynolds","blue"),
    22 to PermanentMarker("Faber Permanent Marker","Faber","blue"),
    23 to PermanentMarker("Doms Permanent Marker","Doms","green"),
    24 to PermanentMarker("Camlin Permanent Marker","Camlin","red")
)