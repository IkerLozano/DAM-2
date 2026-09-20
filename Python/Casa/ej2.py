from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias

class miVentana(QMainWindow): #mi Vebtana hereda de QMainWindow

    def __init__(self):
        super().__init__() #super significa la clase de la que heredo, Inicializa la QMainWindow

        self.setWindowTitle("Mi ventana") #self significa "esta ventana que estoy creando ahora mismo"

        boton = QPushButton("Pulsa") #creo el boton
        self.setCentralWidget(boton) #asigno el boton a la pantalla

        self.setFixedSize(200, 200) #tamaño de la ventana


app = QApplication([]) #controla la app grafica

ventana = miVentana() #ventana va a representar la clase de arriba
ventana.show() #la muestro


app.exec() #para q se quede en pantalla








