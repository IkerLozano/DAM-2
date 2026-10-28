from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QTextEdit
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon



class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #PESTAÑA 1###########
        self.texto1 = QTextEdit()
        self.texto1.setPlaceholderText("Escribe aquí...")

        plantillaP = QHBoxLayout()
        plantillaP.addWidget(self.texto1)


        #PESTAÑA 2###########
        self.texto2 = QTextEdit()
        self.texto2.setPlaceholderText("Escribe aquí...")

        plantillaP2 = QHBoxLayout()
        plantillaP2.addWidget(self.texto2)

       

        #UNION DE LAS PESTAÑAS###########
        self.pestañas = QTabWidget()
        self.pestañas.setTabPosition(QTabWidget.TabPosition.North)
        self.pestañas.setMovable(True) 


        self.widget1 = QWidget()
        widget2 = QWidget()

        #meto las plantillas con su contenido
        self.widget1.setLayout(plantillaP)
        widget2.setLayout(plantillaP2)

        #creo una pestaña para cada plantilla
        self.pestañas.addTab((self.widget1), "Nota 1")
        self.pestañas.addTab((widget2), "Nota 2")



        #BARRA DE OPCIONES###########
        barra = QToolBar() #creo la barra
        self.addToolBar(barra) #añado la barra a la ventana


        #meto los botones dentro de la barra

            #les pongo icono y mensaje al pasar el raton
        boton = QAction(QIcon("img\Captura de pantalla 2026-09-16 205952.png"), "Guardar", self)
        self.boton2 = QAction(QIcon("img\Captura de pantalla 2026-09-16 205952.png"), "Nuevo", self)
        self.boton3 = QAction(QIcon("img\Captura de pantalla 2026-09-16 205952.png"), "Abrir", self)
        texto3 = QLabel("Texto")

            #mesanje inferior
        boton.setStatusTip("Guardar archivo")
        self.boton2.setStatusTip("Nuevo menu")
        self.boton3.setStatusTip("Abrir archivo")
        self.setStatusBar(QStatusBar(self)) #para q estos mensajes se muestren

            #añado los botones a la barra
        barra.addAction(boton)
        barra.addAction(self.boton2)
        barra.addAction(self.boton3)
        barra.addWidget(texto3)


        

        #CREO EL MENU DE OPCIONES DE ARRIBA Y METO LAS OPCIONES
            #creo el menu
        menu = self.menuBar()

            #creo las opciones que va a ver en el menu
        menu_archivo = menu.addMenu("&Archivo")
        menu_ayuda = menu.addMenu("&Ayuda")

            #dentro del menu añado botones
        menu_archivo.addAction(boton)
        menu_archivo.addAction(self.boton2)
        menu_archivo.addAction(self.boton3)
       

            #creo dos botones
        boton4 = QAction("X", self)
        boton5 = QAction("Instagram", self)

            #creo un submenu para el menu de ayuda y dentro de ese submenu meto dos botones
        submenu_ayuda = menu_ayuda.addMenu("&Siguenos")
        submenu_ayuda.addAction(boton4)
        submenu_ayuda.addAction(boton5)

            #mensajes inferiores
        boton4.setStatusTip("Siguenos en Twitter")
        boton5.setStatusTip("Siguenos en Instagram")



        #FUNCIONALIDAD#####
        self.boton2.triggered.connect(self.nuevoMenu)
        self.boton3.triggered.connect(self.borar)



        self.setCentralWidget(self.pestañas)
        


        self.cont = 2

    def nuevoMenu(self):
        self.cont = self.cont +1

        #creo el widget
        self.textoCont = QTextEdit()
        self.textoCont.setPlaceholderText("Escribe aquí...")

        plantillaP = QHBoxLayout()
        plantillaP.addWidget(self.textoCont)

        #meto las plantillas con su contenido
        widgetNuevo = QWidget()
        widgetNuevo.setLayout(plantillaP)
        

        #creo una pestaña para cada plantilla
        self.pestañas.addTab((widgetNuevo), f"Nota {self.cont}")


    def borar(self):
        self.texto1.clear()
        self.texto2.clear()
        

        



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()