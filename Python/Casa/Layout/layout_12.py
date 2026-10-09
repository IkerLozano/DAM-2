from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores# Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        
        pestañas = QTabWidget() #permite organizar diferentes widgets en pestañas
        pestañas.setTabPosition(QTabWidget.TabPosition.North) #donde colocar las pestañas
        pestañas.setMovable(True) #si se pueden mover

        #añado pestañas, con el color y el nombre de la pestaña
        pestañas.addTab(colores("red"), "Rojo")
        pestañas.addTab(colores("green"), "Verde")
        pestañas.addTab(colores("blue"), "Azul")
        pestañas.addTab(colores("yellow"), "Amarillo")
        pestañas.addTab(colores("pink"), "Rosa")


        self.setCentralWidget(pestañas)






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()