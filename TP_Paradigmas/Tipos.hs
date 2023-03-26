module Tipos where

type Datos = String
type Etiqueta = String
type Nombre = String


insertar :: (Ord a) => a -> [a] -> [a]
insertar x [] = [x]
insertar x (y:ys)
    | x <= y = x:y:ys
    | otherwise = y : insertar x ys


-- TESTS:

test_tipos :: [Bool]
test_tipos = [
    
    insertar "b" ["a", "c"] == ["a", "b", "c"]
    
    ]

