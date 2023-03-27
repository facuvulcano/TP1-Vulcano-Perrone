module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,reiniciarR )
    where
import Tipos ( Etiqueta )
import Tema ( Tema )
import Playlist ( Playlist, nuevaP, actualP )
import FileSystem ( FileSystem )


data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR :: FileSystem -> Reproductor
nuevoR fileSystem = RP fileSystem (nuevaP fileSystem)

archivosR :: Reproductor -> FileSystem
archivosR (RP fileSystem _) = fileSystem

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fileSystem playlist) = listaParaP etiqueta fileSystem playlist

temasR :: FileSystem -> [Tema]
temasR (RP fileSystem playlist) = temasP playlist

playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP fileSystem playlist) etiqueta = RP fileSystem (playP etiqueta playlist)

actualR :: Reproductor ->Tema
actualR (RP fileSystem playlist) = actualP playlist

avanzarR :: Reproductor -> Reproductor
avanzarR (RP fileSystem playlist) = RP fileSystem (avanzarP playlist) 

retrocederR :: Reproductor -> Reproductor
retrocederR (RP fileSystem playlist) = RP fileSystem (retrocederP playlist)

reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP fileSystem playlist) = RP fileSystem (reiniciarP playlist)

--TESTS
{-}
testNuevoR :: [Bool]
testNuevoR = [
    nuevoR (RP [] []) == RP [] (Play 0 [])
    ]

testArchivosR :: [Bool]
testArchivosR = [
    archivosR (RP ["a", "b", "c"] (Play 0 [])) == ["a", "b", "c"]
    ]

testListaParaR :: [Bool]
testListaParaR = [
    listaParaR "a" (RP ["a", "b", "c"] (Play 0 [])) == ["a", "b", "c"]
    ]

testTemasR :: [Bool]
testTemasR = [
    temasR (RP ["a", "b", "c"] (Play 0 [])) == ["a", "b", "c"]
    ]

testPlayR :: [Bool]
testPlayR = [
    playR (RP ["a", "b", "c"] (Play 0 [])) "a" == RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])
    ]

testActualR :: [Bool]
testActualR = [
    actualR (RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])) == "a"
    ]

testAvanzarR :: [Bool]
testAvanzarR = [
    avanzarR (RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])) == RP ["a", "b", "c"] (Play 1 ["a", "b", "c"])
    ]

testRetrocederR :: [Bool]
testRetrocederR = [
    retrocederR (RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])) == RP ["a", "b", "c"] (Play (-1) ["a", "b", "c"])
    ]

testReiniciarR :: [Bool]
testReiniciarR = [
    reiniciarR (RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])) == RP ["a", "b", "c"] (Play 0 ["a", "b", "c"])
    ]


-}