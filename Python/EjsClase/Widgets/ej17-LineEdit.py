from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #-----18/09/26-----

        self.setWindowTitle("Mi aplicacion")


        self.texto = QLineEdit()
        self.texto.setMaxLength(10) #el max de caracter que va a poder introducir
        self.texto.setPlaceholderText("Introduce tu nombre") #texto que sale por defecto 

        self.texto.textChanged.connect(self.textoCambiado) #cuando cambie el texto se ejecuta la funcion
        #self.texto.returnPressed.connect(self.introPulsado) #cunado pulsemos el intro

    
        self.setCentralWidget(self.texto)


    def textoCambiado(self, nombre): 
        print(nombre)


    def introPulsado(self):
        print("Mensaje enviado")
        print(self.texto.text())

         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

