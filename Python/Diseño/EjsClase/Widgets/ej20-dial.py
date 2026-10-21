from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")




        dial = QDial()
        dial.setNotchesVisible(True) #mostrar las muescas

        
        dial.valueChanged.connect(self.valorCambiado)
        dial.sliderMoved.connect(self.valorCambiado)
        
        


    
        self.setCentralWidget(dial)


    def valorCambiado(self, estado):
        print(estado)
        
        
    def textoCambiado(self, estado):
        print(estado)
        



   


         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



