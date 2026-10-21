from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        #PESTAÑA 1 

        texto = QLabel("Hola")
        barra = QLineEdit()


        plantilla = QHBoxLayout()

        plantilla.addWidget(texto)
        plantilla.addWidget(barra)




        #PESTAÑA 2
        
        casilla = QCheckBox("Seleccion")
        barra = QPushButton("Pulsa")


        plantilla2 = QVBoxLayout()

        plantilla2.addWidget(casilla)
        plantilla2.addWidget(barra)

    
    

        #PESTAÑAS
    
        tabs = QTabWidget()
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True) #si el usr va a poder cambiar el orden de las pestañas

        widget1 = QWidget()
        widget2 = QWidget()

        widget1.setLayout(plantilla)
        widget2.setLayout(plantilla2)

        tabs.addTab((widget1), "Pestaña 1")
        tabs.addTab((widget2), "Pestaña 2")
       


        self.setCentralWidget(tabs)


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
