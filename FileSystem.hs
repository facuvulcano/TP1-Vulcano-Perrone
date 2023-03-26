module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF)
where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

--etiquetasTema :: Tema -> [Etiqueta]
--etiquetasTema (Tema etiquetas _ _) = etiquetas

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas temas) = eliminaDuplicados (concatMap etiquetasT temas)
  where eliminaDuplicados = foldr (\x xs -> if x `elem` xs then xs else x : xs) []


temasF :: FileSystem -> [Tema]
temasF (FS etiquetas temas) = temas

--agregarF :: FileSystem -> Tema -> FileSystem
--agregarF (FS etiquetas temas) tema = FS (etiquetas ++ etiquetasTema tema) (tema:temas)

--filtrarF :: FileSystem -> [Etiqueta] -> [Tema]
--filtrarF (FS etiquetas temas) etiquetasFiltrar = filter (cumpleFiltro etiquetasFiltrar) temas

--cumpleFiltro :: [Etiqueta] -> Tema -> Bool
--cumpleFiltro etiquetasFiltrar tema = all (flip elem (etiquetasTema tema)) etiquetasFiltrar


tema1 = Tem "Tema 1" [Etq "Etiqueta 1", Etq "Etiqueta 2"] "Datos del tema 1"
tema2 = Tem "Tema 2" [Etq "Etiqueta 2", Etq "Etiqueta 3"] "Datos del tema 2"
tema3 = Tem "Tema 3" [Etq "Etiqueta 1", Etq "Etiqueta 3"] "Datos del tema 3"
fs = FS [Etq "Etiqueta 1", Etq "Etiqueta 2", Etq "Etiqueta 3"] [tema1, tema2, tema3]
