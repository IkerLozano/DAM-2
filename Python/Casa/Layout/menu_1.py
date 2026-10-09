from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from colores import colores# Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        texto = QLabel("Hola") 
        texto.setAlignment(Qt.AlignmentFlag.AlignCenter)


        #CREO LA BARRA DE OPCIONES
        barra = QToolBar("Barra de herramientas") #crea una barra de herramientas.
        barra.setIconSize(QSize(16,16))#todos los iconos que metamos en la barra de herramientas tendras el tamaño de 16,16
        self.addToolBar(barra) #añadO la barra de herramientas a la ventana principal.


        #METO COSAS A LA BARRA DE OPCIONES
        boton1 = QAction(QIcon("Casa/Layout/icons/bug.png") ,"Mi boton", self) # el self ese es ara indicar que la acción pertenece a la ventana principa
        boton1.setStatusTip("Este mi  boton") #mensaje al dejar retaon encima
        barra.addAction(boton1) #hañado el boton a la barra

        barra.addSeparator() #linea de sepracion

        boton2 = QAction(QIcon("Casa/Layout/icons/cake.png"), "Mi otro boton", self)
        boton2.setStatusTip("Este mi otro boton")
        barra.addAction(boton2)


        #en la barra se puede meter lo que sea
        barra.addSeparator() #linea de sepracion
        barra.addWidget(QLabel("Texto"))

        self.setStatusBar(QStatusBar(self)) #para mostrar los mensajes de abajo
        self.setCentralWidget(texto)




        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()