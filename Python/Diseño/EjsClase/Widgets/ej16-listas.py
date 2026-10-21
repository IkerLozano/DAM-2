from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #-----18/09/26-----

        self.setWindowTitle("Mi aplicacion")


        lista = QListWidget()
        lista.addItems(["Uno", "Dos", "Tres"])

        lista.currentTextChanged.connect(self.muestraTexto) #cuando el texto cambie se ejecuta la funcion

        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection) #para poder seleccionar vasras opciones de la lista

    
        self.setCentralWidget(lista)

    def muestraTexto(self, texto): 
        print(texto)

         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

