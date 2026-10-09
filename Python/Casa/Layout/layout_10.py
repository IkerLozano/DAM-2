from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores # Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #sirve para colocar varios widgets uno encima de otro y mostrar solo uno a la vez.
        plantilla = QStackedLayout()


        plantilla.addWidget(colores("red")) #0
        plantilla.addWidget(colores("green")) #1
        plantilla.addWidget(colores("yellow")) #2
        plantilla.addWidget(colores("blue")) #3

        #selecciona y muestra el widget que está en la posición 1 dentro del QStackedLayout
        plantilla.setCurrentIndex(3)


        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()