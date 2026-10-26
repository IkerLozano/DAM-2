from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
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

        #DECLARO LOS WIDGETS############
        nombreTexto = QLabel("Nombre:")
        self.nombre = QLineEdit()
        apellidosTexto = QLabel("Apellidos:")
        self.apellidos = QLineEdit()
        fechaTexto = QLabel("Fecha de alta:")
        self.fecha = QDateEdit()
        DepTexto = QLabel("Departamento:")
        self.dep = QComboBox()
        DescripcionTexto = QLabel("Descripcion")
        self.descripcion = QTextEdit() #TextEdit grande
        self.boton1 = QPushButton("Grabar")
        self.boton2 = QPushButton("Reset")


        #CONFUGURO EL CALENDARIO##########
        self.fecha = QDateEdit(QDate(2007, 3, 10)) #te pone una fecha por defecto
        self.fecha.setMinimumDate(QDate(2006,1,1)) #establezco la fecha minima
        self.fecha.setCalendarPopup(True) #abre el calendario grande a apartir de una barra


        #CONFIGURO EL MENU DE DEPARTAMENTO#######
        self.dep.addItems(["Contabilidad", "Administracion", "Produccion"]) #meto las opciones al menu


        #CREO LAS PLANTILLAS##################
        plantillaP = QVBoxLayout()
        plantilla1 = QHBoxLayout()
        plantilla2 = QHBoxLayout()
        plantilla3 = QHBoxLayout()
        plantilla4 = QHBoxLayout()
        plantilla5 = QHBoxLayout()
        plantilla6 = QHBoxLayout()


        #METO LOS WIDGETS A LAS PLATILLAS#######
        plantilla1.addWidget(nombreTexto)
        plantilla1.addWidget(self.nombre)

        plantilla2.addWidget(apellidosTexto)
        plantilla2.addWidget(self.apellidos)

        plantilla3.addWidget(fechaTexto)
        plantilla3.addWidget(self.fecha)

        plantilla4.addWidget(DepTexto)
        plantilla4.addWidget(self.dep)

        plantilla5.addWidget(DescripcionTexto)
        plantilla5.addWidget(self.descripcion)

        plantilla6.addWidget(self.boton1)
        plantilla6.addWidget(self.boton2)

        plantillaP.addLayout(plantilla1)
        plantillaP.addLayout(plantilla2)
        plantillaP.addLayout(plantilla3)
        plantillaP.addLayout(plantilla4)
        plantillaP.addLayout(plantilla5)
        plantillaP.addLayout(plantilla6)


        #FUNCIONALIDAD DE LOS BOTONES######
        self.boton1.clicked.connect(self.grabar)
        self.boton2.clicked.connect(self.reset)

        #MUESTRO TODO POR PATALLA##################
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)
        


    def grabar(self):
        self.descripcion.append(self.nombre.text())
        self.descripcion.append(self.apellidos.text())
        self.descripcion.append(self.fecha.text())
        self.descripcion.append(self.dep.currentText())
        #append() añade texto al final de lo que ya hay en un QTextEdit, sin borrar el contenido anterior


    def reset(self):
        self.nombre.clear()
        self.apellidos.clear()
        self.dep.clear()
        self.descripcion.clear()
        self.fecha.setDate(QDate(2006,1,1)) #establezco la fecha minima/por defecto



#para recoger texto del QTextEdit --> .toPlainText() --> str
#para borar texto del QTextEdit --> .clear()



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()