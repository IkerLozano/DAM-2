from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton  #se importan las librerias

class MainWindow(QMainWindow): #nombre de la clase, cuando se empieza una clase se pone :
        def __init__(self): #self indica lo que pasas por argumento **
                super().__init__()

                self.botonPulsado = True # variable con valor true

                self.setWindowTitle("Mi aplicacion") #poner titulo a la ventana

                boton = QPushButton("Pulsa") #creo boton
                boton.setCheckable(True) #segun como este se activa se queda activado o se activa y descativa
                boton.clicked.connect(self.botonActivado)
                boton.setChecked(self.botonPulsado) #asignar al boton el valor de "botonPulsado"

                self.setFixedSize(QSize(400,300)) #tamaño fijo de la ventan

                self.setCentralWidget(boton) #le decimos que el boton ocupe toda la ventana


        def saberEstado(self, chekeada):
                print("¿Boton pulsado? -->", chekeada) # El segundo parametro de una función llamada por "boton.clicked.connect" es el estado del botón, nod ira si esta clikado

        def botonActivado(self, chekeada):
                self.botonPulsado = chekeada
                print(self.botonPulsado)

app = QApplication([])

window = MainWindow() #creo una ventana y le pongo el nombre de la funcuion de arriba

window.show() #Pra que muestre la ventana, pero sin el "app.exec()" se abre y cierra muy rapido

app.exec() #Para que la ventana se quede y no desaparezca
