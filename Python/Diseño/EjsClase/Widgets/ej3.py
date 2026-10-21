from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton  #se importan las librerias

app = QApplication([])

window = QMainWindow() #ventana dnd se pueden poner cosas (menus, botones ....)

window.show() #Pra que muestre la ventana, pero sin el "app.exec()" se abre y cierra muy rapido

app.exec() #Para que la ventana se quede y no desaparezca