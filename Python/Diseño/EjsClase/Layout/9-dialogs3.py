from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel, QMessageBox
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialogs import CustomDialog # Del archivo color.py, tráeme la clase Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        boton = QPushButton("Pulsa aqui")
        boton.clicked.connect(self.botonPulsado)
        


       
        self.setCentralWidget(boton)



    def botonPulsado(self): 
        dlg = QMessageBox(self) #creo el dialog 
        dlg.setWindowTitle("Cuadro de mensaje") #titulo de la nueva ventana 
        dlg.setText("Este es el cuadro de mensaje de mi cuadro mensaje") #mensaje de la ve
        
        #le digo los botones que quiero
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
        dlg.setIcon(QMessageBox.Icon.Information) #elijo el icono
        
        #segun la respuesta mando un mensaje
        if dlg.exec() == QMessageBox.StandardButton.Yes:
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")

#QMessageBox() -->  es como un customDialog pero viene ya predefinido con un estilo y con un botón de ok


app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
