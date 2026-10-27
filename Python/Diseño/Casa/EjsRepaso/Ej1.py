from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QMessageBox, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDateEdit,
    QTextEdit, 
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon




class miVentana(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #WIDGETS####
        texto = QLabel("Resgistro")
        textoUser = QLabel("Usuario")
        self.uaurio = QLineEdit()
        self.casilla = QCheckBox("Acepto las condiciones")
        self.boton =QPushButton("Boton no pulsado")
        self.texto2 = QLabel("Texto actual:....")


        #FORMATO DEL TEXTO#####
        formato = texto.font() #nos da acceso a los formatos

        formato.setPointSize(20) #tamaño
        formato.setFamily("Aial") #tipo de letra

        texto.setFont(formato) #aplicamos todas las configuraciones
        texto.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
        self.texto2.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal


        #FUNCIONALIDAD#####
        self.uaurio.textChanged.connect(self.mostrar)
        self.casilla.stateChanged.connect(self.muestraEstado)
        self.boton.clicked.connect(self.estadoBoton)
        self.uaurio.returnPressed.connect(self.intro) 



        #OTRAS CONFG#####
        self.uaurio.setMaxLength(10) #el max de caracteres de la linea

        self.boton.setChecked(True) #hace que empiece desmarcado.
        self.boton.setEnabled(False)#Empieza desactivado
        self.boton.setCheckable(True) #como si fuera un interruptor


        #PLANTILLAS#####
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()

        plantilla1.addWidget(textoUser)
        plantilla1.addWidget(self.uaurio)

        plantillaP.addWidget(texto)
        plantillaP.addLayout(plantilla1)
        plantillaP.addWidget(self.casilla)
        plantillaP.addWidget(self.boton)
        plantillaP.addWidget(self.texto2)


        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)



    def mostrar(self):
        self.texto2.setText("Texto actual: " + self.uaurio.text())

    def intro(self):
        self.texto2.setText("Has enviado: " + self.uaurio.text())


    def muestraEstado(self, estado):
        self.boton.setEnabled(estado == 2)
        print(f"{["Casilla 0", "", "Casilla 2"][estado]}")


    def estadoBoton(self, estado):
        self.boton.setText(["No pulsado", "Pulsado"][estado])

        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        