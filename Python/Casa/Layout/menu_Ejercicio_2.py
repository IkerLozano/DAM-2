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

        self.cont = 0

        #TEXTO
        self.texto = QLabel("Hola")


        #BARRA DE OPCIONES
        barra = QToolBar() #creo la barra
        self.addToolBar(barra) #añado la barra a la ventana


        #METO LOS BOTONES DENTRO DE LA BARRA
        boton = QAction(QIcon("Layout/icons/disk.png"), "Guardar", self)
        boton2 = QAction(QIcon("Layout/icons/document.png"), "Nuevo", self)
        boton3 = QAction(QIcon("Layout/icons/application.png"), "Abrir", self)
        
        boton.setStatusTip("Guardar archivo")
        boton2.setStatusTip("Nueco archivo")
        boton3.setStatusTip("Abrir archivo")
        self.setStatusBar(QStatusBar(self))

        barra.addAction(boton)
        barra.addAction(boton2)
        barra.addAction(boton3)


        #CREO EL MENU DE OPCIONES DE ARRIBA Y METO UNA OPCION
        menu = self.menuBar()

        menu_archivo = menu.addMenu("&Archivo")
        menu_ayuda = menu.addMenu("&Ayuda")

        menu_archivo.addAction(boton)
        menu_archivo.addAction(boton2)
        menu_archivo.addAction(boton3)

        boton4 = QAction("X", self)
        boton5 = QAction("Instagram", self)

        submenu_ayuda = menu_ayuda.addMenu("&Siguenos")
        submenu_ayuda.addAction(boton4)
        submenu_ayuda.addAction(boton5)

        boton4.setStatusTip("Siguenos en Twitter")
        boton5.setStatusTip("Siguenos en Instagram")

      

       
        #COLOCO EL TEXTO
        self.setCentralWidget(self.texto)


    def textoCambiado(self):
        self.cont = self.cont +1
        self.texto.setText(f"Texto cambiado: {self.cont}")
        #con setText le deciomos que cambie el contenid del texto 



        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()