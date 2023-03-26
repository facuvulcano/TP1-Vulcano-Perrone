module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
    where
import Tipos ( Etiqueta )
import Tema ( Tema )

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas _) = etiquetas

temasF :: FileSystem -> [Tema]
temasF (FS _ temas) = temas

agregarF :: Tema -> FileSystem -> FileSystem
agregarF (FS etiquetas temas) tema = FS etiquetas (tema:temas)


filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS _ temas) = foldr (\tema temasFiltrados -> if elem etiqueta (temaEtiquetas tema) then tema : temasFiltrados else temasFiltrados) [] temas
  where
    temaEtiquetas (Tema etiquetas _) = etiquetas

{-filtrarF etiqueta (FS etiquetas temas) = filter (elem etiqueta . temaEtiquetas) temas
    where
        temaEtiquetas (Tema etiquetas _) = etiquetas
-}

-- Prueba de agregarF y temasF
testAgregarF = temasF (agregarF (Tema ["rock"] "Stairway to Heaven" 400) nuevoF) == [Tema ["rock"] "Stairway to Heaven" 400]

-- Prueba de filtrarF con una etiqueta presente en un tema
testFiltrarF1 = filtrarF "rock" (FS [] [Tema ["rock", "clasico"] "Bohemian Rhapsody" 320, Tema ["pop"] "Shape of You" 256]) == [Tema ["rock", "clasico"] "Bohemian Rhapsody" 320]

-- Prueba de filtrarF con una etiqueta que no está presente en ningún tema
testFiltrarF2 = filtrarF "jazz" (FS [] [Tema ["rock", "clasico"] "Bohemian Rhapsody" 320, Tema ["pop"] "Shape of You" 256]) == []

-- Prueba de etiquetasF
testEtiquetasF = etiquetasF (FS [ "rock", "clasico", "pop" ] [Tema ["rock", "clasico"] "Bohemian Rhapsody" 320, Tema ["pop"] "Shape of You" 256]) == [ "rock", "clasico", "pop" ]

