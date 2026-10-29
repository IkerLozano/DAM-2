from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QTextEdit,
    QMessageBox
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialog import CustomDialog # Del archivo color.py, tráeme la clase Color




class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        self.textoVentana = QLabel("Ventana segundaria")
        
        plantilla = QVBoxLayout()
        plantilla.addWidget(self.textoVentana)

        self.setLayout(plantilla)



class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        self.ventana2=OtraVentana()


        #WIDGETS#####
        self.texto = QLineEdit()
        self.texto.setPlaceholderText("Escribe aqui")
        boton1 = QPushButton("Abrir/Cerrar")
        boton2 = QPushButton("Cambiar texto")
        boton3 = QPushButton("Salir")


        #PLANTILLAS
        plantillaP = QVBoxLayout()

        plantillaP.addWidget(self.texto)
        plantillaP.addWidget(boton1)
        plantillaP.addWidget(boton2)
        plantillaP.addWidget(boton3)


        #FUNCIONALIDAD
        boton1.clicked.connect(self.abrirVentana)
        boton2.clicked.connect(self.cambiarTexto)
        boton3.clicked.connect(self.botonPulsado)

        
        #los muestro
        widget = QWidget()
        widget.setLayout(plantillaP)
        self.setCentralWidget(widget)


    def abrirVentana(self): 
        if self.ventana2.isVisible(): #comprueba si la ventana está visible (devuelve true/false)

            self.ventana2.hide() #culta la ventana sin cerrarla definitivamente.

        else:
            self.ventana2.show()  #muestra la ventana.



    def cambiarTexto(self):

        if self.ventana2.isVisible(): 
        
            self.ventana2.textoVentana.setText(self.texto.text())


    def botonPulsado(self): 
        dlg = CustomDialog(self) #ponemos aqui self para que la ventana nueva salga dentro de la ventana padre
        
        #dlg.setText("¿Seguro que quieres salir?") #mensaje de la ve
        #dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
        #dlg.setIcon(QMessageBox.Icon.Question)

        if dlg.exec():  #== QMessageBox.StandardButton.Yes:
            app.closeAllWindows()
        else:
           self.texto.clear()
           dlg.close()
           
        
      

        



app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()