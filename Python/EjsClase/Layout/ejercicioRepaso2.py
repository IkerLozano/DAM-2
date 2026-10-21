from PyQt6.QtWidgets import QMainWindow, QMessageBox, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        # <=================================================>
        nombreHL = QHBoxLayout()

        self.nombreLabel = QLabel("Nombre:")
        self.nombreEdit = QLineEdit()

        nombreHL.addWidget(self.nombreLabel)
        nombreHL.addWidget(self.nombreEdit)
        # <=================================================>
        apellidosHL = QHBoxLayout()

        self.apellidosLabel = QLabel("Apellidos:")
        self.apellidosEdit = QLineEdit()

        apellidosHL.addWidget(self.apellidosLabel)
        apellidosHL.addWidget(self.apellidosEdit)
        # <=================================================>
        fechaHL = QHBoxLayout()

        self.fechaLabel = QLabel("Fecha de alta:")
        self.fechaCalendar = QDateEdit()

        self.fechaCalendar.setCalendarPopup(True)
        self.fechaCalendar.setDate(QDate.currentDate())

        fechaHL.addWidget(self.fechaLabel)
        fechaHL.addWidget(self.fechaCalendar)
        # <=================================================>
        departamentoHL = QHBoxLayout()

        self.departamentoLabel = QLabel("Departamento:")
        self.departamentoCombo = QComboBox()
        self.departamentoCombo.addItems(["Contabilidad","Ventas","Reparto"])

        departamentoHL.addWidget(self.departamentoLabel)
        departamentoHL.addWidget(self.departamentoCombo)
        # <=================================================>
        botonesAbajo = QHBoxLayout()

        self.boton1 = QPushButton("Enviar")
        self.boton2 = QPushButton("Reset")

        self.boton1.pressed.connect(self.escribir)
        self.boton2.pressed.connect(self.reset)

        botonesAbajo.addWidget(self.boton1)
        botonesAbajo.addWidget(self.boton2)
        # <=================================================>
        layoutV = QVBoxLayout()

        layoutV.addLayout(nombreHL)
        layoutV.addLayout(apellidosHL)
        layoutV.addLayout(fechaHL)
        layoutV.addLayout(departamentoHL)
        layoutV.addLayout(botonesAbajo)

        contenedor = QWidget()
        contenedor.setLayout(layoutV)

        self.setCentralWidget(contenedor)

    def escribir(self):
        dlg = QMessageBox(self)
        dlg.setWindowTitle("Confirmación")
        dlg.setText(f"Si eres {self.nombreEdit.text()} {self.apellidosEdit.text()} pulsa sí")
        # Si le asigno nuevos botónes los anteriores se pierden
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)

        if dlg.exec() == QMessageBox.StandardButton.Yes:
            self.close()
        else:
            self.nombreEdit.clear()
            self.apellidosEdit.clear()

    
    def reset(self):
        self.apellidosEdit.clear()
        self.nombreEdit.clear()
        self.fechaCalendar.setDate(QDate.currentDate())
        self.departamentoCombo.setCurrentIndex(0) 


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
