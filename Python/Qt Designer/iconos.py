from PyQt6.QtWidgets import QPushButton, QApplication, QStyle
from PyQt6.QtCore import QSize

app = QApplication([])

boton = QPushButton()

estilos = boton.style()
icono = estilos.standardIcon(QStyle.StandardPixmap.SP_MessageBoxCritical)
boton.setIcon(icono)
boton.setIconSize(QSize(40,40))
boton.show()
app.exec()