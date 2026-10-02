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
        self.addToolBar(barra)  
        
        boton = QAction("Mi boton", self)
        boton.setStatusTip("Este es mi boton")
        boton.triggered.connect(self.botonPulsado)
        barra.addAction(boton)

        self.setStatusBar(QStatusBar(self))


        self.setCentralWidget(etiqueta)


    def botonPulsado(self, s):
        print("Pulsdo", s)
    


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
