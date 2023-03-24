module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

--etiquetasTema :: Tema -> [Etiqueta]
--etiquetasTema (Tema etiquetas _ _) = etiquetas

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas temas) = etiquetas

temasF :: FileSystem -> [Tema]
temasF (FS etiquetas temas) = temas

agregarF :: FileSystem -> Tema -> FileSystem
agregarF (FS etiquetas temas) tema = FS (etiquetas ++ etiquetasTema tema) (tema:temas)

filtrarF :: FileSystem -> [Etiqueta] -> [Tema]
filtrarF (FS etiquetas temas) etiquetasFiltrar = filter (cumpleFiltro etiquetasFiltrar) temas

--cumpleFiltro :: [Etiqueta] -> Tema -> Bool
--cumpleFiltro etiquetasFiltrar tema = all (flip elem (etiquetasTema tema)) etiquetasFiltrar
