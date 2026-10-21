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


        boton1 = QPushButton("Rojo")
        boton2 = QPushButton("Verde")
        boton3 = QPushButton("Amarillo")

        plantilla = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QStackedLayout() #para poder poner los colores uno encima de otro

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)

        plantilla2.addWidget(colores("red"))
        plantilla2.addWidget(colores("green"))
        plantilla2.addWidget(colores("yellow"))


        boton1.pressed.connect(lambda: plantilla2.setCurrentIndex(0))
        boton2.pressed.connect(lambda: plantilla2.setCurrentIndex(1))
        boton3.pressed.connect(lambda: plantilla2.setCurrentIndex(2))

        plantilla.addLayout(plantilla1)
        plantilla.addLayout(plantilla2)

        
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()