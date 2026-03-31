Descripcion de la app
    Esta app es un conversor de moneda desarrollado en Android utilizando Java.
    Permite convertir valores entre Dolares (USD) y Euros (EUR).

    El uruario puede ingresar un monto, seleccionar el tipo de conversion mediante RadioButtons y obtener el resultado al presionar el boton "Convertir".

    Se implemenentaron validaciones para evitar errores, como campos vacions o falta de seleccion de tipo de conversion.

Integrantes del grupo:
    Villegas Maria Lourdes- DNI: 46332709   
    Milena Miselli - DNI: 44164036

Implementacion del patron MVVM
    Para el desarrollo de la aplicacion se utilizo el patron de arquitectura MVVM (Model View ViewModel), separado correctamente las responsabilidades

    Model
        Se creo una clase "Conversor" que contiene la logica de negocio.
        Esta clase se encarga de realizar las conversiones entre monedas y almacenar el tipo de cambio

    ViewModel
        Se implemento "ConversorViewModel", que actua como intermediario entre Model y la View.
        Contiene los datos observables mediante LiveData (resultado y valor de conversion).
        Se encarga de procesar la lógica de conversón.
        No depende de la interfaz gráfica.

    View
        La interfaz fue desarrollada en MainActivity junto con su archivo XML.
        Se encarga de mostrar los datos al usuario.
        Observa los cambios del ViewModel mediante LiveData
        Maneja los eventos del usuario (clics, serleccion de opciones, etc.)
        No contiene logica de negocio

Durante el desarrollo de la aplicacion surgieron algunas dificultades, principalmente al implementar la comunicacion entre la interfaz y la logica en MVVM
Uno fue lograr que los resultados de la conversion se mostraran correctamente en los campos de texto.Tuve que usar LiveData en viewModel, que me permitio ver la actividad en la interfaz
Alfinal se logro el resultado buscado, espero le guste nuestro proyecto.

