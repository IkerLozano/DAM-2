from Ej3 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

     

        self.pushButton_4.clicked.connect(self.grabar)
        self.pushButton.clicked.connect(self.reset)
        
        
        


    def grabar(self):
        self.textEdit_2.append(self.lineEdit.text())
        self.textEdit_2.append(self.lineEdit_2.text())
        self.textEdit_2.append(self.textEdit.toPlainText())
        self.textEdit_2.append(self.comboBox.currentText())

        boton = self.buttonGroup.checkedButton() #Recoge únicamente el RadioButton que está seleccionado,
        if boton is not None:
            self.textEdit_2.append(boton.text())
        else:
             self.textEdit_2.append("No has selcionado ningun radio button")
            
        
    
    def reset(self):
        self.lineEdit.clear()
        self.lineEdit_2.clear()
        self.textEdit.clear()
        self.textEdit_2.clear()
        self.comboBox.setCurrentIndex(0)

        self.buttonGroup.setExclusive(False) #para que Qt nos deje desmarca la opciondel radio
        self.boton = self.buttonGroup.checkedButton()
        if self.boton:
            self.boton.setChecked(False)



    
    


app = QApplication([])

app.setStyle("Windowsversion") #estilo para la ventana



ventana = MainWindow()
app.exec()