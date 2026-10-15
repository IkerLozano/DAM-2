from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.boton = QPushButton("Pulsa")
        
        self.boton.setCheckable(True)
        self.boton.setChecked(True) #Para que empieze marcado

        self.boton.clicked.connect(self.pulsado)


        self.setCentralWidget(self.boton)

    def pulsado(self, estado):
        self.boton.setText(["Boton pulsado", "Boton no pulsado"])
        #hacemos una lista con los posibles mensajes del boton
        #segun el estado elegira pulsado si el estado es True y  no pulsado si es False


app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()