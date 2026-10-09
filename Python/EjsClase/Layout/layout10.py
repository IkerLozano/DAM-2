from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

       
        plantilla = QStackedLayout()
        
        
        plantilla.addWidget(Color("red")) #0
        plantilla.addWidget(Color("yellow")) #1
        plantilla.addWidget(Color("green")) #2
        plantilla.addWidget(Color("blue")) #3

        plantilla.setCurrentIndex(2)
    
        


        
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
