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
