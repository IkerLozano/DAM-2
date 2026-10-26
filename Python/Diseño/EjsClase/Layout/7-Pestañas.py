from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color# Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        boton = QPushButton("Boton")

        
        pestañas = QTabWidget() #permite organizar diferentes widgets en pestañas
        pestañas.setTabPosition(QTabWidget.TabPosition.North) #donde colocar las pestañas
        pestañas.setMovable(True) #si se pueden mover


        #añado pestañas, con el color y el nombre de la pestaña
        pestañas.addTab(Color("red"), "Rojo")
        pestañas.addTab(Color("green"), "Verde")
        pestañas.addTab(Color("blue"), "Azul")
        pestañas.addTab(Color("yellow"), "Amarillo")
        pestañas.addTab(Color("pink"), "Rosa")
        pestañas.addTab(boton, "Boton")


        self.setCentralWidget(pestañas)






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()