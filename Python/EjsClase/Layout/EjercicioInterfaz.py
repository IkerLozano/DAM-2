from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar, QDialog, QLabel,
    QMessageBox, QTextEdit, QDateEdit
)   
from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtGui import QPixmap, QAction, QIcon
from dialogs import CustomDialog # Del archivo color.py, tráeme la clase Color




class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi ventana")

        #ATRIBUTOS
        nombreTexto = QLabel("Nombre")
        apellidoTexto = QLabel("Apellido")
        nombre = QLineEdit()
        apellidos = QLineEdit()
        fecha = QDateEdit()
        fechaTexto = QLabel("Fecha")
        departamento = QComboBox()
        depTexto = QLabel("Departamento")
        descripcionTexto = QLabel("Dscripcion")
        descripcionCuadro = QTextEdit()


        #PLANTILLA
        plantilla = QVBoxLayout()
        plantilla1 = QHBoxLayout() #DOS PRIMERAS
        plantilla2 = QVBoxLayout() #DOS SIGUIENTES
        plantilla3 = QHBoxLayout()#EL TEXTO GRANDE

        #AÑADO LOS WIDGETS A LAS PLATILLAS
        plantilla1.addWidget(nombre)
        plantilla1.addWidget(apellidos)
        plantilla1.addWidget(nombreTexto)
        plantilla1.addWidget(apellidoTexto)

        plantilla2.addWidget(fecha)
        plantilla2.addWidget(departamento)
        plantilla2.addWidget(fechaTexto)
        plantilla2.addWidget(depTexto)

        plantilla3.addWidget(descripcionTexto)
        plantilla3.addWidget(descripcionCuadro)

        plantilla.addLayout(plantilla1)
        plantilla.addLayout(plantilla2)
        plantilla.addLayout(plantilla3)


        #MUETSRO TODO
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)
    




app = QApplication([])

ventana = miVentana()
ventana.show()

app.exec()
