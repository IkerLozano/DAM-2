from PyQt6.QtWidgets import QDateEdit, QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt, QDate
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        self.fecha = QDateEdit() #crea una caja pequeña con la fecha escrita

        self.fecha = QDateEdit(QDate(2007, 3, 10)) #te pone una fecha por defecto
        self.fecha.setMinimumDate(QDate(2006,1,1)) #establezco la fecha minima
        self.fecha.setCalendarPopup(True) #abre el calendario grande a apartir de una barra


        self.fecha.dateChanged.connect(self.dia) #dateChanged --> cuando cambie la fecha


        self.setCentralWidget(self.fecha)


    def dia(self):
        print(self.fecha.date().toString("dd/MM/yyyy"))

        # date() --> Obtiene la fecha que el usuario ha seleccionado en el calendario
        #.toString("dd/MM/yyyy") --> convierte la fecha a texto con el formato día/mes/año
         

#para recoger texto --> .date()/.text() --> QDate


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



