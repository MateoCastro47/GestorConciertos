Este proyecto es una aplicación de consola en Java que permite la gestión de entradas para un concierto. Los usuarios pueden reservar entradas, visualizar su reserva y listar las entradas vendidas y disponibles.

--Estructura del Proyecto--
El código está organizado en las siguientes clases:

1. Main.java: Contiene el menú principal e interacción con el usuario.
2. GestorEntradas.java: Administra las entradas y gestiona la compra.
3. Entrada.java (Clase abstracta): Modelo base para todas las entradas.
4. EntradaGrada.java: Representa una entrada en la grada (con fila y asiento).
5. EntradaPista.java: Representa una entrada en la pista (opcionalmente con acceso backstage).
6. Asistente.java: Modelo que almacena la información del comprador.
