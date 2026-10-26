from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")


        dial = QDial() #crea el dial
        dial.setNotchesVisible(True) #para ver las muescas

        dial.valueChanged.connect(self.valores) #valueChanged --> cuando el valor cambie


        self.setCentralWidget(dial)


    def valores(self, estado):
        print(estado)


app = QApplication([])

ventana = miVentana()
ventana.show()


app .exec()