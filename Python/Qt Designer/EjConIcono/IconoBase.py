from PyQt6.QtWidgets import QPushButton, QApplication, QStyle
from PyQt6.QtCore import QSize

app = QApplication([])

boton = QPushButton()

estilos = boton.style() #obtengo los estilos
icono = estilos.standardIcon(QStyle.StandardPixmap.SP_MessageBoxCritical) #pillo un icono estandar de Qt
boton.setIcon(icono) #coloco el icono dentro del boton
boton.setIconSize(QSize(40,40)) #tamaño del icono
boton.show()
app.exec()


