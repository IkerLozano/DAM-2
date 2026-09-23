from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVenatana(QMainWindow):

    def __init__(self):
        super().__init__()

        boton = QPushButton("Pulsa")
        self.setCentralWidget(boton)
        boton.setCheckable(True) #si esta en true, el boton se quedara pulsado, si esta en false se pulsa y se suelta

        boton.clicked.connect(self.booleano) #le digo que cuando presione el boton llame a la funcion saludar
                                                #llamo a la segunda funcion en vez de la primera

    def saludar(self): #esta funcon se ejecuta cuando pulse el boton
        print("Boton pulsado")


    def estadoBoton(self, estado): #el segundo parametro es el que dice si esta pulsado o no
        print("¿Boton pulsado? --> ", estado)

    def booleano(self, estado):
        print(estado)


app = QApplication([])

vetana = miVenatana()
vetana.show()

app.exec()





