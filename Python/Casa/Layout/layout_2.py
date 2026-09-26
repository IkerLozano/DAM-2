from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores #Del archivo color.py, tráeme la clase Color


class miVnetana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        plantilla = QHBoxLayout() #esta sera la plantilla padre
        plantilla1 = QVBoxLayout()
        plantilla2 = QVBoxLayout()


        plantilla1.addWidget(colores("red"))
        plantilla1.addWidget(colores("red"))
        plantilla1.addWidget(colores("red"))

        plantilla2.addWidget(colores("red"))
        plantilla2.addWidget(colores("red"))
        plantilla2.addWidget(colores("red"))

        
        plantilla.addLayout(plantilla1) #metemso dentro de la platilla padre a la plantilla1
        plantilla.addWidget(colores("yellow"))
        plantilla.addLayout(plantilla2) #metemso dentro de la platilla padre a la plantilla2


        #este es la ventana, metemos todo en la ventana
        widget = QWidget() 
        widget.setLayout(plantilla)

        self.setCentralWidget(widget)





app = QApplication([])


ventana = miVnetana()
ventana.show()


app.exec()