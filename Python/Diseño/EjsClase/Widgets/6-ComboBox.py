from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

    
        lista = QComboBox() #creaR el comboBox
        lista.addItems(["Uno", "Dos", "Tres"]) #ponemos opciones
        lista.addItems(["Cuatro"]) #añadir un algo a la lista de opciones
        lista.setEditable(True) #hace que podamos editar las opciones desde la propia lista

        lista.currentIndexChanged.connect(self.muestraIndice) #currentIndexChanged -->  cuando el índice cambie (el índice empieza desde el 0)
        lista.currentTextChanged.connect(self.muestraTexto)  #currentTextChanged -->  cuando el texto cambie

    
        self.setCentralWidget(lista)



    def muestraIndice(self, indice):
        print(indice)

    def muestraTexto(self, texto): 
        print(texto)

         
#para recoger texto --> .currentText() --> str
#                   --> .currentIndex() --> int

#para borar texto --> .setCurrentIndex(0) --> vuelve a la opcion 0


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

