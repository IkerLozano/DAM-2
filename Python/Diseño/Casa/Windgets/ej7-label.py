from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget  #importamos las librerias
from PyQt6.QtCore import Qt

class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")

        texto = QLabel("Hola") #sirve para mostar contenido, en este caso texto

        #formatos del texto
        formato = texto.font() #nos da acceso a los formatos

        formato.setPixelSize(30)#tamaño del texto
        formato.setFamily("Arial")#tipo de letra
        formato.setBold(True) #ponemos negrita 

        texto.setFont(formato) #aplicamos todas las configuracion
        texto.setAlignment(Qt.AlignmentFlag.AlignVCenter | Qt.AlignmentFlag.AlignHCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        self.setCentralWidget(texto)#mostramos el texto en la ventana




app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()