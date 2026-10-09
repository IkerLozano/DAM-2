from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel, QMessageBox
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialogs import CustomDialog # Del archivo color.py, tráeme la clase Color



class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        plantilla = QVBoxLayout()
        self.etiqueta = QLabel("Otra ventana")
        plantilla.addWidget(self.etiqueta)
        self.setLayout(plantilla)


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton = QPushButton("Pulsa aqui")
        boton.clicked.connect(self.mostrarVentana)
        


       
        self.setCentralWidget(boton)



    def mostrarVentana(self): 
        self.ventana = OtraVentana()
        self.ventana.show()
    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
