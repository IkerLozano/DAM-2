from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QTextEdit,
    QMessageBox, QMenu
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialog import CustomDialog # Del archivo color.py, tráeme la clase Color





class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        #WIDGETS#####
        foto = QLabel()
        self.texto = QLabel("Pulsa aqui")


        #PLANTILLAS####
        plantillaP = QVBoxLayout()

        plantillaP.addWidget(foto)
        plantillaP.addWidget(self.texto)

        #CONFIGURACIONES#####
        foto.setPixmap(QPixmap("img\Captura de pantalla 2026-09-16 205952.png")) #poner la imagen
        foto.setScaledContents(True)#Para q sea responsiva con el tamaño de la pantaña
       
        formato = self.texto.font() #nos da acceso a los formatos

        formato.setPointSize(20) #tamaño
        formato.setFamily("Aial") #tipo de letra
        formato.setBold(True) #negrita o no
        self.texto.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter) #alinear el texto, de esta manera esta alieado tanto vertical como horizontal
        self.texto.setFont(formato) #aplicamos todas las configuraciones


        #los muestro
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)


    #MENU####
    def contextMenuEvent(self, event):

        menu = QMenu(self)


        #Añado opciones al menu
                    #self.ac1 = menu.addAction(QAction("Accion 1", self)) 
                    #self.ac2 = menu.addAction(QAction("Accion 2", self))
                    #self.ac3 = menu.addAction(QAction("Accion 3", self))

        self.ac1 = QAction("Accion 1", self)
        self.ac2 = QAction("Accion 2", self)
        self.ac3 = QAction("Accion 3", self)

        menu.addAction(self.ac1)
        menu.addAction(self.ac2)
        menu.addAction(self.ac3)

        #acciones segun cual pulses
        self.ac1.triggered.connect(self.metodo1)
        self.ac2.triggered.connect(self.metodo2)
        self.ac3.triggered.connect(self.metodo3)

        
        menu.exec(event.globalPos()) #Muestra el menú



    #EVENTOS####
    def mouseMoveEvent(self, a0):
        self.texto.setText("Has pulsado y arrastrado")

    def mousePressEvent(self, a0):
        self.texto.setText("Has pulsado encima")

    def mouseReleaseEvent(self, a0):
        self.texto.setText("Has soltado el raton")

    def mouseDoubleClickEvent(self, a0):
        self.texto.setText("Has dado doble clik")


    #ACIONES DEL MENU####
    def metodo1(self):
        self.texto.setText("Has elegido la Accion 1")

    def metodo2(self):
        self.texto.clear()

    def metodo3(self):
        self.texto.setText("Acción 3 elegida")


       
        


        
       
           
        
      

        



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()