from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        casilla = QCheckBox("Casilla de verificacion") #crear el checkBox

        formato = casilla.font() #nos da acceso a los formatos
        formato.setBold(True) #negrita
        casilla.setFont(formato) #aplicamos el formato a la casilla

        casilla.stateChanged.connect(self.estado) #hacesmos que cuando cambie ek estado del checkBox llame a la funcion

        self.setCentralWidget(casilla)


    def estado(self, estado): #2 es marcado y 0 no marcado tamb puede estar parcialmente marcado (1)
        print(estado)


app = QApplication([])

ventena = miVentana()
ventena.show()

app.exec()