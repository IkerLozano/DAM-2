from PyQt6.QtWidgets import QRadioButton, QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ventana")



        self.texto = QLabel("Seleciona un lenguaje")

        self.radio1 = QRadioButton("Java")
        self.radio2 = QRadioButton("Python")

        plantilla = QVBoxLayout()

        plantilla.addWidget(self.texto)
        plantilla.addWidget(self.radio1)
        plantilla.addWidget(self.radio2)


        self.radio1.clicked.connect(self.mostrar)
        self.radio2.clicked.connect(self.mostrar)


        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)
        

    def mostrar(self):

        
        if self.radio1.isChecked():
            print("Has selccionado Java")
            self.texto.setText("Has selccionado Java")

        else:
            print("Has selccionado Python")
            self.texto.setText("Has selccionado Python")


    





app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()