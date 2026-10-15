from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias


class miVentana(QMainWindow):

    #COMO USO EL BOTON FUERA DEL __INIT__ USO SELF#

    def __init__(self):
        super().__init__()

        self.boton = QPushButton("Pulsa")
        self.boton.setCheckable(True) #convierte el botón en un botón “de dos estados” (tipo interruptor). Al pulsarlo se queda hundido, y al volver a pulsarlo se suelta
        self.boton.setChecked(True) #lo deja ya pulsado desde el principio

        self.boton.clicked.connect(self.cambiarTexto)

        self.setCentralWidget(self.boton)


    def cambiarTexto(self):
        self.boton.setText("Boton ya pulsado") #Cambio el mensaje del boton una vez pulsado
        self.boton.setEnabled(False) #lo desactivo para que no se pueda pulsar mas


app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()


