from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores #Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        texto = QLabel("Texto")
        barra = QLineEdit()
        opt1 = QCheckBox("Opcion 1")
        opt2 = QCheckBox("Opcion 2")
        opt3 = QCheckBox("Opcion 3")


        plantilla = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QVBoxLayout()

        plantilla1.addWidget(texto)
        plantilla1.addWidget(barra)
        plantilla2.addWidget(opt1)
        plantilla2.addWidget(opt2)
        plantilla2.addWidget(opt3)


        plantilla.addLayout(plantilla1)
        plantilla.addLayout(plantilla2)


        opt1.stateChanged.connect(self.texto)
        opt2.stateChanged.connect(self.texto)
        opt3.stateChanged.connect(self.texto)

        widget = QWidget()
        widget.setLayout(plantilla)


        self.setCentralWidget(widget)

    

    def texto(self, estado):
        print(f"El boton '{self.sender().text()}' esta {["no pulsado", "", "pulsado"][estado]}")





app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()