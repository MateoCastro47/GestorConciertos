Este proyecto es una aplicación de consola en Java que permite la gestión de entradas para un concierto. Los usuarios pueden reservar entradas, visualizar su reserva y listar las entradas vendidas y disponibles.

--Características principales--

Reservar entradas (Grada o Pista, con opción de backstage).
Buscar y mostrar información de una entrada por email.
Listar todas las entradas vendidas.
Mostrar entradas disponibles para la venta.
Validaciones para evitar asientos duplicados y emails repetidos.

--Estructura del Proyecto--
El código está organizado en las siguientes clases:

1. Main.java: Contiene el menú principal e interacción con el usuario.
2. GestorEntradas.java: Administra las entradas y gestiona la compra.
3. Entrada.java (Clase abstracta): Modelo base para todas las entradas.
    3.1 EntradaGrada.java: Representa una entrada en la grada (con fila y asiento).
    3.2 EntradaPista.java: Representa una entrada en la pista (opcionalmente con acceso backstage).
4. Asistente.java: Modelo que almacena la información del comprador.
