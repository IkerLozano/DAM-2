from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        
        self.calendario = QCalendarWidget() #creamos el calendario

        self.calendario.selectionChanged.connect(self.dia)



        self.setCentralWidget(self.calendario)


    def dia(self):
        print(self.calendario.selectedDate().toString("dd/MM/yyyy"))

        # selectedDate() --> Obtiene la fecha que el usuario ha seleccionado en el calendario
        #.toString("dd/MM/yyyy") --> el selectedDate nos devolvera una fecha en formato QDate, asi que nosotros la pasmos a String y le indicamos que formato queremos 


         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



