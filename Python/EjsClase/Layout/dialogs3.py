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
        dlg = QMessageBox(self) #pinemos aqui self para que la ventana nueva slaga dentro de la ventana padre
        dlg.setWindowTitle("Cuadro de mensaje")
        dlg.setText("Este es el cuadro de mensaje de mi cuadro mensaje")
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
        dlg.setIcon(QMessageBox.Icon.Information)
        


        
        if dlg.exec() == QMessageBox.StandardButton.Yes:
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")

    

app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
