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

        #WIDGETS######
        self.radio1 = QRadioButton("Pequeña")
        self.radio2 = QRadioButton("Mediana")
        self.radio3 = QRadioButton("Grande")
        self.check1 = QCheckBox("Queso")
        self.check2 = QCheckBox("Jamon")
        self.check3 = QCheckBox("Champiñon")

        textoMasa = QLabel("Masa")
        self.lista = QComboBox() 
        self.lista.addItems(["Fina", "Gorda", "Rellena"])
        textoUnidades = QLabel("Unidades")
        self.unidades = QSpinBox()
        self.unidades.setSuffix(" uds.") #le pongo texto al lado del numero
        self.boton1 = QPushButton("Calcular")
        self.boton2 = QPushButton("Reset")
        self.textoT = QLabel("Total: 0€")


        #PLANTILLAS######
            #plantillas de las cajas
        plantillaP1 = QHBoxLayout()
        plantilla1 = QVBoxLayout()
        plantilla2 = QVBoxLayout()

        plantilla1.addWidget(self.radio1)
        plantilla1.addWidget(self.radio2)
        plantilla1.addWidget(self.radio3)

        plantilla2.addWidget(self.check1)
        plantilla2.addWidget(self.check2)
        plantilla2.addWidget(self.check3)

            #plantillas de lo demas
        plantillaP2 = QVBoxLayout()
        plantilla3 = QHBoxLayout()
        plantilla4 = QHBoxLayout()
        plantilla5 = QHBoxLayout()

        
        plantilla3.addWidget(textoMasa)
        plantilla3.addWidget(self.lista, 1) #el 1 es para que ocupe todo el esapcio disponible
        plantilla4.addWidget(textoUnidades)
        plantilla4.addWidget( self.unidades, 1)
        plantilla5.addWidget( self.boton1)
        plantilla5.addWidget(self.boton2)

        

        #GRUPOS#####
        grupo1 = QGroupBox("Tamaño") #creo el grupo
        grupo2 = QGroupBox("Ingedientes")

        grupo1.setLayout(plantilla1) #meto la plantilla de los botones dentro del grupo
        grupo2.setLayout(plantilla2) #meto la plantilla de las opciones dentro del grupo

        plantillaP1.addWidget(grupo1) #en la plantilla padre meto los 2 grupos
        plantillaP1.addWidget(grupo2)


        #añado las demas plantillas
        plantillaP2.addLayout(plantillaP1)
        plantillaP2.addLayout(plantilla3)
        plantillaP2.addLayout(plantilla4)
        plantillaP2.addLayout(plantilla5)
        plantillaP2.addWidget(self.textoT)

        plantillaP2.setSpacing(10)


        #CONFIGURACIONES#####
        self.radio2.setChecked(True)
        self.lista.setCurrentIndex(0)
        self.unidades.setValue(1)
        self.unidades.setRange(1, 10) #rango maximo y minimo
        self.textoT.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        
    


        #FUNCIONALIDAD#####
        self.boton1.clicked.connect(self.calcular)
        self.boton2.clicked.connect(self.borar)


       
        #lo muestro en la ventana
        widget = QWidget()
        widget.setLayout(plantillaP2)
        self.setCentralWidget(widget)



    def borar(self):
        self.radio2.setChecked(True)
        
        self.check1.setChecked(False)
        self.check2.setChecked(False)
        self.check3.setChecked(False)

        self.lista.setCurrentIndex(0)
        self.unidades.setValue(1)


    def calcular(self):
        precioF = 0
        tamaño = 0
        cantidad = self.unidades.value()
        

        if (self.radio1.isChecked()):
            tamaño = 6
        elif(self.radio2.isChecked()):
            tamaño = 8
        elif(self.radio3.isChecked()):
            tamaño = 10


        if (self.check1.isChecked()):
           precioF+=1
        if(self.check2.isChecked()):
           precioF+=1
        if(self.check3.isChecked()):
           precioF+=1

        if (self.lista.currentText() == "Gorda"):
            precioF+=1
        if(self.lista.currentText() == "Rellena"):
            precioF+=1
       
        precioF = (precioF+tamaño)*cantidad

        str(precioF)

        self.textoT.setText("Total: " + str(precioF) + "€")

        if(precioF > 50):
            dlg = QMessageBox(self) #creo el dialog 
            dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
            dlg.setText("El pedido es de " + str(precioF) +  "€, ¿confirmas?") #mensaje de la ve
            
            #le digo los botones que quiero
            dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
            dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono
            
            #segun la respuesta mando un mensaje
            if dlg.exec() == QMessageBox.StandardButton.Yes:
                 self.textoT.setText("Pedido confirmado")
            else:
                self.radio2.setChecked(True)

                self.check1.setChecked(False)
                self.check2.setChecked(False)
                self.check3.setChecked(False)

                self.lista.setCurrentIndex(0)
                self.unidades.setValue(1)
        


app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        