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



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #guarda una referencia de la segunda ventana y le dice que no hay nonguna ventana guardada
        #Para saber si ya se ha creado la segunda ventana y poder reutilizar esa información para decidir qué hacer al pulsar el botón.
        self.ventana2=None

        boton = QPushButton("Pulsa")
        boton.clicked.connect(self.abrirVentana)

        self.setCentralWidget(boton)


    def abrirVentana(self):

        #si no hay ninguna ventana guadarda
        if self.ventana2 is None:
            
            self.ventana2 = otraVentana() #se crea la ventana segundaria
            self.ventana2.show() #se muestra


        #si windows ya tiene una ventana creada
        else:
            self.ventana2.close() #la cierra
            self.ventana2 = None #le indica que ya no hay ninguna creada




app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
