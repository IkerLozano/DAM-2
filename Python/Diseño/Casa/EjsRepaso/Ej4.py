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


        
        #WIDGETS######
        self.calendario = QCalendarWidget()
        entradaTexto = QLabel("Entrada:")
        self.entrada = QDateEdit(QDate(2026, 10, 28))
        salidaTexto = QLabel("Salida:")
        self.salida = QDateEdit(QDate(2026, 10, 28))
        habitacionTexto = QLabel("Habitacion")
        self.habitacion = QComboBox()
        self.habitacion.addItems(["Individual", "Doble", "Grande"])
        self.boton1 = QPushButton("Reservar")
        self.boton2 = QPushButton("Reset")
        self.texto = QLabel("Noches: 0")
        self.texto.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal




        #PLANTILLAS###
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QHBoxLayout()
        plantilla3 = QHBoxLayout()
        plantilla4 = QHBoxLayout()


        plantilla1.addWidget(entradaTexto)
        plantilla1.addWidget(self.entrada, 1)
        plantilla2.addWidget(salidaTexto)
        plantilla2.addWidget(self.salida, 1)
        plantilla3.addWidget(habitacionTexto)
        plantilla3.addWidget(self.habitacion, 1)
        plantilla4.addWidget(self.boton1)
        plantilla4.addWidget(self.boton2)

        plantillaP.addWidget(self.calendario)
        plantillaP.addLayout(plantilla1)
        plantillaP.addLayout(plantilla2)
        plantillaP.addLayout(plantilla3)
        plantillaP.addLayout(plantilla4)
        plantillaP.addWidget(self.texto)



        #CONFIGURACIONES
        self.entrada.setMinimumDate(QDate(2026, 10, 28)) #establezco la fecha minima
        self.entrada.setCalendarPopup(True) #abre el calendario grande a apartir de una barra
        
        self.salida.setMinimumDate(QDate(2026, 10, 28)) #establezco la fecha minima
        self.salida.setCalendarPopup(True) #abre el calendario grande a apartir de una barra

        self.habitacion.setCurrentIndex(0) #opcion 0 mracada por defecto


        #FUNCIONALIDAD#####
        self.calendario.selectionChanged.connect(self.dia) #selectionChanged --> cuando cambie la fecha
        self.entrada.dateChanged.connect(self.cambio)
        self.salida.dateChanged.connect(self.cambio)
        self.boton1.clicked.connect(self.reservado)
        self.boton2.clicked.connect(self.resetTodo)



        #los muestro
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)


        noches = 0 #lo creo aqui para q lo pueda usar en todos los sitios

    def dia(self):
        self.entrada.setDate(self.calendario.selectedDate())


    def cambio(self):
        #self.salida.setDate(self.entrada.date())
        
        self.noches = self.entrada.date().daysTo(self.salida.date()) #lo creo aqui para q lo pueda usar en todos los sitios
        self.salida.setMinimumDate(QDate(self.entrada.date())) #establezco la fecha minima

        
        self.texto.setText("Noches: " + str(self.noches)) 

        


    def reservado(self):
        tipoHabitacion = self.habitacion.currentText() 
        
        if (self.noches > 0):
            dlg = QMessageBox(self) #creo el dialog 
            dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
            dlg.setText("Reserva de " + str(self.noches) +  " noche/s en una habitacion " + tipoHabitacion) #mensaje de la ve
            
            #le digo los botones que quiero
            dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
            dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono
            
            #segun la respuesta mando un mensaje
            if dlg.exec() == QMessageBox.StandardButton.Yes:
                print("El usuario ha aceptado")
                self.boton1.setEnabled(False)
            else:
                print("El usuario ha rechazado")

        elif(self.noches == 0):
            dlg = QMessageBox(self) #creo el dialog 
            dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
            dlg.setText("Debes reservar al menos 1 noche") #mensaje de la ve
            
            #le digo los botones que quiero
            dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono

            dlg.exec()
            


    def resetTodo(self):
        self.entrada.setDate(QDate(2026, 10, 28))
        self.salida.setDate(QDate(2026, 10, 28))
        self.habitacion.setCurrentIndex(0)
        self.boton1.setEnabled(True)
        self.texto.setText("Noches: 0") 
        

    
        





       
        


app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()

        