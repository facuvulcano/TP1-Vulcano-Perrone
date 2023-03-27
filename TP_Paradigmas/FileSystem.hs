module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
    where
import Tema
import Tipos ( Etiqueta )

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
filtrarF etiqueta (FS _ temas) = foldl (\acc tema -> if etiqueta `elem` etiquetasT tema then tema:acc else acc) [] temas



-- TESTS

testNuevoF :: Bool
testNuevoF = nuevoF == FS [] []

testEtiquetasF :: Bool
testEtiquetasF = etiquetasF (FS ["a", "b", "c"] []) == ["a", "b", "c"]

testTemasF :: Bool
testTemasF = temasF (FS [] [nuevoT "Stairway to Heaven" "rock"]) == [nuevoT "Stairway to Heaven" "rock"]

testAgregarF :: Bool
testAgregarF = agregarF (nuevoT "Stairway to Heaven" "rock") (FS [] []) == FS [] [nuevoT "Stairway to Heaven" "rock"]

testFiltrarF :: Bool
testFiltrarF = filtrarF "rock" (FS ["pop", "rock", "indie"] [nuevoT "Stairway to Heaven" "rock"]) == [nuevoT "Stairway to Heaven" "rock"]
