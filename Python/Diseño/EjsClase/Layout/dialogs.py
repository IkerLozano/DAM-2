from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialogButtonBox, QDialog
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from color import Color # Del archivo color.py, tráeme la clase Color


class CustomDialog(QDialog):

    def __init__(self, parent=None):
        super().__init__(parent)

        self.setWindowTitle("Caudro de dialogo")

        #guardo los botones que voya a usar (ok y cancel)
        Qbtn = QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel

        self.dialogBox = QDialogButtonBox(Qbtn) #agrupa los botones

        #para que al pusarlo tengan accion, si  no se ven pero no hacen nada
        self.dialogBox.accepted.connect(self.accept)
        self.dialogBox.rejected.connect(self.reject)

        #hago la plantilla
        self.plantilla = QVBoxLayout()
        mensaje = QLabel("Algo ha sucedido ¿Todo ok?")
        self.plantilla.addWidget(mensaje)
        self.plantilla.addWidget(self.dialogBox)
        self.setLayout(self.plantilla)

