from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


    
       
        spinBox = QSlider(Qt.Orientation.Horizontal)
        spinBox.setRange(-10, 10)

        spinBox.valueChanged.connect(self.valorCambiado)
        spinBox.sliderMoved.connect(self.valorCambiado)
        


    
        self.setCentralWidget(spinBox)



    def valorCambiado(self, estado):
        print(estado)


    def textoCambiado(self, estado):
            print(estado)



         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



