from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QMessageBox, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDateEdit,
    QTextEdit, 
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialogs import CustomDialog # Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #WIDGETS###
        self.radio1 = QRadioButton("Aragon")
        self.radio2 = QRadioButton("Comunidad Valenciana")
        self.lista = QComboBox()

        
        #PLANTILLAS###
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()

        plantilla1.addWidget(self.radio1)
        plantilla1.addWidget(self.radio2)
        plantillaP.addLayout(plantilla1)
        plantillaP.addWidget(self.lista)


        #LLAMO A LA FUNCION
        self.radio1.clicked.connect(self.cambioLista1)
        self.radio2.clicked.connect(self.cambioLista2)
        


        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)

    def cambioLista1(self):
        self.lista.clear()
        self.lista.addItems(["Huesca", "Zaragoza", "Teruel"])


    def cambioLista2(self):
        self.lista.clear()
        self.lista.addItems(["Castellón", "Valencia", "Alicante"])
    






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        