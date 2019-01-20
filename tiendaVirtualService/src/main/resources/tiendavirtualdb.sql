-----------------------------------------------------------
-- Base de datos: `tiendavirtualdb`
-----------------------------------------------------------

-- --------------------------------------------------------
-----------------------------------------------------------
-- Estructura de tabla para la tabla `factura`
-----------------------------------------------------------
CREATE TABLE `factura`(
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--------------------------------------------------------------
-- Volcado de datos para la tabla `producto`
--------------------------------------------------------------

INSERT INTO `producto` (`id`, `fecha`, `total`) VALUES
(1, null, 25000),
(2, null, 35000);
-----------------------------------------------------------
-- Estructura de tabla para la tabla `factura`
-----------------------------------------------------------
CREATE TABLE `detalle_factura`(
  `id` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-----------------------------------------------------------
-- Estructura de tabla para la tabla `categoria`
-----------------------------------------------------------

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

---------------------------------------------------------------
-- Volcado de datos para la tabla `categoria`
---------------------------------------------------------------

INSERT INTO `categoria` (`id`, `nombre`, `estado`, `descripcion`) VALUES
(1, 'camisa', 1, 'ngociable con desceunto'),
(2, 'pantalon', 1, 'negociable');

-- --------------------------------------------------------


-----------------------------------------------------------
-- Estructura de tabla para la tabla `usuario`
-----------------------------------------------------------

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int COLLATE utf8_spanish_ci NOT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

---------------------------------------------------------------
-- Volcado de datos para la tabla `categoria`
---------------------------------------------------------------

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES
(1, 'Alex', 'Muñoz', 'alexuriel.777@gmail.com', '3148007248',),
(1, 'Juan', 'Sanchez', 'juansanchez@gmail.com', '3129889909',);

-- --------------------------------------------------------
--------------------------------------------------------------
-- Estructura de tabla para la tabla `producto`
--------------------------------------------------------------

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `precio` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `foto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--------------------------------------------------------------
-- Volcado de datos para la tabla `producto`
--------------------------------------------------------------

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `estado`, `precio`, `cantidad`, `foto`, `id_categoria`) VALUES
(1, 'Ropa para hombre', 'Baico para hombre', 1, 35000, 32, 'otro', 1),
(2, 'Ropa para hombre', 'basico par hombre', 1, 32000, 43, 'otro', 2);

---------------------------------------------------------------
-- Ã�ndices para tablas volcadas
---------------------------------------------------------------

---------------------------------------------------------------
-- Indices de la tabla `factura`
----------------------------------------------------------------
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`);
  
  -- Indices de la tabla `factura`
----------------------------------------------------------------
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`id`);
  
  ----------------------------------------------------------------
-- Indices de la tabla `producto`
----------------------------------------------------------------
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_catetoria` (`id_catetoria`);
---------------------------------------------------------------
-- Indices de la tabla `categoria`
----------------------------------------------------------------
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);



------------------------------------------------------------
-- AUTO_INCREMENT de las tablas volcadas
--------------------------------------------------------------

  -----------------------------------------------------------
-- AUTO_INCREMENT de la tabla `factura`
-----------------------------------------------------------
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

    -----------------------------------------------------------
-- AUTO_INCREMENT de la tabla `detalle_factura`
-----------------------------------------------------------
ALTER TABLE `detalle_factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


-----------------------------------------------------------
-- AUTO_INCREMENT de la tabla `categoria`
-----------------------------------------------------------
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

  
  alter table detalle_factura
add CONSTRAINT FOREIGN KEY
    fk_detalle_factura (id_factura)
    REFERENCES factura (id);
    
    
   alter table detalle_factura
add CONSTRAINT FOREIGN KEY
    fk_detalle_producto (id_producto)
    REFERENCES producto (id);
    
    
  
alter table producto
add CONSTRAINT FOREIGN KEY
    fk_producto_categoria (id_categoria)
    REFERENCES categoria (id);
