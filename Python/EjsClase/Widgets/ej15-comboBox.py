from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #-----18/09/26-----

        self.setWindowTitle("Mi aplicacion")


        lista = QComboBox() #creamos el comboBox
        lista.addItems(["Uno", "Dos", "Tres"]) #opciones
        lista.addItems(["Cuatro"]) #añadir un algo a la lista de opciones
        lista.setEditable(True) #hace que puedas editar elelemento de la lista

        lista.currentIndexChanged.connect(self.muestraIndice) #recoger el indice cuando cambie y llamara a su funcion correspondiente
        lista.currentTextChanged.connect(self.muestraTexto) #recoger el texto cuando cambie

    
        self.setCentralWidget(lista)


    def muestraIndice(self, indice):
        print(indice)

    def muestraTexto(self, texto): 
        print(texto)

         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

