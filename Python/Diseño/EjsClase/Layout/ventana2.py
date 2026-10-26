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

        plantilla = QVBoxLayout()
        self.etiqueta = QLabel("Otra ventana")
        plantilla.addWidget(self.etiqueta)
        self.setLayout(plantilla)


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")
        
        
        #guarda una referencia de la segunda ventana y le dice que no hay nonguna ventana guardada
        #Para saber si ya se ha creado la segunda ventana y poder reutilizar esa información para decidir qué hacer al pulsar el botón.
        self.window=None
        

        boton = QPushButton("Pulsa aqui")
        boton.clicked.connect(self.mostrarVentana)
        

        self.setCentralWidget(boton)



    def mostrarVentana(self): 

        #si no hay ninguna ventana guadarda
        if self.window is None:

            self.window = OtraVentana() #se crea la ventaa segundaria
            self.window.show() #se muestra

        #si windows ya tiene una ventana creada
        else:
            self.window.close() #la cierra
            self.window=None #le indica que ya no hay ninguna creada
    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
