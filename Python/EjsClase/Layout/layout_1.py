from PyQt6.QtWidgets import QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView, QLineEdit, QDial,QSpinBox, QSlider, QCalendarWidget   #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


from color import Color


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")


        plantilla = QHBoxLayout()

        #va a crear una caja horizontal con tantos cuadros color como le digamos
        plantilla.addWidget(Color("red"))
        plantilla.addWidget(Color("blue"))
        plantilla.addWidget(Color("yellow"))
        plantilla.addWidget(Color("green"))

        widget = QWidget()
        widget.setLayout(plantilla)




        self.setCentralWidget(widget)
      


      
        
    

    
        


    
   

   

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()



