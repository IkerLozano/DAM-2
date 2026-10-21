from PyQt6.QtWidgets import QMainWindow, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Mi aplicación")

        self.texto = QLabel("Pulsa aquí")

        self.setCentralWidget(self.texto)

    
    def mouseMoveEvent(self, a0):
        self.texto.setText("Has pulsado y arrastrado")

    def mousePressEvent(self, a0):
        self.texto.setText("Has pulsado encima")

    def mouseReleaseEvent(self, a0):
        self.texto.setText("Has soltado el raton")

    def mouseDoubleClickEvent(self, a0):
        self.texto.setText("Has dado doble clik")


        

   


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
