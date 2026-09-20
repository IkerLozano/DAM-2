from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        lista = QComboBox() #creamos la lista de opciones

        lista.addItems(["Uno", "Dos", "Tres"]) #ponemos las opciones de la lista
        lista.addItems(["Nuevo"]) #podemos añadir mas opciones a la lista
        lista.setEditable(True) #hace que podamos editar las opciones desde la propia lista

        lista.currentIndexChanged.connect(self.indice) #recoger el indice cuando cambie y llamara a su funcion correspondiente
        lista.currentTextChanged.connect(self.texto)  #recoger el texto cuando cambie y llamara a su funcion correspondiente


        self.setCentralWidget(lista)


    def indice(self, indice): #el indice empieza desde el 0
        print(indice)


    def texto(self, texto):
        print(texto)



app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
