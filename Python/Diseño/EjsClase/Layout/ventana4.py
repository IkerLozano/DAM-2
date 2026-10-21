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
        self.etiqueta = QLabel()
        plantilla.addWidget(self.etiqueta)
        self.setLayout(plantilla)


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.window=OtraVentana( )
        self.setWindowTitle("Mi ventana")


        self.boton = QPushButton("Pulsa aqui")
        self.boton.clicked.connect(self.mostrarVentana)

        self.input = QLineEdit()
        self.input.textChanged.connect(self.window.etiqueta.setText)

        plantilla = QVBoxLayout()
        plantilla.addWidget (self.boton)
        plantilla.addWidget(self.input)
        contenedor = QWidget()
        contenedor.setLayout(plantilla)
        


        self.setCentralWidget(contenedor)



    def mostrarVentana(self): 
        if self.window.isVisible():
            self.window.hide()
        else:
            self.window.show()


    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
