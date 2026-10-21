from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    cont = 0

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton = QPushButton("Pulsa")
        self.setCentralWidget(boton)

        boton.pressed.connect(self.primero) #pulsar soin soltar
        boton.released.connect(self.segundo) #saltar
        boton.clicked.connect(self.tercero) #pulsar y soltar

        boton.clicked.connect(self.contar)


    def primero(self):
        print("Boton Pulsado")

    def segundo(self):
        print("Boton soltado")

    def tercero(self):
        print("Boton pulsado y soltado")


    def contar(self):
        self.cont+=1
        print("Pulsado ", self.cont, " veces")


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

