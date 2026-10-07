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



        #menu de botonn###############################################################
        barra = QToolBar()
        barra.setIconSize(QSize(16,16)) #todos los iconos que metamos en la barra de herramientas tendras el tamaño de 16,16
        self.addToolBar(barra)  
        ######################################################################


        #boton del menu de botones###############################################################
        boton = QAction(QIcon("EjsClase/icons/bug.png"),"Mi boton", self) ##pillamos la ruta relativa
        boton.setStatusTip("Este es mi boton")
        boton.triggered.connect(self.botonPulsado)
        barra.addAction(boton)
        ######################################################################


        #menu de opciones###############################################################
        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_archivo.addAction(boton) #metro el boton en el menu de opciones
        ######################################################################
        

        self.cont = 0

        self.setCentralWidget(self.etiqueta)





    def botonPulsado(self):
        self.cont = self.cont +1
        self.etiqueta.setText(f"Texto cambiado {self.cont}")
    


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
