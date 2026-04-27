# Ejercicio 2 - Formulario + Base de Datos en la Nube (Supabase)
Esta aplicación esta desarrollada para que permita a los usuarios enviar solicitudes a una base de datos en la nube

## Objetivo
Esta aplicación tiene como objetivo:
- Validar los datos introducidos en el formulario
- Almacenar la información en una base de datos en la nube
- Mostrar un listado de las solicitudes realizadas

## Funcionalidades

### Formulario

La aplicacion tiene un formulario con los siguientes datos:

- Título
- Descripción
- Categoria
- Prioridad(1-5)
- Email

### Validaciones
Se aplican las siguientes reglas:
- Título: entre 5 y 60 caracteres
- Descripción: entre 20 y 500 caracteres
- Categoría: obligatoria
- Prioridad: numero entre el 1 y el 5
- Email: Formato Válido

El botón enviar permanece deshabilitado hasta que todos los campos sean válidos.

### Envío de datos 
- Los datos se envian a Supabase mediante PostgRest
- se muestra un mensaje de confimación de envio correcto
- se gestiona el error de fallo de red o permisos
- se evita el doble envío

### persistencia y listado 
- los datos se almacenan en una tabla llamada "solicitudes"
- Se recuperan y muestran el la app
- El listado se ordena por fecha descendente




