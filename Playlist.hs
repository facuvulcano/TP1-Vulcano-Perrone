
-- VER ESTO 

module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where

import Tipos
import Tema

data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP :: [Tema] -> Playlist
nuevaP temas = Play 0 temas

actualP :: Playlist -> Tema
actualP (Play i ts) = ts !! i

skipP :: Playlist -> Playlist
skipP (Play i ts) = Play (i+1) ts

backP :: Playlist -> Playlist
backP (Play i ts) = Play (i-1) ts

resetP :: Playlist -> Playlist
resetP (Play i ts) = Play 0 ts



-- Creamos algunos temas
tema1 = nuevoT "Cancion1" "datos del tema 1"
tema2 = nuevoT "Cancion2" "datos del tema 2"
tema3 = nuevoT "Cancion3" "datos del tema 3"

-- Creamos una lista de temas para la Playlist
listaTemas = [tema1, tema2, tema3]

-- Creamos la Playlist
playlist = nuevaP listaTemas

-- Obtenemos el tema actual
temaActual = actualP playlist
temaSiguiente = actualP (skipP playlist)
temaSiguiente2 = actualP (skipP playlist)
temaAnterior = actualP (backP playlist)
temaInicial = actualP (resetP playlist)



-- Imprimimos el nombre del tema actual


