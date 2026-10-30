from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget  #importamos las librerias
from PyQt6.QtCore import Qt


class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        

        self.setWindowTitle("Mi aplicacion")

      
        self.boton = QPushButton("Boton") #crear un boton
        self.boton.setEnabled(True) #desactiva el boton para que no se pueda pulsar más (con False se desactiva)
        self.boton.setCheckable(True) #como si fuera un interruptor
        self.boton.setChecked(True) #lo deja ya pulsado desde el principio
        #self.boton.setEnabled(False)#Empieza desactivado

        self.boton.clicked.connect(self.estadoBoton) #cliked --> cuando se pulse el botón
        self.boton.clicked.connect(self.lista)


        #Diferentes acciones que podemos hacer con el botón
        self.boton.pressed.connect(self.uno) #pulsar son soltar
        self.boton.released.connect(self.dos) #soltar
        self.boton.clicked.connect(self.tres) #pulsar y soltar

        


        self.setCentralWidget(self.boton)



    def estadoBoton(self, estado): #El segundo parámetro nos dice el estado del botón (pulsado/no pulsado , true/false)
        print("¿Boton pulsado? --> ", estado)


    def uno(self):
        print("Boton Pulsado")

    def dos(self):
        print("Boton soltado")

    def tres(self):
        print("Boton pulsado y soltado")



    def lista(self, pulsado):
        self.boton.setText(["No pulsado", "Pulsado"][pulsado])
        #hacemos una lista con los posibles mensajes del boton
        #segun el estado elegira pulsado si el estado es True y  no pulsado si es False


#boton.setEnabled(estado == 2) activa el boton si es estado es 2 (pulsado)
#triggered --> si el boton es un Qaction
         


app = QApplication([])

ventana = miVentana()
ventana.show()


app.exec()

