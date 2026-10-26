from PyQt6.QtWidgets import QMenu, QMainWindow, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Mi aplicación")

        self.texto = QLabel("Pulsa aquí")

        self.setCentralWidget(self.texto)


    
    def contextMenuEvent(self, event): #Gestiona el evento

        menu = QMenu(self) #Crea un menú contextual (es un menú que aparece al hacer clic derecho con el ratón y muestra opciones)
        #El self es para referirnos a que pertenecen estar en la ventana padre


        #Añado opciones al menu
        menu.addAction(QAction("Accion 1", self)) 
        menu.addAction(QAction("Accion 2", self))
        menu.addAction(QAction("Accion 3", self))
        menu.addAction(QAction("Accion 4", self))
        
        menu.exec(event.globalPos()) #Muestra el menú

         


        

   


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
