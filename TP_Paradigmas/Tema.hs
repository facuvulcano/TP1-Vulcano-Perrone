module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
where
import Tipos

data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

-- √
nuevoT :: Nombre -> Datos -> Tema
-- toma los argumentos y utiliza la funcion Tem para construir una nueva intancia de Tema
-- con una lista vacia como segunto argumento 
nuevoT = \nombre datos -> Tem nombre [] datos

-- √
nombreT :: Tema -> Nombre
-- toma la primera instancia de Tema y devolvemos su valor (como no nos importan los otros campos los marcamos con _ )
nombreT (Tem nombre _ _) = nombre 

-- √
datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

-- √
etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem _ e _) = e

-- NO FUNCIONA
agregarT :: Tema -> Etiqueta -> Tema
agregarT (Tem n e d) et = Tem n (et : e) d

-- NO PROBAMOS 
aplicaT :: Tema -> (Datos -> Datos) -> Tema
aplicaT (Tem n e d) f = Tem n e (f d)

-- FALTAN TEST