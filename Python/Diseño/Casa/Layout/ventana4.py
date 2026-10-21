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

        self.texto = QLabel("Ventana segundaria")
        
        plantilla = QVBoxLayout()
        plantilla.addWidget(self.texto)

        self.setLayout(plantilla)


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        self.ventana2=OtraVentana()
       

        boton = QPushButton("Pulsa aqui")
        self.lineaTexto = QLineEdit()

        plantilla = QVBoxLayout()

        plantilla.addWidget(boton)
        plantilla.addWidget(self.lineaTexto)
        

        boton.clicked.connect(self.mostrarVentana)
        self.lineaTexto.textChanged.connect(self.cambiarTexto)
        

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)



    def mostrarVentana(self): 
        if self.ventana2.isVisible(): #comprueba si la ventana está visible (devuelve true/false)

            self.ventana2.hide() #culta la ventana sin cerrarla definitivamente.

        else:
            self.ventana2.show()  #muestra la ventana.


    def cambiarTexto(self):
        self.ventana2.texto.setText(self.lineaTexto.text())
    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
