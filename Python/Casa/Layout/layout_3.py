from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        boton1 = QPushButton("1")
        boton2 = QPushButton("2")
        boton3 = QPushButton("3")

        plantilla = QHBoxLayout() #la plantilla padre
        plantilla1 = QVBoxLayout() #aqui colocaremos los botones

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)

        plantilla.addLayout(plantilla1) 
        
        plantilla.setSpacing(10) #espacio entre elementos
        #plantilla.setContentsMargins(10,10,10,10) #lo pone a cada uno, los dos hacen lo mimso


        boton1.clicked.connect(self.texto)
        boton2.clicked.connect(self.texto)
        boton3.clicked.connect(self.texto)

        widget = QWidget()
        widget.setLayout(plantilla)

        self.setCentralWidget(widget)


    def texto(self):
        print(f"boton {self.sender().text()} pulsado")
        #self.sender() --> detecta el objeto exacto que envió la señal
        #.text() -->  Recupera el texto visible que tiene escrito ese botón, si no loponemos se vera mal
        #f --> para concatenar cadenas

    







app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()