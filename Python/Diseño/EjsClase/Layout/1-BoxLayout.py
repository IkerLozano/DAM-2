from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
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


        plantilla = QVBoxLayout() 
        plantilla.addWidget(boton1)
        plantilla.addWidget(boton2)
        plantilla.addWidget(boton3)

        plantilla.setSpacing(20) #espacio entre todo los elementos
        #plantilla.setContentsMargins(10,10,10,10) #lo pone a cada uno, los dos hacen lo mimso


        boton1.clicked.connect(self.botonPulsado)
        boton2.clicked.connect(self.botonPulsado)
        boton3.clicked.connect(self.botonPulsado)
        

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)



    def botonPulsado(self):
        print(f"Boton {self.sender().text()} pulsado") 
        #self.sender() --> detecta el objeto exacto que envió la señal
        #.text() -->  Recupera el texto visible que tiene escrito ese botón, si no loponemos se vera mal
        #f --> para concatenar cadenas


#plantilla1.addWidget() --> para añadir un widget a la plantilla
#plantilla.addLayout(plantilla2) --> añadir las plantillas dentro de la plantilla padre
#widget.setLayout(plantilla) --> meter todas las plantillas dentro de un widget pq QMainWindow solo puede tener un widget central así que metemos la plantilla padre en un widget y mostramos este widget

    






       

        




        




   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()
