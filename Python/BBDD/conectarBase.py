import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication


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
            print("error")

        self.cargardatos()


    def cargardatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)
        # Recojo los resultados
        resultado=cursor.fetchall()

        # recorro los resultados y los imprimir
        for row in resultado:
            print(row)



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
