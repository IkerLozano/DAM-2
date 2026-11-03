from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QTextEdit,
    QMessageBox, QMenu, QDateEdit, 
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialog import CustomDialog # Del archivo color.py, tráeme la clase Color





class MainWindow(QMainWindow):

    

    def __init__(self):
        super().__init__()

        itemsTierra = ["Bocata Jamón Serrano", "Cocido de Ternera", "Tentempié"]
        itemsMar = ["Yogur Marinado Griego", "Ensaladilla"]
        
        self.setWindowTitle("Repaso general de Interfaces")
        self.setFixedWidth(500)
        

            # #CONFIGURACIONES############
            # formato = titulo.font() #nos da acceso a los formatos
            # formato.setPointSize(20) #tamaño
            # formato.setFamily("Aial") #tipo de letra
            # formato.setBold(True)
            # titulo.setFont(formato) #aplicamos todas las configuraciones
            # titulo.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

            # imagen.setPixmap(QPixmap("img/avion2.jpg").scaled(200, 100))
            # imagen.setScaledContents(True)

            # self.nombre.setMaxLength(20)
            # self.appellido.setMaxLength(20)
            # self.nombre.setPlaceholderText("Escribe aqui")
            # self.appellido.setPlaceholderText("Escribe aqui")

            # radio1.setChecked(True)
            # self.listaCiudades.addItems(["Huesca", "Zaragoza", "Teruel"])

            # salida.setMinimumDate(QDate(2026, 11, 1))
            # salida.setCalendarPopup(True)

            # self.personas.setRange(1, 10)
            # self.personas.setSuffix(" pers")

            # self.noches.setRange(1, 7)
            # self.noches.setValue(1)

            # self.dial.setMinimum(0)
            # self.dial.setMaximum(20)
            # self.dial.setValue(0)
            # self.dial.setNotchesVisible(True)

            # self.boton1.setEnabled(False)

            # self.textoTotal.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
            
            # textoPestaña2.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal

            # self.textoGrande.setPlaceholderText("Sin reservas")
        
        
        # Declarar el layout vertical principal
        vLayout = QVBoxLayout()

        #Barra de herramientas
        barra = QToolBar("Barra de herramientas")
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)
        
        boton = QAction(QIcon("Ejercicios/icons/disk.png"),"Guardar archivo",self)
        boton.setStatusTip("Guardar archivo")
        barra.addAction(boton)
        boton.triggered.connect(self.mostrarBtn)
                
        boton2 = QAction(QIcon("Ejercicios/icons/document.png"),"Nuevo",self)
        boton2.setStatusTip("Nuevo archivo")
        barra.addAction(boton2)
        boton2.triggered.connect(self.mostrarBtn)
             
        boton3 = QAction(QIcon("Ejercicios/icons/application-dock.png"),"Abrir",self)
        boton3.setStatusTip("Abrir archivo")
        barra.addAction(boton3)
        boton3.triggered.connect(self.mostrarBtn)
        
        # Separador
        barra.addSeparator()
        
        barra.addWidget(QCheckBox("Check"))
        
        #PESTAÑAS
        pestañas = QTabWidget() #permite organizar diferentes widgets en pestañas
        pestañas.setTabPosition(QTabWidget.TabPosition.North) #donde colocar las pestañas
        pestañas.setMovable(True) #si se pueden mover

        widget1 = QWidget()
        widget2 = QWidget()

        layoutP1 = QVBoxLayout()
        layoutP2 = QVBoxLayout()
        
        layoutP1.addWidget(QLabel("Contenido de la pestaña 1"))
        layoutP2.addWidget(QLabel("Contenido de la pestaña 2"))

        #meto las plantillas con su contenido
        widget1.setLayout(layoutP1) #cada widget es como un nuevo menu, al que le añado el contenido
        widget2.setLayout(layoutP2)

        #añado a la pestaña los menus
        pestañas.addTab((widget1), "Pestaña 1")
        pestañas.addTab((widget2), "Pestaña 2")

        # Añadir las pestañas al layout vertical principal
        vLayout.addWidget(pestañas)

        # Menu de acciones
        menu = self.menuBar()
        menuArchivo = menu.addMenu("Archivo")
        menuEditar = menu.addMenu("Editar")
        menuArchivo.addAction(QAction("Guardar", self))
        menuArchivo.addAction(QAction("Exportar", self))
        menuExportar = menuEditar.addMenu("Exportar Reserva")

        actionSeguir = QAction(QIcon("Ejercicios/EjerciciosRepaso/img/pajarillo.png"),"Síguenos en Redes!", self)

        menuExportar.addAction(actionSeguir)
        actionSeguir.triggered.connect(self.seguirEnRedes)

        
        # Cada fila tiene un layout horizontal para alinear los objetos dentro, y un widget que lo contenga
        # Fila 1
        hLayout1 = QHBoxLayout()
        widget1 = QWidget()
        widget1.setLayout(hLayout1)
        nombre = QLabel("Nombre: ")
        nombre.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.inputNombre = QLineEdit()
        
        hLayout1.addWidget(nombre)
        hLayout1.addWidget(self.inputNombre)
        
        # Añadirlo al layout vertical principal para que se muestre
        vLayout.addWidget(widget1)
        
        #Fila 2
        hLayout2 = QHBoxLayout()
        widget2 = QWidget()
        widget2.setLayout(hLayout2)
        apellidos = QLabel("Apellidos: ")
        self.inputApellidos = QLineEdit()
                
        hLayout2.addWidget(apellidos)
        hLayout2.addWidget(self.inputApellidos)
        vLayout.addWidget(widget2)
        
        # Fila 3
        hLayout3 = QHBoxLayout()
        widget3 = QWidget()
        
        # Layout vertical auxiliar para que salgan los radiobuttons uno encima de otro
        vLayout3Aux = QVBoxLayout()
        widget3Aux = QWidget()
        
        labelMenus = QLabel("Menús Disponibles: ")
        self.radioMenuMar = QRadioButton("Mar")
        self.radioMenuTierra = QRadioButton("Tierra")

        # Lambda es necesario al llamar a una funcion con parámetros, pues se ejecuta al hacer click, no mientras carga la ventana
        self.radioMenuTierra.clicked.connect(lambda: self.mostrarMenus(itemsTierra))
        self.radioMenuMar.clicked.connect(lambda: self.mostrarMenus(itemsMar))
        
        hLayout3.addWidget(labelMenus)
        vLayout3Aux.addWidget(self.radioMenuMar)
        vLayout3Aux.addWidget(self.radioMenuTierra)
        
        hLayout3.addWidget(widget3Aux)
        
        widget3Aux.setLayout(vLayout3Aux)
        
        widget3.setLayout(hLayout3)
        vLayout.addWidget(widget3)
        
        # Fila 4
        self.comboMenus = QComboBox()
        self.comboMenus.setPlaceholderText("Seleccione su menú...")
        vLayout.addWidget(self.comboMenus)
        
        # Fila 5
        hLayout5 = QHBoxLayout()
        widget5 = QWidget()
        
        labelReserva = QLabel("Fecha para la reserva:")
        self.inputReserva = QDateEdit()
        self.inputReserva.setCalendarPopup(True) # Para que aparezca el calendaio al pulsar y deje seleccionar una fecha
        self.inputReserva.setMinimumDate(QDate(2006,1,1)) # Establecer fecha mínima a usar
        
        hLayout5.addWidget(labelReserva)
        hLayout5.addWidget(self.inputReserva)
        
        widget5.setLayout(hLayout5)
        vLayout.addWidget(widget5)
        
        
        # Fila 6
        hLayout6 = QHBoxLayout()
        widget6 = QWidget()
        
        labelResumen = QLabel("Resumen de su reserva:")
        self.inputResumen = QTextEdit()
        
        hLayout6.addWidget(labelResumen)
        
        widget6Aux = QWidget()
        vLayout6Aux = QVBoxLayout()
        widget6Aux.setLayout(vLayout6Aux)
        
        botonConfirmar = QPushButton("Confirmar")
        botonGuardar = QPushButton("Guardar")
        botonReset = QPushButton("Reset")
        
        vLayout6Aux.addWidget(self.inputResumen)
        
        widget6AuxExtra = QWidget()
        hLayout6AuxExtra = QHBoxLayout()
        widget6AuxExtra.setLayout(hLayout6AuxExtra)
        
        hLayout6AuxExtra.addWidget(botonConfirmar)
        hLayout6AuxExtra.addWidget(botonGuardar)
        hLayout6AuxExtra.addWidget(botonReset)
        
        botonGuardar.clicked.connect(self.guardarResumen)
        botonReset.clicked.connect(self.reset)
        botonConfirmar.clicked.connect(self.confirmarReserva)
        
        vLayout6Aux.addWidget(widget6AuxExtra)
        
        hLayout6.addWidget(widget6Aux)
        
        widget6.setLayout(hLayout6)
        vLayout.addWidget(widget6)
        
        # Barra de estado
        self.setStatusBar(QStatusBar(self))
        
        # Declarar los elementos principales del programa, el widget que lo contenga todo y su layout vertical
        widgetPrincipal = QWidget()
        widgetPrincipal.setLayout(vLayout)

        # Mostrar el widget como principal    
        self.setCentralWidget(widgetPrincipal)

    def mostrarMenus(self, items):
        
        # Para que se limpie el combo y no se almacene todo el rato cada lista de menús
        self.comboMenus.clear()
        
        if self.radioMenuTierra.isChecked():
            self.comboMenus.addItems(items)
        else:
            self.comboMenus.addItems(items)   
            
        # Para que se muestre el placeholder
        self.comboMenus.setCurrentIndex(-1)
    
    def guardarResumen(self):
        self.inputResumen.setText("Nombre: " + self.inputNombre.text())
        self.inputResumen.append("Apellidos: " + self.inputApellidos.text())
        self.inputResumen.append("Menú Seleccionado: " + self.comboMenus.currentText())
        self.inputResumen.append("Fecha de reserva: " + self.inputReserva.text())

    def reset(self):
        self.inputResumen.setText("")   
        self.inputNombre.clear()
        self.inputApellidos.clear()
        self.comboMenus.setCurrentIndex(-1)
        self.inputReserva.setDate(QDate(2006,1,1))
    
    def confirmarReserva(self):
        respuesta = QMessageBox.question(
            self,
            "Confirmar reserva",
            "Desea confirmar la reserva?",
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No
        )

        if respuesta == QMessageBox.StandardButton.Yes:
            # Si pulsa no, no hace falta hacer nada y el diálogo se cierra
            QMessageBox.information(self, "Reserva", "Reserva confirmada")

    def seguirEnRedes(self):
        print(f"{self.sender()} SEGUIDO!")     
        
    def mostrarBtn(self):
        print(f"{self.sender().text()}")       
        



app = QApplication([])

window = MainWindow()

window.show()

app.exec()