module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)
nuevaP :: Playlist
nuevaP = Play 0 []
actualP :: Playlist -> Tema
actualP (Play i ts) = ts !! i
skipP :: Playlist -> Playlist
skipP (Play i ts) = Play (i+1) ts
backP :: Playlist -> Playlist
backP (Play i ts) = Play (i-1) ts
resetP :: Playlist -> Playlist
resetP (Play i ts) = Play 0 ts
