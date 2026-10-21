from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        barra = QSlider(Qt.Orientation.Horizontal) #lo de dentro es para cambiar la orientacion de la barra
        barra.setRange(-10, 10) #ponemos el ranto

        barra.valueChanged.connect(self.valores)


        self.setCentralWidget(barra)

    def valores(self, estado):
        print(estado)



app = QApplication([])

ventana = miVentana()
ventana.show()


app .exec()