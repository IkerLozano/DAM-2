from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap



from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


    
        spinBox = QSpinBox()
        spinBox.setRange(-10, 10) #ranfo maximo y minimo
        spinBox.setSuffix(" €") #texto que saldra al lado de los umeros
        spinBox.setSingleStep(2) #para que vaya de 2 en 2, tiene q ser distinto de 1

        spinBox.valueChanged.connect(self.valorCambiado)
        spinBox.textChanged.connect(self.textoCambiado)



    
        self.setCentralWidget(spinBox)



    def valorCambiado(self, estado):
        print(estado)


    def textoCambiado(self, estado):
            print(estado)



         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



