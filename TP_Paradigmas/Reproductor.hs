module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,reiniciarR )
    where
import Tipos
import Tema 
import FileSystem 
import Playlist

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)


nuevoR :: FileSystem -> Reproductor
nuevoR fileSystem = RP fileSystem (nuevaP temas)
  where temas = temasF fileSystem

archivosR :: Reproductor -> FileSystem
archivosR (RP fileSystem _) = fileSystem

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fileSystem playlist) = filtrarF etiqueta fileSystem

temasR :: FileSystem -> [Tema]
-- nuestra funcion temasR toma un FileSystem y devuelve una lista de Temas
temasR = temasF

playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP fileSystem playlist) etiqueta = RP fileSystem (nuevaP (filtrarF etiqueta fileSystem))

actualR :: Reproductor ->Tema
actualR (RP fileSystem playlist) = actualP playlist

avanzarR :: Reproductor -> Reproductor
avanzarR (RP fileSystem playlist) = RP fileSystem (skipP nuevaPlaylist)
  where nuevaPlaylist = nuevaP (temasR fileSystem)

retrocederR :: Reproductor -> Reproductor
retrocederR (RP fileSystem playlist) = RP fileSystem (backP playlist)

reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP fileSystem playlist) = RP fileSystem (resetP playlist)


--TESTS

-- como no tengo constructor de FileSystem, debo declarar variables para poder testear
fileSystem = nuevoF 
playlist = nuevaP [nuevoT "La Bamba" "salsa" ]


testNuevoR :: [Bool]
testNuevoR = [
    nuevoR fileSystem == RP fileSystem playlist
    ]

testArchivosR :: [Bool]
testArchivosR = [
    archivosR (RP fileSystem playlist) == fileSystem
    ]

testListaParaR :: [Bool]
testListaParaR = [
    listaParaR "salsa" (RP fileSystem playlist) == [nuevoT "La Bamba" "salsa" ]
    ]

testTemasR :: [Bool]
testTemasR = [
    temasR fileSystem == [nuevoT "La Bamba" "salsa" ]
    ]

testPlayR :: [Bool]
testPlayR = [
    playR (RP fileSystem playlist) "salsa" == RP fileSystem (nuevaP [nuevoT "La Bamba" "salsa" ])
    ]

testActualR :: [Bool]
testActualR = [
    actualR (RP fileSystem playlist) == nuevoT "La Bamba" "salsa"
    ]

testAvanzarR :: [Bool]
testAvanzarR = [
    avanzarR (RP fileSystem playlist) == RP fileSystem (nuevaP [nuevoT "La Bamba" "salsa" ])
    ]

testRetrocederR :: [Bool]
testRetrocederR = [
    retrocederR (RP fileSystem playlist) == RP fileSystem (nuevaP [nuevoT "La Bamba" "salsa" ])
    ]

testReiniciarR :: [Bool]
testReiniciarR = [
    reiniciarR (RP fileSystem playlist) == RP fileSystem playlist
    ]
