from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

       
        boton1 = QPushButton("red")
        boton2 = QPushButton("green")
        boton3 = QPushButton("yellow")


        plantilla = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QStackedLayout()

        plantilla2.addWidget(Color("red"))
        plantilla2.addWidget(Color("green"))
        plantilla2.addWidget(Color("yellow"))


        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)

        boton1.pressed.connect(lambda: plantilla2.setCurrentIndex(0))
        boton2.pressed.connect(lambda: plantilla2.setCurrentIndex(1))
        boton3.pressed.connect(lambda: plantilla2.setCurrentIndex(2))

        plantilla.addLayout(plantilla1)
        plantilla.addLayout(plantilla2)
        


        widget = QWidget()
        widget.setLayout(plantilla)


        self.setCentralWidget(widget)



    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
