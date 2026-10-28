from Ej2 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication 
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPalette, QColor


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()


app = QApplication([])
app.setStyle("Fusion") #estilo para la ventana, para que una peleta funcione tiene que haber un estilo


#paleta = QPalette() #cro la paleta
#paleta.setColor(QPalette.ColorRole.Window, Qt.GlobalColor.red) #escojo el color
#paleta.setColor(QPalette.ColorRole.WindowText, QColor("#ffffff")) #color del texto
#paleta.setColor(QPalette.ColorRole.Button, QColor(0,255,0)) #color de los botones
#app.setPalette(paleta) #aplicola paleta
darkPalette = QPalette()
darkPalette.setColor(QPalette.ColorRole.Window, QColor(53, 53, 53))
darkPalette.setColor(QPalette.ColorRole.WindowText, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, QColor(127, 127, 127))
darkPalette.setColor(QPalette.ColorRole.Base, QColor(42, 42, 42))
darkPalette.setColor(QPalette.ColorRole.AlternateBase, QColor(66, 66, 66))
darkPalette.setColor(QPalette.ColorRole.ToolTipBase, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorRole.ToolTipText, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorRole.Text, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, QColor(127, 127, 127))
darkPalette.setColor(QPalette.ColorRole.Dark, QColor(35, 35, 35))
darkPalette.setColor(QPalette.ColorRole.Shadow, QColor(20, 20, 20))
darkPalette.setColor(QPalette.ColorRole.Button, QColor(53, 53, 53))
darkPalette.setColor(QPalette.ColorRole.ButtonText, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, QColor(127, 127, 127))
darkPalette.setColor(QPalette.ColorRole.BrightText, Qt.GlobalColor.red)
darkPalette.setColor(QPalette.ColorRole.Link, QColor(42, 130, 218))
darkPalette.setColor(QPalette.ColorRole.Highlight, QColor(42, 130,218))
darkPalette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Highlight, QColor(80, 80, 80))
darkPalette.setColor(QPalette.ColorRole.HighlightedText, Qt.GlobalColor.white)
darkPalette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.HighlightedText, QColor(127, 127, 127))
app.setPalette(darkPalette) #aplicola paleta

ventana = MainWindow()
app.exec()