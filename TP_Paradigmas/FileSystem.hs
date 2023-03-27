module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
    where
import Tipos
import Tema 

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas _) = etiquetas

temasF :: FileSystem -> [Tema]
temasF (FS _ temas) = temas

agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS etiquetas temas)  = FS etiquetas (tema:temas)

filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiquetaFiltrar (FS etiqueta tema) = foldr (\x acc -> if aplicaT etiquetaFiltrar x then x:acc else acc) [] tema



-- TESTS
testNuevoF :: [Bool]
testNuevoF = nuevoF == FS [] []

testEtiquetasF :: [Bool]
testEtiquetasF = etiquetasF (FS ["rock", "clasico", "pop"] [nuevoT ["rock", "clasico"] "Bohemian Rhapsody" , nuevoT ["pop"] "Shape of You" ]) == ["rock", "clasico", "pop"]

testTemasF :: [Bool]
testTemasF = temasF (FS ["rock", "clasico", "pop"] [nuevoT ["rock", "clasico"] "Bohemian Rhapsody", nuevoT ["pop"] "Need to Know" ]) == [nuevoT ["rock", "clasico"] "Bohemian Rhapsody", nuevoT ["pop"] "Need to Know" ]

testAgregarF :: [Bool]
testAgregarF = temasF (agregarF (nuevoT ["rock"] "Stairway to Heaven" ) nuevoF) == [nuevoT ["rock"] "Stairway to Heaven" ]

testFiltrarF :: [Bool]
testFiltrarF = filtrarF "rock" (FS ["rock", "clasico", "pop"] [nuevoT ["rock", "clasico"] "Bohemian Rhapsody", nuevoT ["pop"] "Need to Know" ]) == [nuevoT ["rock", "clasico"] "Bohemian Rhapsody" ])