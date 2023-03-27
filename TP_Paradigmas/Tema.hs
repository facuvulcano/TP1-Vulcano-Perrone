module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT )
    where  

import Tipos

data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre = Tem nombre []

nombreT :: Tema -> Nombre
-- toma la primera instancia de Tema y devolvemos su valor (como no nos importan los otros campos los marcamos con _ )
nombreT (Tem nombre _ _) = nombre 

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem _ etiqueta _) = etiqueta

agregarT :: Tema -> Etiqueta -> Tema
agregarT (Tem nombre etiqueta datos) etiqueta2 = Tem nombre (etiqueta2:etiqueta) datos

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta2 (Tem _ etiqueta _) = elem etiqueta2 etiqueta



-- TESTS:
testNuevoT :: Bool
testNuevoT = nuevoT "Bohemian Rhapsody" "" == Tem "Bohemian Rhapsody" [] ""

testNombreT :: Bool
testNombreT = nombreT (Tem "Bohemian Rhapsody" [] "") == "Bohemian Rhapsody"

testDatosT :: Bool
testDatosT = datosT (Tem "Bohemian Rhapsody" [] "Datos") == "Datos"

testEtiquetasT :: Bool
testEtiquetasT = etiquetasT (Tem "Bohemian Rhapsody" ["rock", "clasico"] "") == ["rock", "clasico"]

testAgregarT :: Bool
testAgregarT = agregarT (Tem "Bohemian Rhapsody" [] "") "rock" == Tem "Bohemian Rhapsody" ["rock"] ""

testAplicaT :: Bool
testAplicaT = aplicaT "rock" (Tem "Tema1" ["rock", "clasico"] "")

