from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,QRadioButton,  QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget, QGroupBox   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton1 = QPushButton("1")
        boton2 = QPushButton("2")
        boton3 = QPushButton("3")

        opcion1 = QRadioButton("Opcion 1")
        opcion2 = QRadioButton("Opcion 2")
        opcion3 = QRadioButton("Opcion 3")
         

        plantilla = QVBoxLayout()
        plantilla2 = QVBoxLayout()
        plantilla3 = QHBoxLayout()
        
        plantilla.addWidget(boton1)
        plantilla.addWidget(boton2)
        plantilla.addWidget(boton3)

        plantilla2.addWidget(opcion1)
        plantilla2.addWidget(opcion2)
        plantilla2.addWidget(opcion3)

        grupo1 = QGroupBox("Botones")
        grupo2 = QGroupBox("Seleccion")

        
        plantilla.setSpacing(20) #espacio entre todo los elementos


        grupo1.setLayout(plantilla)
        grupo2.setLayout(plantilla2)
        plantilla3.addWidget(grupo1)
        plantilla3.addWidget(grupo2)
        widget = QWidget()
        widget.setLayout(plantilla3)
        self.setCentralWidget(widget)

    




   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()
