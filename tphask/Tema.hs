module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
    where

import Tipos


data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre → Datos → Tema
    nuevoT n d = Tem n [] d

nombreT :: Tema → Nombre
    nombreT (Tem n _ _) = n

datosT :: Tema → Datos
    datosT (Tem _ _ d) = d

etiquetasT :: Tema → [ Etiqueta ]
    etiquetasT (Tem _ e _) = e

agregarT :: Tema → Etiqueta → Tema
    agregarT (Tem n e d) et = Tem n (et : e) d

aplicaT :: Tema → (Datos → Datos) → Tema
    aplicaT (Tem n e d) f = Tem n e (f d)

-- Path: modulo3.hs
