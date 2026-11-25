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


        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)
        # Recojo los resultados
        self.resultado=cursor.fetchall()


        #para que salga la opcion1 por defecto
        self.lineEdit.setText(str(self.resultado[0][0]))
        self.lineEdit_2.setText(str(self.resultado[0][1]))
        self.lineEdit_3.setText(str(self.resultado[0][2]))


        #funcionalidad de los botones
        self.pushButton.pressed.connect(self.boton1)
        self.pushButton_4.pressed.connect(self.boton2)
        self.pushButton_3.pressed.connect(self.boton3)
        self.pushButton_2.pressed.connect(self.boton4)

        
        #inicializo los contadores
        self.cont1 = 0
        self.cont2 = 1
        self.cont3 = 2


        self.show()



    #funciones

    def boton1(self):
  
        self.lineEdit.setText(str(self.resultado[0][0]))
        self.lineEdit_2.setText(str(self.resultado[0][1]))
        self.lineEdit_3.setText(str(self.resultado[0][2]))



        
    def boton2(self):

        if(self.cont1 > 0):
            self.lineEdit.setText(str(self.resultado[self.cont1][0]))
            self.lineEdit_2.setText(str(self.resultado[self.cont1][1]))
            self.lineEdit_3.setText(str(self.resultado[self.cont1][2]))
            self.cont1 = self.cont3 - 1
            self.cont2 = self.cont3 - 1
            self.cont3 = self.cont3 - 1




    def boton3(self):
        tamanio = len(self.resultado)-1

        if(self.cont1 < tamanio):
            self.lineEdit.setText(str(self.resultado[self.cont1][0]))
            self.lineEdit_2.setText(str(self.resultado[self.cont1][1]))
            self.lineEdit_3.setText(str(self.resultado[self.cont1][2]))
            self.cont1 = self.cont3 + 1
            self.cont2 = self.cont3 + 1
            self.cont3 = self.cont3 + 1




    def boton4(self):

        tamanio = len(self.resultado)-1

        self.lineEdit.setText(str(self.resultado[tamanio][0]))
        self.lineEdit_2.setText(str(self.resultado[tamanio][1]))
        self.lineEdit_3.setText(str(self.resultado[tamanio][2]))


    
          



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
