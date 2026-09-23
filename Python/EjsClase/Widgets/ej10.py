from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        self.boton = QPushButton("Pulsa")
        self.setCentralWidget(self.boton)

        self.boton.clicked.connect(self.tercero) #pulsar y soltar

        self.boton.setCheckable(True)
        self.boton.setChecked(True)


    def tercero(self, pulsado):
        self.boton.setText(["No pulsado", "Pulsado"][pulsado]) #lista con los valores para nuestro boton        


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

