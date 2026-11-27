import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication, QVBoxLayout, QHBoxLayout, QTableWidget, QTableWidgetItem,QLabel, QWidget, QComboBox, QLineEdit, QPushButton



class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
       

        self.setWindowTitle("Conectar BD")

        try:
            self.con = mysql.connector.connect( #con es el nombre de la conexion, pude ser el quequeramos
                host="localhost",
                port=3306,
                user="root",
                password="1234",
                database="capitales"
            )
        except mysql.connector.Error as error:
            print(error)


        self.tabla = QTableWidget()
        self.label = QLabel("Minimo: ")
        self.dato = QLineEdit()
        self.label2 = QLabel("Maximo: ")
        self.dato2 = QLineEdit()
        self.boton = QPushButton("Seleccionar")


        #pongo los widgets en la pantalla
        self.contenedor = QHBoxLayout()
        self.contenedor2 = QHBoxLayout()
        self.contenedorP1 = QHBoxLayout()
        self.contenedorP = QVBoxLayout()
        
        self.contenedor.addWidget(self.label)
        self.contenedor.addWidget(self.dato)
        self.contenedor2.addWidget(self.label2)
        self.contenedor2.addWidget(self.dato2)
        self.contenedorP1.addLayout(self.contenedor)
        self.contenedorP1.addLayout(self.contenedor2)
        self.contenedorP1.addWidget(self.boton)

        self.contenedorP.addLayout(self.contenedorP1)
        self.contenedorP.addLayout(self.contenedor)
        self.contenedorP.addWidget(self.tabla)
        
        widget = QWidget()
        widget.setLayout(self.contenedorP)
        self.setCentralWidget(widget)

        
        #self.cargardatos()
        self.boton.clicked.connect(self.cambiarDatos)



        self.show()




    #def cargardatos(self):
    #        # Creo el cursor
    #        cursor = self.con.cursor() 
    #        sql="SELECT * FROM capitales "
    #        # Ejecuto la consulta con el cursor
    #        cursor.execute(sql)
    #        #columnas = [desc[0] for desc in cursor.description] #esto es igual siempre que hagamos una tabla, esto pone los tirulos de la tabla
    #        # Recojo los resultados
    #        self.resultado=cursor.fetchall()
#
    #        self.combo.addItems(desc[0] for desc in self.resultado) #mete todos los resultados de la consulta en combo
#
    #        self.combo.setCurrentIndex(0)
    #        self.cambiarDatos() #esto es para que nos muestre datos por defecto



    def cambiarDatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales WHERE Población Between %s and %s"
        min = self.dato.text()
        max = self.dato2.text()
        cursor.execute(sql, (min,max,))
        # Ejecuto la consulta con el cursor

        columnas = [desc[0] for desc in cursor.description] #esto es igual siempre que hagamos una tabla
        # Recojo los resultados
        self.resultado=cursor.fetchall()

        self.tabla.setColumnCount(len(columnas))
        self.tabla.setRowCount(len(self.resultado))
        self.tabla.setHorizontalHeaderLabels(columnas)

        for fila, registro in enumerate(self.resultado): #recorre todos los resultados
            for col, valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)
                self.tabla.setItem(fila,col,item)


    
          



app = QApplication([])
ventana = MainWindow()
ventana.resize(400,800)
ventana.show()
app.exec()
