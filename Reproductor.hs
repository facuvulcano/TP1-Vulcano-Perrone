-- VER ESTO

module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,
reiniciarR )
where
import Tipos
import Tema
import Playlist
import FileSystem

nuevoR :: FileSystem -> Reproductor
nuevoR fs = Reproductor (listaParaR fs) (temasR fs) (playR fs) (actualR fs) (avanzarR fs) (retrocederR fs) (reiniciarR fs)

archivosR :: Reproductor -> [String]
archivosR (Reproductor _ _ _ _ _ _ _) = []

listaParaR :: FileSystem →[String]
listaParaR (Archivo
 _ _ ) 
= []
listaParaR (Directorio _ _ _ ) = []

temasR :: FileSystem →[Tema]
temasR (Archivo _ _ ) = []
temasR (Directorio _ _ _ ) = []

playR :: FileSystem →[Tema]
playR (Archivo _ _ ) = []

playR (Directorio _ _ _ ) = []

actualR :: FileSystem →Tema
actualR (Archivo _ _ ) = Tema "" 0
actualR (Directorio _ _ _ ) = Tema "" 0

avanzarR :: FileSystem →FileSystem
avanzarR (Archivo _ _ ) = Archivo "" ""
avanzarR (Directorio _ _ _ ) = Directorio "" [] []
    
retrocederR :: FileSystem →FileSystem
retrocederR (Archivo _ _ ) = Archivo "" ""
retrocederR (Directorio _ _ _ ) = Directorio "" [] []

reiniciarR :: FileSystem →FileSystem
reiniciarR (Archivo _ _ ) = Archivo "" ""
reiniciarR (Directorio _ _ _ ) = Directorio "" [] []

-- Path: Tema.hs
