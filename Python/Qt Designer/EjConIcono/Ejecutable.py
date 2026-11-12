from Ej_Icono import Ui_MainWindow
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


app = QApplication([])


app.setStyle("Fusion") #estilo para la ventana
with open("EjConIcono/estilos.qss", "r") as f :
    app.setStyleSheet(f.read())


ventana = MainWindow()
app.exec()