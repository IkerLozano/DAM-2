from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        #tecxto###############################################################
        self.etiqueta = QLabel("Hola")
        self.etiqueta.setAlignment(Qt.AlignmentFlag.AlignLeft)
        ######################################################################



        #menu de botones###############################################################
        barra = QToolBar()
        barra.setIconSize(QSize(16,16)) #todos los iconos que metamos en la barra de herramientas tendras el tamaño de 16,16
        self.addToolBar(barra)  
        ######################################################################


        #botones del menu de botones###############################################################
        boton1 = QAction(QIcon("EjsClase/icons/disk.png"),"Guardar", self) ##pillamos la ruta relativa
        boton2 = QAction(QIcon("EjsClase/icons/document.png"),"Nuevo", self)
        boton3 = QAction(QIcon("EjsClase/icons/application-dock.png"),"abrir", self)

        boton1.setStatusTip("Guardar Archivo")
        boton2.setStatusTip("Nuevo Archivo")
        boton3.setStatusTip("Abrir Archivo")
        self.setStatusBar(QStatusBar(self))

        barra.addAction(boton1)
        barra.addAction(boton2)
        barra.addAction(boton3)

        ######################################################################


        #menu de opciones###############################################################
        menu = self.menuBar()

        menu_archivo = menu.addMenu("&Archivo")
        menu_ayuda = menu.addMenu("&Ayuda")

        menu_archivo.addAction(boton1)
        menu_archivo.addAction(boton2)
        menu_archivo.addAction(boton3) #metro el boton en el menu de opciones


        botonX = QAction("X", self)
        botonInstagram = QAction("Instagram", self)
        botonX.setStatusTip("Siguenos en Twitter")
        botonInstagram.setStatusTip("Siguenos en Instagram")

        submenu_ayuda = menu_ayuda.addMenu("Siguenos")
        submenu_ayuda.addAction(botonX)
        submenu_ayuda.addAction(botonInstagram)
        ######################################################################
        

       
        self.setCentralWidget(self.etiqueta)


    


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
