from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton #importamos las librerias

app = QApplication([]) # los [] es una lista vacia, app controla toda nuestra aplicación gráfica

widget = QWidget() #Crea una ventana/widget vacío y guárdalo en la variable widget (en este caso no se usa)

boton = QPushButton("Hola") #creo un  boton contexto
boton.show() # lo muestro

ventana = QMainWindow() #creo una ventana
ventana.show() #muestro la ventana
ventana.setCentralWidget(boton)#meto el bootn dentro de la ventana




app.exec() #si no lo usamos la venta se abre y se cierra rapido y  no la vemos
















