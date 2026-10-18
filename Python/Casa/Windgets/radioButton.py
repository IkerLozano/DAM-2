
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QRadioButton,
    QLabel, QVBoxLayout
)
from PyQt6.QtCore import Qt


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Venatana")


        self.etiqueta = QLabel("Selecciona un lenguaje")

        self.radioJava = QRadioButton("Java")
        self.radioPython = QRadioButton("Python")

        self.radioJava.toggled.connect(self.seleccionar)
        self.radioPython.toggled.connect(self.seleccionar)

        plantilla = QVBoxLayout()
        plantilla.addWidget(self.etiqueta)
        plantilla.addWidget(self.radioJava)
        plantilla.addWidget(self.radioPython)

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)


        

    def seleccionar(self):
        if self.radioJava.isChecked():
            self.etiqueta.setText("Has seleccionado Java")
        elif self.radioPython.isChecked():
            self.etiqueta.setText("Has seleccionado Python")


app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
