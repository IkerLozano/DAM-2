from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton1 = QPushButton("Boton 1")
        boton2 = QPushButton("Boton 2")
        boton3 = QPushButton("Boton 3")


        plantilla = QHBoxLayout() 
        plantilla.addWidget(boton1)
        plantilla.addWidget(boton2)


        plantilla2 = QVBoxLayout() 
        plantilla2.addLayout(plantilla)
        plantilla2.addWidget(boton3)


        



        widget = QWidget()
        widget.setLayout(plantilla2) #esto solo se puede usar una vez 
        self.setCentralWidget(widget)

       


   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()
