from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon



class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        
        #TEXTO
        self.texto = QLabel("Hola")


        #BARRA DE OPCIONES
        barra = QToolBar() #creo la barra
        self.addToolBar(barra) #añado la barra a la ventana
        barra.setToolButtonStyle(Qt.ToolButtonStyle.ToolButtonTextBesideIcon) #para qu el icono no tape el texto



        #METO LOS BOTONES DENTRO DE LA BARRA DE TAREAS

            #les pongo icono y mensaje al passar el raton
        boton = QAction(QIcon("icons/disk.png"), "Guardar", self)
        boton2 = QAction(QIcon("icons/document.png"), "Nuevo", self)
        boton3 = QAction(QIcon("icons/application.png"), "Abrir", self)

            #mesanje inferior
        boton.setStatusTip("Guardar archivo")
        boton2.setStatusTip("Nueco archivo")
        boton3.setStatusTip("Abrir archivo")
        self.setStatusBar(QStatusBar(self)) #para q estos mensajes se muestren

            #añado los botones a la barra
        barra.addAction(boton)
        barra.addAction(boton2)
        barra.addAction(boton3)


        #CREO EL MENU SUPERIOR DE OPCIONES DE ARRIBA Y METO UNA OPCION
            #creo el menu
        menu = self.menuBar()

            #creo las opciones qu eva a ver en el menu
        menu_archivo = menu.addMenu("&Archivo")
        menu_ayuda = menu.addMenu("&Ayuda")

            #dentro del menu añado btotones
        menu_archivo.addAction(boton)
        menu_archivo.addAction(boton2)
        menu_archivo.addAction(boton3)

            #creo dos botones
        boton4 = QAction("X", self)
        boton5 = QAction("Instagram", self)

            #creo un seubmenu para el menu de ayuda y dentro de ese submenu meto dos botones
        submenu_ayuda = menu_ayuda.addMenu("&Siguenos")
        submenu_ayuda.addAction(boton4)
        submenu_ayuda.addAction(boton5)

            #mensajes inferiores
        boton4.setStatusTip("Siguenos en Twitter")
        boton5.setStatusTip("Siguenos en Instagram")

      
        #COLOCO EL TEXTO
        self.setCentralWidget(self.texto)



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()