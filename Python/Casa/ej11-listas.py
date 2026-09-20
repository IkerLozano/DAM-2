from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")


        lista = QListWidget() #cremos la lista
        lista.addItems(["Uno", "Dos", "Tres"]) #metemos las opciones la lista

        lista.currentTextChanged.connect(self.opciones) #cuando el texto de la opcion cambie llama a la funcion

        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection) #para poder elegir varias opciones de la lista

        self.setCentralWidget(lista)


    def opciones(self, texto):
        print(texto)

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()