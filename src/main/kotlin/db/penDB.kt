package db

import Marker
import Pen
import Pencil
import PermanentMarker
import SketchPen
import WhiteBoardMarker
import Writer

val pens:Map<Int,Writer> = mapOf (

    1 to Pen("Lexi Pen", "Lexi","blue",10.00),
    2 to Pen("Luxor Pen","Luxor","black",20.00),
    3 to Pen("Parker Pen","Parker","black",40.00),
    4 to Pen("Cello Pen","Cello","red",5.00),

    5 to SketchPen("Reynolds Sketch Pen","Reynolds","black",35.00),
    6 to SketchPen("Faber Sketch Pen","Faber","black",53.00),
    7 to SketchPen("Cello Sketch Pen","Cello","green",23.00),
    8 to SketchPen("Color lib Sketch Pen","Color lib","red",21.00),

    9 to Pencil("Apsara Pencil","Apsara","black",5.00),
    10 to Pencil("DOMS Pencil","DOMS","green",4.00),
    11 to Pencil("Nataraj Pencil","Nataraj","blue",8.00),
    12 to Pencil("Camlin Pencil","Camlin","red",12.00),

    13 to Marker("Reynolds Marker","Reynolds", "red",76.00),
    14 to Marker("Camlin Marker","Camlin", "yellow",67.00),
    15 to Marker("DOMS Marker","DOMS", "green",56.00),
    16 to Marker("Luxor Marker","Luxor", "blue",70.00),

    17 to WhiteBoardMarker("Camlin White Board Marker","Camlin","blue",137.00),
    18 to WhiteBoardMarker("Doms White Board Marker","Doms","green",112.00),
    19 to WhiteBoardMarker("Faber White Board Marker", "Faber","red",166.00),
    20 to WhiteBoardMarker("Reynolds White Board Marker","Reynolds","black",135.00),

    21 to PermanentMarker("Reynolds Permanent Marker","Reynolds","blue",145.00),
    22 to PermanentMarker("Faber Permanent Marker","Faber","blue",125.00),
    23 to PermanentMarker("Doms Permanent Marker","Doms","green",255.00),
    24 to PermanentMarker("Camlin Permanent Marker","Camlin","red",170.00)
)