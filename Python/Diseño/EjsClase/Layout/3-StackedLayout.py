from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #sirve para colocar varios widgets uno encima de otro y mostrar solo uno a la vez.
        plantilla = QStackedLayout()


        plantilla.addWidget(Color("red")) #0
        plantilla.addWidget(Color("green")) #1
        plantilla.addWidget(Color("yellow")) #2
        plantilla.addWidget(Color("blue")) #3


        #Muestro el widget 3
        plantilla.setCurrentIndex(3) #setCurrentIndex(núm) -->  Elije que widget muestra



        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()