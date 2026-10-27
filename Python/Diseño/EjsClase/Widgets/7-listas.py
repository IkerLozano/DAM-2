from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        lista = QListWidget() #creamos la lista
        lista.addItems(["Uno", "Dos", "Tres"]) #metemos opciones a la lista
        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection) #para poder seleccionar vasras opciones de la lista
        lista.setCurrentRow(0) #opcion 0 marcada por defecto


        lista.currentTextChanged.connect(self.muestraTexto) #currentTextChanged -->  cuando el texto cambie


    
        self.setCentralWidget(lista)



    def muestraTexto(self, texto): 
        print(texto)

         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

