from PyQt6.QtGui import QColor, QPalette
from PyQt6.QtWidgets import QWidget


#En esta ventana hacemos los widgets que usareomos en el layout


class colores(QWidget):

    def __init__(self, color):
        super().__init__()

        self.setAutoFillBackground(True) #rellena el fondo de cada windget del color que le indiquemos

        paleta = self.palette() #obtiene la paleta de colores actual del widget para poder modificarla.
        paleta.setColor(QPalette.ColorRole.Window, QColor(color)) #ns q hace esto
        self.setPalette(paleta)#aplica una paleta modificada al widget.