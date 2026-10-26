from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

    
        spinBox = QSlider(Qt.Orientation.Horizontal) #lo de dentro es para cambiar la orientacion de la barra
        spinBox.setRange(-10, 10)


        spinBox.valueChanged.connect(self.valorCambiado) #valueChanged --> cuando el valor cambie
        spinBox.sliderMoved.connect(self.textoCambiado) #sliderMoved --> cuando mueves el deslizador 
        

        self.setCentralWidget(spinBox)



    def valorCambiado(self, estado):
        print(estado)


    def textoCambiado(self, estado):
            print(estado)



         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



