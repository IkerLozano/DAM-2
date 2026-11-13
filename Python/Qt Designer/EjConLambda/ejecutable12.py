from Ejercicio12 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPalette, QColor


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        
        self.pushButton.pressed.connect(lambda: self.label_4.setStyleSheet("background-color:red"))
        self.pushButton_3.pressed.connect(lambda: self.label_4.setStyleSheet("background-color:green"))
        self.pushButton_2.pressed.connect(lambda: self.label_4.setStyleSheet("background-color:blue"))
        
        self.pushButton_6.pressed.connect(lambda: self.label_4.setStyleSheet("font-family: Verdana;"))
        self.pushButton_5.pressed.connect(lambda: self.label_4.setStyleSheet("font-family: Arial;"))
        self.pushButton_4.pressed.connect(lambda: self.label_4.setStyleSheet("font-family: Tahoma;"))
        
        self.pushButton_9.pressed.connect(lambda: self.label_4.setStyleSheet("font-size: 10px;"))
        self.pushButton_8.pressed.connect(lambda: self.label_4.setStyleSheet("font-size: 12px;"))
        self.pushButton_7.pressed.connect(lambda: self.label_4.setStyleSheet("font-size: 14px;"))


app = QApplication([])

#estilo visual general de la aplicación (Opcional)
#app.setStyle("Fusion") 

#Poner estilos QSS
with open(f"EjConLambda/estilos12.qss", "r") as f :
            app.setStyleSheet(f.read()) #aplica los estilos a toda la aplicación.


ventana = MainWindow()
app.exec()


