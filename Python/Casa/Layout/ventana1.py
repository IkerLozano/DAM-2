from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon




#VENTANA SEGUNDARIA
class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        self.texto = QLabel("Segunda ventana", self)


#VENTANA PRINCIPAL
class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        boton = QPushButton("Pulsa")

        boton.clicked.connect(self.botonPulsado)



        self.setCentralWidget(boton)


    def botonPulsado(self):
        self.ventana = OtraVentana()
        self.ventana.show()



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()