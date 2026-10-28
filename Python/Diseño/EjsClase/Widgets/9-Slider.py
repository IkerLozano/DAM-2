from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

    
        slider = QSlider(Qt.Orientation.Horizontal) #lo de dentro es para cambiar la orientacion de la barra
        slider.setRange(-10, 10)
        slider.setValue(5) #valor por defecto
        #valor = slider.value() #saber que numero tiene el slider
        #print(valor)


        slider.valueChanged.connect(self.valorCambiado) #valueChanged --> cuando el valor cambie
        slider.sliderMoved.connect(self.textoCambiado) #sliderMoved --> cuando mueves el deslizador 
        

        self.setCentralWidget(slider)



    def valorCambiado(self, estado):
        print(estado)


    def textoCambiado(self, estado):
            print(estado)



         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



