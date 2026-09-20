from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget  #importamos las librerias
from PyQt6.QtCore import Qt


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #-----18/09/26-----

        self.setWindowTitle("Mi aplicacion")

        label = QLabel("Hola")
        formato = label.font() #creamos el elemento sobre la etiqueta label
        formato.setPointSize(30) #tamaño
        formato.setFamily("Aial") #tipo de letra
        formato.setBold(True) #negrita o no
        label.setFont(formato) #todo el formato que hemos puesto se lo aplicamos
        label.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal


        self.setCentralWidget(label)

         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

