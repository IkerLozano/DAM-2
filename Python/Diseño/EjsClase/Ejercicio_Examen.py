from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QSpinBox, QGroupBox, 
    QTextEdit, QDateEdit, QTabWidget, QStatusBar, QToolBar, QMessageBox, QMenu
)   
from PyQt6.QtCore import QDate
from PyQt6.QtGui import QAction, QIcon


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("My app")


        #WIDGETS#####
        self.textoElemento = QLabel("Elemento a añadir")
        self.elemento = QLineEdit()
        botonAñadir = QPushButton("Añadir")
        self.lista = QComboBox()
        botonBorrar = QPushButton("Borrar todo")

        self.boton1 = QPushButton("1")
        self.boton2 = QPushButton("2")
        self.boton3 = QPushButton("3")
        self.botonA = QPushButton("A")
        self.botonB = QPushButton("B")
        self.botonC = QPushButton("C")

        self.lineaResultados = QLineEdit()

        self.radio1 = QRadioButton("A")
        self.radio2 = QRadioButton("B")
        self.radio3 = QRadioButton("C")
        self.check1 = QCheckBox("1")
        self.check2 = QCheckBox("2")
        self.check3 = QCheckBox("3")
        self.textoGrande = QTextEdit()

        self.fecha = QDateEdit()
        self.lineEditFecha = QLineEdit()

        self.numeros = QSpinBox()
        self.lineEditNumeros = QLineEdit()


        #PLANTILLAS#####
            #plantillas generales
        plantillaP = QVBoxLayout()
        plantillaP2 = QVBoxLayout()

        plantilla1 = QHBoxLayout()

        plantilla2 = QVBoxLayout() 
        plantilla2_1 = QHBoxLayout()
        plantilla2_2 = QHBoxLayout()

        plantilla4 = QHBoxLayout()
        plantilla4_1 = QVBoxLayout()
        plantilla4_2 = QVBoxLayout()
        plantilla4_3 = QHBoxLayout()

        plantilla5 = QHBoxLayout()

        plantilla6 = QHBoxLayout()


            #meto los widgets a su plantilla
        plantilla1.addWidget(self.textoElemento)
        plantilla1.addWidget(self.elemento)
        plantilla1.addWidget(botonAñadir)
        plantilla1.addWidget(self.lista)
        plantilla1.addWidget(botonBorrar)

        plantilla2_1.addWidget(self.boton1)
        plantilla2_1.addWidget(self.boton2)
        plantilla2_1.addWidget(self.boton3)
        plantilla2_2.addWidget(self.botonA)
        plantilla2_2.addWidget(self.botonB)
        plantilla2_2.addWidget(self.botonC)
        plantilla2.addLayout(plantilla2_1)
        plantilla2.addLayout(plantilla2_2)

        plantilla4_1.addWidget(self.radio1)
        plantilla4_1.addWidget(self.radio2)
        plantilla4_1.addWidget(self.radio3)
        plantilla4_2.addWidget(self.check1)
        plantilla4_2.addWidget(self.check2)
        plantilla4_2.addWidget(self.check3)
        plantilla4_3.addWidget(self.textoGrande)
        plantilla4.addLayout(plantilla4_1)
        plantilla4.addLayout(plantilla4_2)
        plantilla4.addLayout(plantilla4_3)

        plantilla5.addWidget(self.fecha)
        plantilla5.addWidget(self.lineEditFecha)

        plantilla6.addWidget(self.numeros)
        plantilla6.addWidget(self.lineEditNumeros)

       
        #GRUPOS#####
        grupo1 = QGroupBox("Ejercicio 1")
        grupo2 = QGroupBox("Ejercicio 2")

        grupo1.setLayout(plantilla1)
        grupo2.setLayout(plantilla2)

        plantillaP.addWidget(grupo1)
        plantillaP.addWidget(grupo2)



        #PESTAÑAS######
        pestañas = QTabWidget() 
        pestañas.setTabPosition(QTabWidget.TabPosition.North) 
       

        widget1 = QWidget()
        widget2 = QWidget()

       
        widget1.setLayout(plantilla5)
        widget2.setLayout(plantilla6)

    
        pestañas.addTab((widget1), "Pestaña 1")
        pestañas.addTab((widget2), "Pestaña 2")


        #METO LAS PLANTILLA A LA PLANTILLAP##############
        plantillaP.addWidget(self.lineaResultados)
        plantillaP.addLayout(plantilla4)
        plantillaP.addLayout(plantilla5)
        plantillaP.addLayout(plantilla6)
        plantillaP.addWidget(pestañas)


        #SUBMENU##############
        barra = QToolBar()
        self.addToolBar(barra) 

          
        boton = QAction(QIcon("icons/disk.png"), "Accion", self)
        
           
        boton.setStatusTip("Pulsa para ejecutar la accion")
        self.setStatusBar(QStatusBar(self)) 

           
        barra.addAction(boton)



        #MENU SUPERIOR##############
            
        menu = self.menuBar()

            
        menu_archivo = menu.addMenu("&Archivo")


        menu_archivo.addAction(boton)


        #FUNCIONALIDAD##############
        botonAñadir.clicked.connect(self.meterLista)
        botonBorrar.clicked.connect(self.borarLista)

        self.boton1.clicked.connect(self.meterNumerosYletras)
        self.boton2.clicked.connect(self.meterNumerosYletras)
        self.boton3.clicked.connect(self.meterNumerosYletras)
        self.botonA.clicked.connect(self.meterNumerosYletras)
        self.botonB.clicked.connect(self.meterNumerosYletras)
        self.botonC.clicked.connect(self.meterNumerosYletras)


        self.radio1.toggled.connect(self.meterNumerosYletras3)
        self.radio2.toggled.connect(self.meterNumerosYletras3)
        self.radio3.toggled.connect(self.meterNumerosYletras3)
        self.check1.stateChanged.connect(self.meterNumerosYletras2)
        self.check2.stateChanged.connect(self.meterNumerosYletras2)
        self.check3.stateChanged.connect(self.meterNumerosYletras2)

        self.fecha.dateChanged.connect(self.dia)

        self.numeros.valueChanged.connect(self.numerosFuncion)

        self.cont = 0
        boton.triggered.connect(self.dialogo)
          

          

        #CONFIGURACIONES#####
        self.fecha.setCalendarPopup(True)
        self.fecha.setMinimumDate(QDate(2010,1,1))

        self.numeros.setRange(0, 100)
        self.numeros.setSingleStep(2)

        self.lineaResultados.setPlaceholderText("Aqui se mostraran los resultados")




        #LO MUESTRO####
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)

        


    #FUNCIONES
    def meterLista(self):
        texto = self.elemento.text()
        self.lista.addItems([texto])

    def borarLista(self):
        self.lista.clear()


    def meterNumerosYletras(self):
        texto = (f"{self.sender().text()}")
        self.lineaResultados.setText(texto)

    def meterNumerosYletras2(self, estado):
        self.textoGrande.append(f"{self.sender().text()} {["no marcado", "", "marcado"][estado]} ")

    def meterNumerosYletras3(self, estado):
        self.textoGrande.append(f"{["Desmarco", "Marco"][estado]} {self.sender().text()}")


    def dia(self):
        self.lineEditFecha.setText(self.fecha.text())


    def numerosFuncion(self):
        self.lineEditNumeros.setText(str(self.numeros.value()))



    def dialogo(self):
        self.cont = self.cont + 1

        dlg = QMessageBox(self) 
        dlg.setWindowTitle("Cuadro de mensaje")
        dlg.setText("Este cuadro de dialogo se a mostrado " + str(self.cont) + " veces. Si quieres cerra la apliccacion pulsa Yes")
        
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
   
        
        
        if dlg.exec() == QMessageBox.StandardButton.Yes:
            app.closeAllWindows()



    def contextMenuEvent(self, event):

        menu = QMenu(self)


        self.ac1 = QAction("Accion 1", self)

        menu.addAction(self.ac1)
        
        self.ac1.triggered.connect(self.dialogo)

        menu.exec(event.globalPos())



           


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()