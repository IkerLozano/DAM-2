from Ej4 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

     

        self.comboBox.currentIndexChanged.connect(self.cambiar)


    def cambiar(self, i):
        tema = ["Fusion", "Windows", "Windowsvista"] #el de macOS no funciona aqui
        app.setStyle(tema[i])

        #segun el valor de la lista(0,1,2) cogera uno de la lista tema(0,1,2)
    
    


app = QApplication([])

app.setStyle("Fusion") #estilo para la ventana por defecto

with open("Estilos.qss", "r") as f :
    app.setStyleSheet(f.read())


ventana = MainWindow()
app.exec()


#para que el dial tenga las muescas la opcion se llama "notchesVisible"