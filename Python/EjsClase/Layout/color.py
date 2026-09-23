from PyQt6.QtGui import QColor, QPalette
from PyQt6.QtWidgets import QWidget


#En esta ventana hacemos los widgets que usareomos en el layout

class Color(QWidget): #Color hereda de QWidget para que cada objeto Color sea un widget de PyQt y pueda colocarse en un layout.

    def __init__(self, color):
        super().__init__()


        self.setAutoFillBackground(True) #para que pinte todo el fondo del cuadrado

        paleta = self.palette()  #obtiene la paleta de colores actual del widget para poder modificarla.
        paleta.setColor(QPalette.ColorRole.Window, QColor(color))
        self.setPalette(paleta) #aplica una paleta modificada al widget.