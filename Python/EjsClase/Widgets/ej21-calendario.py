from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        self.calendario = QCalendarWidget()

        self.calendario.selectionChanged.connect(self.verFecha)


      
        
        


    
        self.setCentralWidget(self.calendario)


    
    def verFecha(self):
        print(self.calendario.selectedDate().toString("dd/MM/yyyy"))


   


         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



