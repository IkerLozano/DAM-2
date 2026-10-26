from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel, QMessageBox
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon



class otraVentana(QWidget):
    def __init__(self):
        super().__init__()


        texto = QLabel("Ventana segundaria")

        plantilla = QVBoxLayout()
        plantilla.addWidget(texto)

        self.setLayout(plantilla)

#QWidget no tiene el método setCentralWidget. Ese método solo existe en QMainWindow 
#Por eso en la ventana secundaria hay que crear un plantilla, pq QWidget  trabaja con setLayout


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        boton = QPushButton("Pulsa")
        boton.clicked.connect(self.abrirVentana)

        self.setCentralWidget(boton)


    def abrirVentana(self):
        self.ventana = otraVentana()
        self.ventana.show()




app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()



#La diferencia entre una ventana y un dialog es que en la ventana si ponemos 
#un botón no podemos recoger el resultado o va a ser mucho más costoso que con 
#un dialog. En Un dialog la venta padre se bloquea hasta cerrar la nueva y aquí no
