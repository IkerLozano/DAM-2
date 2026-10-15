from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget #importamos las librerias


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        self.inputt = QLineEdit() #crea un campo de texto donde se puede escribir
        self.label = QLabel() #Sirve para mostrar texto

        #inputt.textChanged.connect(label.setText) #cuando escribamos en el input se pondra un label debajo con ese texto
        self.inputt.textChanged.connect(self.conectado)
        

        caja = QVBoxLayout() #creamos una caja donde los elemtos se colocan uno debajo de otro

        #ponemos el imput y el label dentro de la caja
        caja.addWidget(self.label)
        caja.addWidget(self.inputt)

        #metemos la caja en la ventana para que se muestre
        contenedor = QWidget() #Crea un widget que hará de contenedor
        contenedor.setLayout(caja) #metemos la caja dentro del contenedor
        self.setCentralWidget(contenedor) #ponemos el contedor en la ventana

    def conectado(self):
        self.label.setText(self.inputt.text())


app = QApplication([])


ventana = miVentana()
ventana.show()

app.exec()