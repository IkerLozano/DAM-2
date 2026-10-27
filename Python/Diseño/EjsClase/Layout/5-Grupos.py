from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,QRadioButton,  QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget, QGroupBox   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #WIDGETS###
        boton1 = QPushButton("1")
        boton2 = QPushButton("2")
        boton3 = QPushButton("3")
        opt1 = QCheckBox("Opcion 1")
        opt2 = QCheckBox("Opcion 2")
        opt3 = QCheckBox("Opcion 3")

        #PLANTILLAS####
        plantilla = QHBoxLayout()
        plantilla1 = QVBoxLayout()
        plantilla2 = QVBoxLayout()

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)
        plantilla2.addWidget(opt1)
        plantilla2.addWidget(opt2)
        plantilla2.addWidget(opt3)
        #las plantillas hay que meterlas a la plantilla padre en el momento que se hace el grupo, no antes

        #GRUPOS#####
        grupo1 = QGroupBox("Botones") #creo el grupo
        grupo2 = QGroupBox("Seleccion")

        grupo1.setLayout(plantilla1) #meto la plantilla de los botones dentro del grupo
        grupo2.setLayout(plantilla2) #meto la plantilla de las opciones dentro del grupo

        plantilla.addWidget(grupo1) #en la plantilla padre meto los 2 grupos
        plantilla.addWidget(grupo2)


        # Separación entre los botones
        plantilla1.setSpacing(20)

        # Separación entre las opciones
        plantilla2.setSpacing(20)

        # Separación entre los dos grupos
        plantilla.setSpacing(20)



        #lo muestro en la ventana
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)





      
        
        





app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()