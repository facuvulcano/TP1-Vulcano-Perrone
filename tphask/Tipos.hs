module Tipos where
    
type Datos = String
type Etiqueta = String
type Nombre = String

insertar :: (Ord a) => a -> [a] -> [a]
insertar x [] = [x]
insertar x (y:ys)
    | x <= y = x:y:ys
    | otherwise = y : insertar x ys 

--insertar :: (Ord a) => a -> [a] -> [a]
--insertar x xs = foldr (\y ys -> if x <= y then x:y:ys else y:ys) [x] xs
