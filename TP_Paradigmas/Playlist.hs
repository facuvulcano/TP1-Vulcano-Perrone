module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where

import Tipos
import Tema


data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP :: [ Tema ] -> Playlist
nuevaP temas = Play 0 temas

actualP :: Playlist -> Tema
actualP (Play index temas) = temas !! index

skipP :: Playlist -> Playlist
skipP (Play index tema) = Play (index+1) tema

backP :: Playlist -> Playlist
backP (Play index tema) = Play (index-1) tema

resetP :: Playlist -> Playlist
resetP (Play index temas) = Play 0 temas

--TESTS
{-
testNuevaP :: [Bool]
testNuevaP = [
    nuevaP == Play 0 []
    ]

testActualP :: [Bool]
testActualP = [
    (actualP (Play 0 ["a", "b", "c"]) == "a"),
    (actualP (Play 1 ["a", "b", "c"]) == "b"),
    (actualP (Play 2 ["a", "b", "c"]) == "c")
    ]

testSkipP :: [Bool]
testSkipP = [
    (skipP (Play 0 ["a", "b", "c"]) == Play 1 ["a", "b", "c"]),
    (skipP (Play 1 ["a", "b", "c"]) == Play 2 ["a", "b", "c"]),
    (skipP (Play 2 ["a", "b", "c"]) == Play 3 ["a", "b", "c"])
    ]

testBackP :: [Bool]
testBackP = [
    (backP (Play 0 ["a", "b", "c"]) == Play (-1) ["a", "b", "c"]),
    (backP (Play 1 ["a", "b", "c"]) == Play 0 ["a", "b", "c"]),
    (backP (Play 2 ["a", "b", "c"]) == Play)
    ]


testResetP :: [Bool]
testResetP = [
    (resetP (Play 0 ["a", "b", "c"]) == Play 0 ["a", "b", "c"]),
    (resetP (Play 1 ["a", "b", "c"]) == Play 0 ["a", "b", "c"]),
    (resetP (Play 2 ["a", "b", "c"]) == Play 0 ["a", "b", "c"])
    ]


-}