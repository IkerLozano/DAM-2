from PyQt6.QtWidgets import QApplication, QPushButton  #se importan las librerias

app = QApplication([])

window = QPushButton("Pulsa") #crear boton con texto

window.show() #Pra que muestre la ventana, pero sin el "app.exec()" se abre y cierra muy rapido

app.exec() #Para que la ventana se quede y no desaparezca