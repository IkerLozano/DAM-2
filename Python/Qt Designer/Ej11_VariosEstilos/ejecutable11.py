from Ej11 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        self.comboBox.currentIndexChanged.connect(self.estilos)


    def estilos(self, e):
        with open(f"Ej11_VariosEstilos/estilo{e+1}.qss", "r") as f :
            app.setStyleSheet(f.read())
    


app = QApplication([])
app.setStyle("Fusion") #estilo para la ventana
with open(f"Ej11_VariosEstilos/estilo2.qss", "r") as f :  #para el estilo por defecto
            app.setStyleSheet(f.read())

ventana = MainWindow()
app.exec()