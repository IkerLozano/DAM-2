from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        plantilla = QHBoxLayout()
        plantilla2 = QVBoxLayout()
        plantilla3 = QVBoxLayout()


        plantilla2.addWidget(Color("red"))
        plantilla2.addWidget(Color("red"))
        plantilla2.addWidget(Color("red"))


        plantilla3.addWidget(Color("red"))
        plantilla3.addWidget(Color("red"))
        plantilla3.addWidget(Color("red"))


        plantilla.addLayout(plantilla2)
        plantilla.addWidget(Color("yellow"))
        plantilla.addLayout(plantilla3)
        
        




        widget = QWidget() #este es el contenedor de todo
        widget.setLayout(plantilla)
        
        self.setCentralWidget(widget)




   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()
