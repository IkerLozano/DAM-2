from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color #Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


      
        label = QLabel("Texto")
        texto = QLineEdit()
        casilla1 = QCheckBox("Opcion 1")
        casilla2 = QCheckBox("Opcion 2")
        casilla3 = QCheckBox("Opcion 3")



        plantilla = QVBoxLayout()
        plantilla.addWidget(casilla1)
        plantilla.addWidget(casilla2)
        plantilla.addWidget(casilla3)

        plantilla2 = QHBoxLayout()
        plantilla2.addWidget(label)
        plantilla2.addWidget(texto)
       

        plantilla3 = QVBoxLayout()
        plantilla3.addLayout(plantilla2)
        plantilla3.addLayout(plantilla)


        casilla1.stateChanged.connect(self.mensaje)
        casilla2.stateChanged.connect(self.mensaje)
        casilla3.stateChanged.connect(self.mensaje)



        widget = QWidget()
        widget.setLayout(plantilla3) #esto solo se puede usar una vez 
        self.setCentralWidget(widget)





    def mensaje(self, estado):
        print(f"El boton {self.sender().text()} {["no pulsado", "", "pulsdo"][estado]}")







app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()