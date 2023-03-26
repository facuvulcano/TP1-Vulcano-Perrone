module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT )
    where  

import Tipos


data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

-- √
nuevoT :: Nombre -> Datos -> Tema
-- toma los argumentos y utiliza la funcion Tem para construir una nueva intancia de Tema
-- con una lista vacia como segunto argumento 
nuevoT nombre datos = Tem nombre [] datos

-- √
nombreT :: Tema -> Nombre
-- toma la primera instancia de Tema y devolvemos su valor (como no nos importan los otros campos los marcamos con _ )
nombreT (Tem nombre _ _) = nombre 

-- √
datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

-- √
etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem _ etiqueta _) = etiqueta

-- √
agregarT :: Tema -> Etiqueta -> Tema
agregarT (Tem nombre etiqueta datos) etiqueta2 = Tem nombre (etiqueta2:etiqueta) datos

-- √
aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta2 (Tem _ etiqueta _) = elem etiqueta2 etiqueta

testNuevoT :: Bool
testNuevoT = nuevoT "Tema1" "" == Tem "Tema1" [] ""

testNombreT :: Bool
testNombreT = nombreT (Tem "Tema1" [] "") == "Tema1"

testDatosT :: Bool
testDatosT = datosT (Tem "Tema1" [] "Datos") == "Datos"

testEtiquetasT :: Bool
testEtiquetasT = etiquetasT (Tem "Tema1" ["Etiqueta1", "Etiqueta2"] "") == ["Etiqueta1", "Etiqueta2"]

testAgregarT :: Bool
testAgregarT = agregarT (Tem "Tema1" ["Etiqueta1", "Etiqueta2"] "") "Etiqueta3" == Tem "Tema1" ["Etiqueta3", "Etiqueta1", "Etiqueta2"] ""

--testAplicaT :: Bool
--testAplicaT = aplicaT (Tem "Tema1" ["Etiqueta1", "Etiqueta2"] "") "Etiqueta1" == True



