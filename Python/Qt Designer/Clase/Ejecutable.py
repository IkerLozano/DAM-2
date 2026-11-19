from EjExamen import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()


        self.pushButton_7.pressed.connect(lambda: self.pushButton_9.setStyleSheet("background-color:blue;"))
        self.pushButton_12.pressed.connect(lambda: self.pushButton_11.setStyleSheet("background-color:blue;"))

        self.pushButton.pressed.connect(lambda: self.setStyleSheet("Estilos1;"))
        self.pushButton_3.pressed.connect(lambda: self.setStyleSheet("Estilos2;"))
        self.pushButton_2.pressed.connect(lambda: self.setStyleSheet("Estilos3;"))


    
        if self.comboBox.currentText == "Uno":
            self.label_2.setStyleSheet("background-color:red;")
        elif self.comboBox.currentText == "Dos":
            self.label_2.setStyleSheet("background-color:green;")
        elif self.comboBox.currentText == "Tres":
            self.label_2.setStyleSheet("background-color:blue;")

        #self.pushButton.pressed.connect(self.estilos)
        #self.pushButton.pressed.connect(self.estilos)
        #self.pushButton.pressed.connect(self.estilos)

    #def estilos(self, e): #'e es el indice de la opcion seleccionada'
    #    with open(f"Estilos{e+1}.qss", "r") as f : #uno 'e+1' porque los índices del ComboBox empiezan en 0
    #        app.setStyleSheet(f.read())
    

           
    


    
    


app = QApplication([])

#app.setStyle("Windowsversion")

with open(f"EstilosGeneral.qss", "r") as f :
            app.setStyleSheet(f.read())


ventana = MainWindow()
app.exec()