from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox  #importamos las librerias
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")



        casilla = QCheckBox("Casilla de verificacion") #crear el CheckBox
        casilla.setChecked(True) #marcada por defecto, si le poemos False no se marca

        formato = casilla.font() #creamos el elemento sobre la etiqueta label
        formato.setBold(True) #negrita
        casilla.setFont(formato) #todo el formato que hemos puesto se lo aplicamos



        casilla.stateChanged.connect(self.muestraEstado) #stateChanged  --> cuando cambie el estado
        casilla.stateChanged.connect(self.mensaje)




        self.setCentralWidget(casilla)



    def muestraEstado(self, estado): #2 es marcado y 0 no marcado tamb puede estar parcialmente marcado (1)
        print(estado)


    def mensaje(self, estado):
        print(["Boton no Pulsado", "", "Boton pulsado"][estado])
        #el "", es para cuando este en 1

         
#isChecked() --> comprobar si esta marcada

app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

