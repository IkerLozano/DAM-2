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


    
        spinBox = QSpinBox() #crear el SpinBox
        spinBox.setRange(-10, 10) #rango maximo y minimo
        spinBox.setSuffix(" €") #le pongo texto al lado del numero
        spinBox.setSingleStep(2) #para que vaya sumando de x en x, minimo tiene q ser 1
        spinBox.setValue(5) #valor por defecto
        #cantidad = self.spinBox.value() saber que valor hay puesto

        spinBox.valueChanged.connect(self.valorCambiado) #valueChanged -->  pone solo el número
        spinBox.textChanged.connect(self.textoCambiado) #textChanged -->  pone el número y el texto



        self.setCentralWidget(spinBox)



    def valorCambiado(self, estado):
        print(estado)


    def textoCambiado(self, estado):
            print(estado)



         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



