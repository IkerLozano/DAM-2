from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget #importamos las librerias


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        label = QLabel()
        input = QLineEdit()

        input.textChanged.connect(label.setText) #cada vez que escribamos en el inpult se pondra en el label

        layout = QVBoxLayout() #caja vertical

        #le metemos los dos widgets q hemos creado arriba
        layout.addWidget(input) 
        layout.addWidget(label)

        contenedor = QWidget()
        contenedor.setLayout(layout)

        self.setCentralWidget(contenedor)

    


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

