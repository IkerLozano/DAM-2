from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QTextEdit,
    QMessageBox, QMenu, QDateEdit
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialog import CustomDialog # Del archivo color.py, tráeme la clase Color





class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Agencia de viajes")

        #WIDGETS######
            #widgets de la pestaña1
        imagen = QLabel()
        titulo = QLabel("Viajes DAM")
        textoNombre = QLabel("Nombre")
        self.nombre = QLineEdit()
        textoApellidos = QLabel("Apellidos")
        self.appellido = QLineEdit()
        radio1 = QRadioButton("Aragon")
        radio2 = QRadioButton("C.Valenciana")
        self.listaCiudades = QComboBox()
        textoSalida = QLabel("Salida: ")
        salida = QDateEdit(QDate(2026, 11, 1))
        textoPersonas = QLabel("Personas: ")
        self.personas = QSpinBox()
        textoNoches = QLabel("Noches: ")
        self.noches = QSlider(Qt.Orientation.Horizontal)
        self.numNoches = QLabel()
        self.dial = QDial()
        self.textoDial =QLabel("0%")
        self.casilla1 = QCheckBox("Seguro")
        self.casilla2 = QCheckBox("Guia")
        self.casilla3 = QCheckBox("Comida")
        condiciones = QCheckBox("Acepto las condiciones")
        self.boton1 = QPushButton("Reservar")
        boton2 = QPushButton("Reset")
        self.textoTotal = QLabel("Total: 0€")

            #widgets de la pestaña2
        botonCliente = QPushButton("Cliente")
        botonViaje = QPushButton("Viaje")
        botonPrecio = QPushButton("Precio")
        self.textoGrande = QTextEdit()
        textoPestaña2 = QLabel("Mostrando: Cliente")


        #PLANTILLAS######

        #plantillas pestaña 1
            #plantillas generales
        plantillaP1 = QVBoxLayout() 

        plantilla1 = QHBoxLayout()

        plantilla2 = QVBoxLayout()
        plantilla2_1 = QHBoxLayout()

        plantilla3 = QVBoxLayout()
        plantilla3_1 = QHBoxLayout()
        plantilla3_2 = QHBoxLayout()
        plantilla2_3_contendor = QHBoxLayout()

        plantilla4 = QHBoxLayout()

        plantilla5 = QHBoxLayout()

        plantilla6 = QVBoxLayout()
        plantilla5_6_contendor = QHBoxLayout()

        plantilla7 = QHBoxLayout()



            #meto los widgets a sus plantillas
        plantilla1.addWidget(textoNombre)
        plantilla1.addWidget(self.nombre)
        plantilla1.addWidget(textoApellidos)
        plantilla1.addWidget(self.appellido)

        plantilla2_1.addWidget(radio1)
        plantilla2_1.addWidget(radio2)
        plantilla2.addLayout(plantilla2_1)
        plantilla2.addWidget(self.listaCiudades)

        plantilla3_1.addWidget(textoSalida)
        plantilla3_1.addWidget(salida)
        plantilla3_2.addWidget(textoPersonas)
        plantilla3_2.addWidget(self.personas, 1)
        plantilla3.addLayout(plantilla3_1)
        plantilla3.addLayout(plantilla3_2)

        plantilla4.addWidget(textoNoches)
        plantilla4.addWidget(self.noches)
        plantilla4.addWidget(self.numNoches)

        plantilla5.addWidget(self.dial)
        plantilla5.addWidget(self.textoDial)

        plantilla6.addWidget(self.casilla1)
        plantilla6.addWidget(self.casilla2)
        plantilla6.addWidget(self.casilla3)

        plantilla7.addWidget(self.boton1)
        plantilla7.addWidget(boton2)

       
            #meto las palntillas a la plantillaP1
        plantillaP1.addWidget(imagen)
        plantillaP1.addWidget(titulo)
        plantillaP1.addLayout(plantilla1)
        plantillaP1.addLayout(plantilla2_3_contendor)
        plantillaP1.addLayout(plantilla4)
        plantillaP1.addLayout(plantilla5_6_contendor)
        plantillaP1.addWidget(condiciones)
        plantillaP1.addLayout(plantilla7)
        plantillaP1.addWidget(self.textoTotal)


        #plantillas pestaña 2

          #plantillas generales
        plantillaP2 = QVBoxLayout()

        plantilla8 = QHBoxLayout()

            #meto los widgets a sus plantillas
        plantilla8.addWidget(botonCliente)
        plantilla8.addWidget(botonViaje)
        plantilla8.addWidget(botonPrecio)

            #meto las palntillas a la plantillaP2
        plantillaP2.addLayout(plantilla8)
        plantillaP2.addWidget(self.textoGrande)
        plantillaP2.addWidget(textoPestaña2)
      

        
        #GRUPO 1#####
        grupo1 = QGroupBox("Destino") #creo el grupo
        grupo2 = QGroupBox("Datos del viaje")

        grupo1.setLayout(plantilla2) #meto la plantilla de los botones dentro del grupo
        grupo2.setLayout(plantilla3) #meto la plantilla de las opciones dentro del grupo

        plantilla2_3_contendor.addWidget(grupo1) #en la plantilla padre meto los 2 grupos
        plantilla2_3_contendor.addWidget(grupo2)


        #GRUPO 2#####
        grupo1 = QGroupBox("Descuento") #creo el grupo
        grupo2 = QGroupBox("Extras")

        grupo1.setLayout(plantilla5) #meto la plantilla de los botones dentro del grupo
        grupo2.setLayout(plantilla6) #meto la plantilla de las opciones dentro del grupo

        plantilla5_6_contendor.addWidget(grupo1) #en la plantilla padre meto los 2 grupos
        plantilla5_6_contendor.addWidget(grupo2)
        

        #PESTAÑAS
        pestañas = QTabWidget() #permite organizar diferentes widgets en pestañas
        pestañas.setTabPosition(QTabWidget.TabPosition.North) #donde colocar las pestañas
        pestañas.setMovable(True) #si se pueden mover


        widget1 = QWidget()
        widget2 = QWidget()

        #meto las plantillas con su contenido
        widget1.setLayout(plantillaP1) #cada widget es como un nuevo menu, al que le añado el contenido
        widget2.setLayout(plantillaP2)

        #añado a la pestaña los menus
        pestañas.addTab((widget1), "Reserva")
        pestañas.addTab((widget2), "Resumen")


        #BARRA DE TAREAS
        barra = QToolBar() #creo la barra
        self.addToolBar(barra) #añado la barra a la ventana
        barra.setToolButtonStyle(Qt.ToolButtonStyle.ToolButtonTextBesideIcon)
        
        #les pongo icono y mensaje al passar el raton
        boton = QAction(QIcon("EjsRepaso\icons\zone-money.png"), "Guardar", self)
        boton2 = QAction(QIcon("EjsRepaso\icons\zones.png"), "Ver reservas", self)
        

            #mesanje inferior
        boton.setStatusTip("Guardar reserva")
        boton2.setStatusTip("Ver reservas")
        
        self.setStatusBar(QStatusBar(self)) #para q estos mensajes se muestren

            #añado los botones a la barra
        barra.addAction(boton)
        barra.addAction(boton2)
        


        #CONFIGURACIONES############
        formato = titulo.font() #nos da acceso a los formatos
        formato.setPointSize(20) #tamaño
        formato.setFamily("Aial") #tipo de letra
        formato.setBold(True)
        titulo.setFont(formato) #aplicamos todas las configuraciones
        titulo.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        imagen.setPixmap(QPixmap("img/avion2.jpg").scaled(200, 100))
        imagen.setScaledContents(True)

        self.nombre.setMaxLength(20)
        self.appellido.setMaxLength(20)
        self.nombre.setPlaceholderText("Escribe aqui")
        self.appellido.setPlaceholderText("Escribe aqui")

        radio1.setChecked(True)
        self.listaCiudades.addItems(["Huesca", "Zaragoza", "Teruel"])

        salida.setMinimumDate(QDate(2026, 11, 1))
        salida.setCalendarPopup(True)

        self.personas.setRange(1, 10)
        self.personas.setSuffix(" pers")

        self.noches.setRange(1, 7)
        self.noches.setValue(1)

        self.dial.setMinimum(0)
        self.dial.setMaximum(20)
        self.dial.setValue(0)
        self.dial.setNotchesVisible(True)

        self.boton1.setEnabled(False)

        self.textoTotal.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
        
        textoPestaña2.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

        self.textoGrande.setPlaceholderText("Sin reservas")


        #FUNCIONALIDAD#####
        condiciones.stateChanged.connect(self.activarBoton)

        radio1.clicked.connect(lambda:(self.listaCiudades.clear(), self.listaCiudades.addItems(["Huesca", "Zaragoza", "Teruel"]) ))
        radio2.clicked.connect(lambda:( self.listaCiudades.clear(), self.listaCiudades.addItems(["Castellón", "Valencia", "Alicante"]) ))

        self.precioXpersonaXnoche = 0
        self.listaCiudades.currentIndexChanged.connect(self.precios)

        self.dial.valueChanged.connect(self.cambioNumeros1)
        self.noches.valueChanged.connect(self.cambioNumeros2)

        self.boton1.clicked.connect(self.reservar)

    

        #LO MUESTRO TODO
        self.setCentralWidget(pestañas)

        

    #FUNCIONES######
    def activarBoton(self, estado):
        self.boton1.setEnabled(estado == 2)
        print("Casilla " + str(estado))
        #print(f"{["no pulsado", "", "pulsado"][estado]}")


    def cambioNumeros1(self, numero):
        self.textoDial.setText(str(numero) + "%")
        if(numero > 10):

            formato = self.textoDial.font() #nos da acceso a los formatos
            formato.setBold(True)
            self.textoDial.setFont(formato) #aplicamos todas las configuraciones

        elif(numero <= 10):
    
            formato = self.textoDial.font() #nos da acceso a los formatos
            formato.setBold(False)
            self.textoDial.setFont(formato) #aplicamos todas las configuraciones


    

    def cambioNumeros2(self, numero):
        self.numNoches.setText(str(numero) + " noches")
        

    def precios(self):

        if(self.listaCiudades.currentText() =="Huesca"):
            self.precioXpersonaXnoche = 50
           
        elif(self.listaCiudades.currentText() == "Zaragoza"):
            self.precioXpersonaXnoche = 60
            
            
        elif(self.listaCiudades.currentText() == "Teruel"):
            self.precioXpersonaXnoche = 55
            
            
        elif(self.listaCiudades.currentText() == "Castellón"):
            self.precioXpersonaXnoche = 45
           
            
        elif(self.listaCiudades.currentText() == "Valencia"):
            self.precioXpersonaXnoche = 65
        
            
        elif(self.listaCiudades.currentText() == "Alicante"):
            self.precioXpersonaXnoche = 70
            

    def reservar(self):
        if (self.nombre.text() == "" or self.appellido.text() == ""):
            
            dlg = QMessageBox(self) #creo el dialog 
            dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
            dlg.setText("Rellena nombre y apellidos") #mensaje de la ve
            
    
            dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono
            
            #segun la respuesta mando un mensaje
            if dlg.exec() == QMessageBox.StandardButton.Yes:
                print("El usuario ha aceptado")
            else:
                print("El usuario ha rechazado")

        else:
            dlg = QMessageBox(self) #creo el dialog 
            dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
            dlg.setText("¿Confirmas la reserva de " +  self.nombre.text() + " " +  self.appellido.text() + " a " + self.listaCiudades.currentText() + "?") #mensaje de la ve
            
            dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
            dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono
            
            #segun la respuesta mando un mensaje
            if dlg.exec() == QMessageBox.StandardButton.Yes:

                NumNoches = self.noches.value()
                numPersonas = self.personas.value()
                valorDescuento = self.dial.value()
                precioSD = 0
                descuento = 0
                precioTotal = 0

                precioSD = self.precioXpersonaXnoche * NumNoches * numPersonas

                if (self.casilla1.isChecked()):
                    precioSD = precioSD+5
                if (self.casilla2.isChecked()):
                    precioSD = precioSD+5
                if (self.casilla3.isChecked()):
                    precioSD = precioSD+5


                
                descuento = precioSD * valorDescuento/100
                precioTotal = precioSD -descuento

            
                self.textoTotal.setText(str(precioTotal))

                self.textoGrande.append(self.nombre.text() + " " + self.nombre.text() + " - " + self.listaCiudades.currentText() + " - " + str(self.personas.value()) + "pers.")
    


                
            else:
                print("El usuario ha rechazado")


        
       
           
        
      

        



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()