from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QMessageBox, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDateEdit,
    QTextEdit, 
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialogs import CustomDialog # Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        #WIDGETS#####
        self.texto = QLabel()
        self.boton0 = QPushButton("0")
        self.boton1 = QPushButton("1")
        self.boton2 = QPushButton("2")
        self.boton3 = QPushButton("3")
        self.boton4 = QPushButton("4")
        self.boton5 = QPushButton("5")
        self.boton6 = QPushButton("6")
        self.boton8 = QPushButton("8")
        self.boton7 = QPushButton("7")
        self.boton9 = QPushButton("9")
        self.botonSuma = QPushButton("+")
        self.botonIgual = QPushButton("=")
        self.botonCE = QPushButton("CE")


        #PLANTILLAS####
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QHBoxLayout()
        plantilla3 = QHBoxLayout()
        plantilla4 = QHBoxLayout()

        plantilla1.addWidget(self.boton7)
        plantilla1.addWidget(self.boton8)
        plantilla1.addWidget(self.boton9)
        plantilla2.addWidget(self.boton4)
        plantilla2.addWidget(self.boton5)
        plantilla2.addWidget(self.boton6)
        plantilla3.addWidget(self.boton1)
        plantilla3.addWidget(self.boton2)
        plantilla3.addWidget(self.boton3)
        plantilla4.addWidget(self.botonSuma)
        plantilla4.addWidget(self.boton0)
        plantilla4.addWidget(self.botonIgual)

        plantillaP.addWidget(self.texto)
        plantillaP.addLayout(plantilla1)
        plantillaP.addLayout(plantilla2)
        plantillaP.addLayout(plantilla3)
        plantillaP.addLayout(plantilla4)
        plantillaP.addWidget(self.botonCE)


        #MUESTRO TODO######
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)


        #LLAMO A LAS FUNCIONES####
        self.boton0.clicked.connect(self.numeros)
        self.boton1.clicked.connect(self.numeros)
        self.boton2.clicked.connect(self.numeros)
        self.boton3.clicked.connect(self.numeros)
        self.boton4.clicked.connect(self.numeros)
        self.boton5.clicked.connect(self.numeros)
        self.boton6.clicked.connect(self.numeros)
        self.boton7.clicked.connect(self.numeros)
        self.boton8.clicked.connect(self.numeros)
        self.boton9.clicked.connect(self.numeros)
        self.botonSuma.clicked.connect(self.suma)
        self.botonIgual.clicked.connect(self.igual)
        self.botonCE.clicked.connect(self.reset)
    



    def numeros(self):
        boton = self.sender() #obtiene el botón que ha llamado a la función.
        self.texto.setText(self.texto.text() + boton.text()) #cada vez que pulso añade el texto del boton
        #self.texto.append(self.boton7.text())

    def suma(self):
        self.num1 = int(self.texto.text()) #guardo el valor del num1 antes de darle a +
        self.texto.clear()

    def igual(self):
        self.num2 = int(self.texto.text()) #guardo el valor del num2 antes de darle a =
        self.texto.clear()
        resultado = self.num1+self.num2
        self.texto.setText(str(resultado))

    def reset(self):
        self.texto.clear()
        self.num1 = 0
        self.num2 = 0

        
#setText → Borra lo que hubiera y pone ese texto. Sustituye todo el contenido. 
#append → Añade el texto al final, en una línea nueva, sin borrar lo anterior (solo acepta string)

#def textoCambiado(self):
#    self.cont = self.cont +1
#    self.texto.setText(f"Texto cambiado: {self.cont}")
#    #con setText le deciomos que cambie el contenido del texto 
#    #f"" --> Permite introducir variables dentro de un texto usando {}.



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        