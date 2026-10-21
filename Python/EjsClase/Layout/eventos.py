from PyQt6.QtWidgets import QMainWindow, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        self.etiqueta = QLabel("Pulsa aquí")
        self.setCentralWidget(self.etiqueta)

    # En todos los widgets se aplican estas funciónes
    def mouseMoveEvent(self, e):
        self.etiqueta.setText("Has pulsado y arrastrado el ratón")

    def mousePressEvent(self, e):
        self.etiqueta.setText("Has pulsado el ratón")

    #def mouseReleaseEvent(self, e):
    #    self.etiqueta.setText("Has soltado el ratón")

    def mouseDoubleClickEvent(self, e):
            self.etiqueta.setText("Has hecho doble click")


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
