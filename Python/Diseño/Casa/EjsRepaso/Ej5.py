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
        self.setFixedSize(QSize(400,200)) #tamaño fijo de la ventan



        #WIDGETS######
        rojo = QPushButton("Rojo")
        verde = QPushButton("Verde")
        amarillo = QPushButton("Amarillo")
        azul = QPushButton("Azul")
        self.texto = QLabel("Todavia no has pulsado nada")


        #PLANTILLAS####
            #plantilla pra lod botones de grid
        plantillaG = QGridLayout()
        plantillaG.addWidget(rojo, 0,0)
        plantillaG.addWidget(verde, 0,1)
        plantillaG.addWidget(amarillo, 1,1)
        plantillaG.addWidget(azul, 2,0)

            #plantilla para el color
        plantillaColor = QStackedLayout()

        
            #plantilla para texto
        plantillaT = QVBoxLayout()
        plantillaT.addWidget(self.texto)


        plantillaP1 = QHBoxLayout() #aqui va los botones y el color
        plantillaP2 = QVBoxLayout() #aqui va el texto y la plantillaP1
        
        plantillaP2.addLayout(plantillaP1)
        plantillaP2.addWidget(self.texto)


        #GRUPOS#####
        grupo1 = QGroupBox("Botones") #creo el grupo
        grupo2 = QGroupBox("Color")

        grupo1.setLayout(plantillaG) #meto la plantilla de los botones dentro del grupo
        grupo2.setLayout(plantillaColor) #meto la plantilla de los colores dentro del grupo

        plantillaP1.addWidget(grupo1) #en la plantilla padre meto los 2 grupos
        plantillaP1.addWidget(grupo2)


        #CONFIGURACIONES
        self.texto.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal


        #FUNCIONALIDAD
        plantillaColor.addWidget(color("red")) #0
        plantillaColor.addWidget(color("green")) #1
        plantillaColor.addWidget(color("yellow")) #2
        plantillaColor.addWidget(color("blue")) #3

        plantillaColor.setCurrentIndex(0)


        rojo.pressed.connect(lambda: plantillaColor.setCurrentIndex(0))
        rojo.pressed.connect(lambda: self.texto.setText("Has pulsado: Rojo"))

        verde.pressed.connect(lambda: plantillaColor.setCurrentIndex(1))
        verde.pressed.connect(lambda: self.texto.setText("Has pulsado: Verde"))

        amarillo.pressed.connect(lambda: plantillaColor.setCurrentIndex(2))
        amarillo.pressed.connect(lambda: self.texto.setText("Has pulsado: Amarillo"))

        azul.pressed.connect(lambda: plantillaColor.setCurrentIndex(3))
        azul.pressed.connect(lambda: self.texto.setText("Has pulsado: Azul"))

    

       

        #los muestro
        widget = QWidget()
        widget.setLayout(plantillaP2)
        self.setCentralWidget(widget)


       
        


app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        