from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        label = QLabel()#sirve para mostar contenido, en este caso una foto
        label.setPixmap(QPixmap("img\Captura de pantalla 2026-09-16 205952.png")) #poner la imagen
        label.setScaledContents(True)#Para q sea responsiva con el tamaño de la pantaña

        self.setCentralWidget(label)



app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()