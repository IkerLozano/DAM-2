from PyQt6.QtWidgets import QMainWindow, QMenu, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
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
    def contextMenuEvent(self, event):
        context = QMenu(self)
        context.addAction(QAction("Acción 1",self))
        context.addAction(QAction("Acción 2",self))
        context.addAction(QAction("Acción 3",self))
        context.exec(event.globalPos())



# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
