from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QMessageBox, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDateEdit,
    QTextEdit, 
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from color import color # Del archivo color.py, tráeme la clase Color





class miVentana(QMainWindow):
    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #WIDGETS#######
        sliderTexto = QLabel("Slider")
        self.slider = QSlider(Qt.Orientation.Horizontal)
        spinBoxTexto = QLabel("SpinBox")
        self.spinBox = QSpinBox()
        self.dial = QDial() 
        self.dial.setNotchesVisible(True) #para ver las muescas
        self.lista = QListWidget() 
        self.lista.addItems(["Uno", "Dos", "Tres"]) #metemos opciones
        self.texto1slider = QLabel("Valor slider: - ")
        self.texto1spinBox = QLabel("Valor spinBox: - ")
        self.texto1dial = QLabel("Valor dial: - ")
        self.texto2 = QLabel("Selecionados: Ninguno")



        #PLANTILLAS########
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla1A = QVBoxLayout()
        plantilla1B = QHBoxLayout()
        plantilla2B = QHBoxLayout()
        plantilla3 = QHBoxLayout()
       

        plantilla1.addWidget(spinBoxTexto)
        plantilla1.addWidget(self.spinBox, 1)
        plantilla1B.addWidget(self.dial)
        plantilla3.addWidget(sliderTexto)
        plantilla3.addWidget(self.slider)
        

        plantilla2B.addLayout(plantilla1B)
        plantilla1B.addLayout(plantilla1A)

        
        plantilla1A.addLayout(plantilla1)
        plantilla1A.addWidget(self.lista)
        plantilla2B.addLayout(plantilla1A)
        plantilla2B.addLayout(plantilla1B)

        plantillaP.addLayout(plantilla3)
        plantillaP.addLayout(plantilla2B)
        plantillaP.addWidget(self.texto1slider)
        plantillaP.addWidget(self.texto1spinBox)
        plantillaP.addWidget(self.texto1dial)
        plantillaP.addWidget(self.texto2)


        #CONFIGURACIONES#####
        self.texto1slider.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
        self.texto1spinBox.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
        self.texto1dial.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        
        self.texto2.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        self.spinBox.setRange(-10, 10)
        self.spinBox.setValue(0)
        self.spinBox.setSuffix(" pts")
        self.spinBox.setSingleStep(2)



        #FUNCIONALIDAD####
        self.slider.sliderMoved.connect(self.movimiento1)
        self.spinBox.valueChanged.connect(self.movimiento2)
        self.dial.valueChanged.connect(self.movimiento3)
        self.lista.currentTextChanged.connect(self.movimiento4)

       


        #los muestro
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)


    def movimiento1(self, valor):
        self.texto1slider.setText("Valor slider: " + str(valor))
        print("Moviendo el slider: " + str(valor))


    def movimiento2(self, valor):
        self.texto1spinBox.setText("Valor spinBox: " + str(valor))


    def movimiento3(self, valor):
        self.texto1dial.setText("Valor dial: " + str(valor))


    def movimiento4(self, valor):
        self.texto2.setText("Selecionados: " + str(valor))


        

    
        





       
        


app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        