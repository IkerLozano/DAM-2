from Ej2 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()


app = QApplication([])
app.setStyle("Fusion") #estilo para la ventana
with open("Estilos/estilo1.qss", "r") as f :
    app.setStyleSheet(f.read())

ventana = MainWindow()
app.exec()