from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        spinBox = QSpinBox() #creo el spinBox
        spinBox.setRange(-10, 10) #el indico el num max y el min que va a poder tener
        spinBox.setSuffix(" €") #le pongo texto al lado del numero
        spinBox.setSingleStep(2) #para que vaya sumando de x en x, minimo tiene q ser 1


        spinBox.valueChanged.connect(self.valores) #pone solo los numeros
        spinBox.textChanged.connect(self.texto) #pone los numeros junto con el texto



        self.setCentralWidget(spinBox)


    def valores(self, estado):
        print(estado)

    def texto(self, estado):
        print(estado)


app = QApplication([])


ventana = miVentana()
ventana.show()

app.exec()