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


        self.pushButton.pressed.connect(self.boton1)
        self.pushButton_4.pressed.connect(self.boton2)

        
        #self.cargardatos()
        self.cont1 = 0
        self.cont2 = 1
        self.cont3 = 2


        self.show()




    def boton1(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)
        # Recojo los resultados
        resultado=cursor.fetchall()

        
        self.lineEdit.setText(str(resultado[0][0]))
        self.lineEdit_2.setText(str(resultado[0][1]))
        self.lineEdit_3.setText(str(resultado[0][2]))


        
    def boton2(self):
            # Creo el cursor
            cursor = self.con.cursor() 
            sql="SELECT * FROM capitales"
            # Ejecuto la consulta con el cursor
            cursor.execute(sql)
            # Recojo los resultados
            resultado=cursor.fetchall()
    
            
            self.lineEdit.setText(str(resultado[self.cont1][0]))
            self.lineEdit_2.setText(str(resultado[self.cont1][1]))
            self.lineEdit_3.setText(str(resultado[self.cont1][2]))
           #self.cont1 = self.cont3 - 1
           #self.cont2 = self.cont3 - 1
           #self.cont3 = self.cont3 - 1


    
          



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
