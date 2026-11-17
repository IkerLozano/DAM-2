from EjRepaso import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()



        #FUNCIONALIDAD########## 
        self.pushButton.clicked.connect(self.cambio1)
        self.pushButton_2.clicked.connect(self.cambio2)
        self.pushButton_3.clicked.connect(self.cambio3)
        
        self.pushButton_4.clicked.connect(self.cambio4)
        self.pushButton_5.clicked.connect(self.cambio5)
        self.pushButton_6.clicked.connect(self.cambio6)

        self.pushButton_9.clicked.connect(self.cambio7)
        self.pushButton_7.clicked.connect(self.cambio8)
        self.pushButton_8.clicked.connect(self.cambio9)


    def cambio1(self):
        self.label_4.setStyleSheet("background-color: red;")

    def cambio2(self):
        self.label_4.setStyleSheet("background-color: green;")

    def cambio3(self):
        self.label_4.setStyleSheet("background-color: blue;")

    def cambio4(self):
        self.label_4.setStyleSheet("font-family: Verdana;")

    def cambio5(self):
        self.label_4.setStyleSheet("font-family: Arial;")

    def cambio6(self):
        self.label_4.setStyleSheet("font-family: Tahoma;")

    def cambio7(self):
        self.label_4.setStyleSheet("font-size: 10px;")

    def cambio8(self):
        self.label_4.setStyleSheet("font-size: 12px;")

    def cambio9(self):
        self.label_4.setStyleSheet("font-size: 14px;")
    


app = QApplication([])

#app.setStyle("Windowsvista") #estilo para la ventana

with open("Estilos.qss", "r") as f :
    app.setStyleSheet(f.read())


ventana = MainWindow()
app.exec()