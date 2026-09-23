from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        self.texto = QLineEdit() #creamos la barra del texto
        self.texto.setMaxLength(10) #el max de caracteres de la linea
        self.texto.setPlaceholderText("Escribe aqui") #Placeholder

        self.texto.textChanged.connect(self.mostrar) #mostrar el texto conforme vayamos escribiendo
        #self.texto.returnPressed.connect(self.intro) #al darle intro llama a la funcion y nos muestra el mensaje

        self.setCentralWidget(self.texto)


    def mostrar(self, texto):
        print(texto)

    def intro(self):
        print("Mnesaje enviado:")
        print("-->", self.texto.text()) #el .text() devuelve el texto que hay dentro de la "caja" del texto



app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()