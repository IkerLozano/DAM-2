from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon

from dialogs import CustomDialog


#from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton = QPushButton("Pulsa aqui")
        boton.clicked.connect(self.botonPulsado)
        
        self.setCentralWidget(boton)


    #creo el dialog
    def botonPulsado(self, s):
       dlg = CustomDialog(self) #con el self indicamosquein es su padre, por eso al ejecutarlo la nueva ventana sale dentro
       dlg.setWindowTitle("Cuadro de dialogo")
       dlg.exec() #la ventana principal queda bloqueada hasta que se cierre el diálogo y devuelve un resultado,

    


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
