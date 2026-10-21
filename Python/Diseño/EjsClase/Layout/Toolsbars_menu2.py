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



        etiqueta = QLabel("Hola")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter)

        barra = QToolBar("Barra de herramientas")
        barra.setIconSize(QSize(16,16)) #todos los iconos que metamos en la barra de herramientas tendras el tamaño de 16,16
        self.addToolBar(barra)  
        
        boton = QAction(QIcon("EjsClase/icons/bug.png"),"Mi boton", self) ##pillamos la ruta relativa
        boton.setStatusTip("Este es mi boton")
        boton.triggered.connect(self.botonPulsado)
        barra.addAction(boton)

        barra.addSeparator() #añade una barra de separacion

        boton2 = QAction(QIcon("EjsClase/icons/cake.png"),"Mi otro boton", self) ##pillamos la ruta relativa
        boton2.setStatusTip("Este es mi otro boton")
        boton2.triggered.connect(self.botonPulsado)
        barra.addAction(boton2) #los QAction los que voy a añadir en mi menus

        barra.addWidget(QLabel("Texto")) 
        barra.addWidget(QCheckBox("Selecion")) 

        barra.addSeparator() #añade una barra de separacion

        self.setStatusBar(QStatusBar(self))

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_editar = menu.addMenu("&Editar") #cuando pulsemos alt se subraya la letra A
        menu_insertar = menu.addMenu("&Insertar")
        
        menu_archivo.addAction(boton) #metemos dentro de nuestro menu una accion (por eso es addAction)
        menu_archivo.addAction(boton2)

        menu_archivo.addSeparator()

        menu_mas = menu_archivo.addMenu("Mas")

        menu_mas.addAction(boton)
        menu_mas.addAction(boton2)
    


        self.setCentralWidget(etiqueta)


    def botonPulsado(self, s):
        print("Pulsdo", s)
    


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
