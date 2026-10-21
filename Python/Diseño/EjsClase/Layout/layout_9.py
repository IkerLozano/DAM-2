from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

       
        plantilla = QGridLayout()
        
        
        plantilla.addWidget(Color("red"), 0, 0)
        plantilla.addWidget(Color("green"), 0, 1)
        plantilla.addWidget(Color("yellow"), 1, 3)
        plantilla.addWidget(Color("blue"), 3, 0)
    
        


        
        widget_central = QWidget()
        widget_central.setLayout(plantilla)
        self.setCentralWidget(widget_central)

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
