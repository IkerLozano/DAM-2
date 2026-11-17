from Ej1 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication, QStyle
from PyQt6.QtCore import QSize


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)


        #PONER UN BOTON CON ICONO
        # Obtener un icono de Qt
        icono = self.style().standardIcon(QStyle.StandardPixmap.SP_MessageBoxCritical)

        # Ponerlo en el botón
        self.pushButton.setIcon(icono)

        # Tamaño del icono
        self.pushButton.setIconSize(QSize(40, 40))

        self.show()

        self.comboBox.currentIndexChanged.connect(self.estilos)
        self.comboBox_2.currentIndexChanged.connect(self.cambiar)


    def estilos(self, e): #'e es el indice de la opcion seleccionada'
        with open(f"Estilos{e+1}.qss", "r") as f : #uno 'e+1' porque los índices del ComboBox empiezan en 0
            app.setStyleSheet(f.read())

        #open -- abre un archivo.


    def cambiar(self, i):
        tema = ["Fusion", "Windows", "Windowsvista"] #el de macOS no funciona aqui
        app.setStyle(tema[i])



    
    


app = QApplication([])

app.setStyle("Fusion") #estilo para la ventana

with open("Estilos1.qss", "r") as f :
    app.setStyleSheet(f.read())


ventana = MainWindow()
app.exec()

#para poner el texto centrado es desde las opciones del QtDesigner