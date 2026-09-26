from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


#En este archivo se encarga de crear la ventana y colocar esos widgets.

from colores import colores #Del archivo colores.py, tráeme la clase colores


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        plantilla = QVBoxLayout() #creo el layout

        #va a crear una caja horizontal con tantos cuadros color como le digamos
        plantilla.addWidget(colores("red"))
        plantilla.addWidget(colores("blue"))
        plantilla.addWidget(colores("yellow"))
        plantilla.addWidget(colores("green"))


        widget = QWidget() #crea un widget vacío que podemos utilizar como contenedor de otros elementos.
        widget.setLayout(plantilla)#metemos el layout que hemos creado (plantilla) dentro de windget
       
        self.setCentralWidget(widget)

        
      


      
        
    

   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



