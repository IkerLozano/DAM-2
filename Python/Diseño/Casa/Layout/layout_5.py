from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores #Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton1 = QPushButton("Boton 1")
        boton2 = QPushButton("Boton 2")
        boton3 = QPushButton("Boton 3")


        plantilla = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QHBoxLayout()

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)

        plantilla2.addWidget(boton3)


        plantilla.addLayout(plantilla1)
        plantilla.addLayout(plantilla2)


        widget = QWidget()
        widget.setLayout(plantilla)


        self.setCentralWidget(widget)



      
        





app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()