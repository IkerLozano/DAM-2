from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        tabs = QTabWidget()
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True) #si el usr va a poder cambiar el orden de las pestañas

        tabs.addTab(Color("red"), "rojo")
        tabs.addTab(Color("green"), "verde")
        tabs.addTab(Color("yellow"), "amarillo")
        tabs.addTab(Color("blue"), "azul")


        self.setCentralWidget(tabs)



    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
