module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where

import Tipos
import Tema

data Playlist = Play Int [ Tema ] deriving (Eq, Show)


nuevaP :: [ Tema ] -> Playlist
nuevaP = Play 0 

actualP :: Playlist -> Tema
actualP (Play index temas) = temas !! index

skipP :: Playlist -> Playlist
skipP (Play index tema) = Play (index+1) tema

backP :: Playlist -> Playlist
backP (Play index tema) = Play (index-1) tema

resetP :: Playlist -> Playlist
resetP (Play index temas) = Play 0 temas


--TESTS
testNuevaP :: [Bool]
testNuevaP = [
    nuevaP [] == Play 0 []
    ]

testActualP :: [Bool]
testActualP = [
    actualP (Play 0 [nuevoT "indie" "Cabildo y Juramento" ]) == nuevoT "indie" "Cabildo y Juramento" 
    ]

testSkipP :: [Bool]
testSkipP = [
    skipP (Play 0 [nuevoT "rock" "Persiana Americana" ]) == Play 1 [nuevoT "rock" "Persiana Americana" ]
    ]

testBackP :: [Bool]
testBackP = [
    backP (Play 1 [nuevoT "rock" "Stairway to Heaven" ]) == Play 0 [nuevoT "rock" "Stairway to Heaven" ]
    ]

testResetP :: [Bool]
testResetP = [
    resetP (Play 1 [nuevoT "pop" "I want it that way" ]) == Play 0 [nuevoT "pop" "I want it that way" ]
    ]
