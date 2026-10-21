from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel, QMessageBox
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon



class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        texto = QLabel("Ventana segundaria")
        
        plantilla = QVBoxLayout()
        plantilla.addWidget(texto)

        self.setLayout(plantilla)


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.ventana2=OtraVentana() #para poder acceder desde la ventana padre a la segundaria
        self.setWindowTitle("Mi ventana")


        boton = QPushButton("Pulsa aqui")
        boton.clicked.connect(self.mostrarVentana)
        


       
        self.setCentralWidget(boton)



    def mostrarVentana(self): 
        if self.ventana2.isVisible(): #comprueba si la ventana está visible (devuelve true/false)

            self.ventana2.hide() #culta la ventana sin cerrarla definitivamente.

        else:
            self.ventana2.show()  #muestra la ventana.


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
