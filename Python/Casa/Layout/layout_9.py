from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        plantilla = QGridLayout()

        #en la paltilla colcoo varios elementos
        plantilla.addWidget(colores("red"), 0,0)
        plantilla.addWidget(colores("green"), 0,1)
        plantilla.addWidget(colores("yellow"), 1,2)
        plantilla.addWidget(colores("blue"), 2,0)


        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)






      
        





app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()