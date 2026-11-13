from Ej1 import Ui_MainWindow
import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication



class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)



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

        
        self.cargardatos()



        self.show()






    def cargardatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)
        # Recojo los resultados
        resultado=cursor.fetchall()

        
        # row[0] es la primera columna, row[1] la segunda, etc.
        # Es obligatorio convertirlo a texto con str() por si es un número
        self.lineEdit.setText(str(resultado[0][0]))
        self.lineEdit_2.setText(str(resultado[0][1]))
        self.lineEdit_3.setText(str(resultado[0][2]))
          



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
