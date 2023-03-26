module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
where
import Tipos

data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

-- √
nuevoT :: Nombre -> Datos -> Tema
-- toma los argumentos y utiliza la funcion Tem para construir una nueva intancia de Tema
-- con una lista vacia como segunto argumento 
nuevoT = \nombre datos -> Tem nombre [] datos

testNuevoT :: Tema -> Tema
testNuevoT tema = nuevoT "nombre" "datos"


-- √
nombreT :: Tema -> Nombre
-- toma la primera instancia de Tema y devolvemos su valor (como no nos importan los otros campos los marcamos con _ )
nombreT (Tem nombre _ _) = nombre

testnombreT :: Tema -> Nombre
testnombreT tema = nombreT tema

-- √
datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

testdatosT :: Tema -> Datos
testdatosT tema = datosT tema


-- √
etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem _ e _) = e

testetiquetasT :: Tema -> [Etiqueta]
testetiquetasT tema = etiquetasT tema


agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre (insertar etiqueta etiquetas) datos


-- NO PROBAMOS 
aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem _ etiquetas _) = elem etiqueta etiquetas


-- FALTAN TESTS

-- Creamos algunas etiquetas

