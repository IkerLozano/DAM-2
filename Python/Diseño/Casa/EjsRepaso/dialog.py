from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialogButtonBox, QDialog
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon



class CustomDialog(QDialog):

    def __init__(self, parent=None):
        super().__init__(parent)

        self.setWindowTitle("Dialog personalizado")

        #guardo los botones que voya a usar (ok y cancel)
        Qbtn = QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel

        self.dialogBox = QDialogButtonBox(Qbtn) #agrupa los botones

        #para que al pusarlo tengan accion, si no se ven pero no hacen nada
        self.dialogBox.accepted.connect(self.accept)
        self.dialogBox.rejected.connect(self.reject)


        #hago la plantilla
        mensaje = QLabel("Seguro que quieres salir")
        
        self.plantilla = QVBoxLayout()
        self.plantilla.addWidget(mensaje)
        self.plantilla.addWidget(self.dialogBox)
        self.setLayout(self.plantilla)

