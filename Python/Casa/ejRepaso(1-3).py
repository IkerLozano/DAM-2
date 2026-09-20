from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        boton = QPushButton("Pulsa")
        self.setCentralWidget(boton)
        #boton.setCheckable(True)

        boton.pressed.connect(self.uno)
        boton.released.connect(self.dos)
        boton.clicked.connect(self.tres)

        #boton.clicked.connect(self.activado)


    def uno(self):
        print("Boton Pulsado")

    def dos(self):
        print("Boton soltado")

    def tres(self):
        print("Boton pulsado y soltado")

    #def activado(self, si):
    #    print(si)


app = QApplication([])


ventana = miVentana()
ventana.show()

app.exec()