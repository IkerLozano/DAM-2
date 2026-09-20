from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    #COMO USO EL BOTON FUERA DEL __INIT__ USO SELF#

    def __init__(self):
        super().__init__()

        self.boton = QPushButton("Pulsa")
        self.setCentralWidget(self.boton)
        self.boton.setCheckable(True)
        self.boton.setChecked(True)

        self.boton.clicked.connect(self.cambiarTexto)


    def cambiarTexto(self):
        self.boton.setText("Boton ya pulsado") #Cambio el mensaje del boton una vez pulsado
        self.boton.setEnabled(False) #lo desactivo para que no se pueda pulsar mas


app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()


