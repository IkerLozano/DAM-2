# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'untitled.ui'
##
## Created by: Qt User Interface Compiler version 6.12.0
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QComboBox, QGroupBox, QHBoxLayout,
    QLabel, QLineEdit, QMainWindow, QMenuBar,
    QPushButton, QSizePolicy, QSpinBox, QStatusBar,
    QTextEdit, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(800, 820)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(220, 50, 410, 574))
        self.verticalLayout_4 = QVBoxLayout(self.widget)
        self.verticalLayout_4.setObjectName(u"verticalLayout_4")
        self.verticalLayout_4.setContentsMargins(0, 0, 0, 0)
        self.groupBox = QGroupBox(self.widget)
        self.groupBox.setObjectName(u"groupBox")
        self.horizontalLayout = QHBoxLayout(self.groupBox)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.pushButton = QPushButton(self.groupBox)
        self.pushButton.setObjectName(u"pushButton")

        self.horizontalLayout.addWidget(self.pushButton)

        self.pushButton_2 = QPushButton(self.groupBox)
        self.pushButton_2.setObjectName(u"pushButton_2")

        self.horizontalLayout.addWidget(self.pushButton_2)

        self.pushButton_3 = QPushButton(self.groupBox)
        self.pushButton_3.setObjectName(u"pushButton_3")

        self.horizontalLayout.addWidget(self.pushButton_3)

        self.pushButton_4 = QPushButton(self.groupBox)
        self.pushButton_4.setObjectName(u"pushButton_4")

        self.horizontalLayout.addWidget(self.pushButton_4)


        self.verticalLayout_4.addWidget(self.groupBox)

        self.groupBox1 = QGroupBox(self.widget)
        self.groupBox1.setObjectName(u"groupBox1")
        self.horizontalLayout_8 = QHBoxLayout(self.groupBox1)
        self.horizontalLayout_8.setObjectName(u"horizontalLayout_8")
        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.label_8 = QLabel(self.groupBox1)
        self.label_8.setObjectName(u"label_8")

        self.horizontalLayout_2.addWidget(self.label_8)

        self.lineEdit_7 = QLineEdit(self.groupBox1)
        self.lineEdit_7.setObjectName(u"lineEdit_7")

        self.horizontalLayout_2.addWidget(self.lineEdit_7)


        self.verticalLayout.addLayout(self.horizontalLayout_2)

        self.horizontalLayout_6 = QHBoxLayout()
        self.horizontalLayout_6.setObjectName(u"horizontalLayout_6")
        self.label_7 = QLabel(self.groupBox1)
        self.label_7.setObjectName(u"label_7")

        self.horizontalLayout_6.addWidget(self.label_7)

        self.lineEdit_6 = QLineEdit(self.groupBox1)
        self.lineEdit_6.setObjectName(u"lineEdit_6")

        self.horizontalLayout_6.addWidget(self.lineEdit_6)


        self.verticalLayout.addLayout(self.horizontalLayout_6)

        self.horizontalLayout_7 = QHBoxLayout()
        self.horizontalLayout_7.setObjectName(u"horizontalLayout_7")
        self.label_9 = QLabel(self.groupBox1)
        self.label_9.setObjectName(u"label_9")

        self.horizontalLayout_7.addWidget(self.label_9)

        self.lineEdit_5 = QLineEdit(self.groupBox1)
        self.lineEdit_5.setObjectName(u"lineEdit_5")

        self.horizontalLayout_7.addWidget(self.lineEdit_5)


        self.verticalLayout.addLayout(self.horizontalLayout_7)


        self.horizontalLayout_8.addLayout(self.verticalLayout)

        self.textEdit_3 = QTextEdit(self.groupBox1)
        self.textEdit_3.setObjectName(u"textEdit_3")

        self.horizontalLayout_8.addWidget(self.textEdit_3)


        self.verticalLayout_4.addWidget(self.groupBox1)

        self.verticalLayout_3 = QVBoxLayout()
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.label_4 = QLabel(self.widget)
        self.label_4.setObjectName(u"label_4")

        self.horizontalLayout_3.addWidget(self.label_4)

        self.lineEdit_4 = QLineEdit(self.widget)
        self.lineEdit_4.setObjectName(u"lineEdit_4")

        self.horizontalLayout_3.addWidget(self.lineEdit_4)


        self.verticalLayout_2.addLayout(self.horizontalLayout_3)

        self.horizontalLayout_4 = QHBoxLayout()
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.label_5 = QLabel(self.widget)
        self.label_5.setObjectName(u"label_5")

        self.horizontalLayout_4.addWidget(self.label_5)

        self.comboBox = QComboBox(self.widget)
        self.comboBox.setObjectName(u"comboBox")

        self.horizontalLayout_4.addWidget(self.comboBox)


        self.verticalLayout_2.addLayout(self.horizontalLayout_4)

        self.horizontalLayout_5 = QHBoxLayout()
        self.horizontalLayout_5.setObjectName(u"horizontalLayout_5")
        self.label_6 = QLabel(self.widget)
        self.label_6.setObjectName(u"label_6")

        self.horizontalLayout_5.addWidget(self.label_6)

        self.spinBox_2 = QSpinBox(self.widget)
        self.spinBox_2.setObjectName(u"spinBox_2")

        self.horizontalLayout_5.addWidget(self.spinBox_2)


        self.verticalLayout_2.addLayout(self.horizontalLayout_5)


        self.verticalLayout_3.addLayout(self.verticalLayout_2)

        self.textEdit_2 = QTextEdit(self.widget)
        self.textEdit_2.setObjectName(u"textEdit_2")

        self.verticalLayout_3.addWidget(self.textEdit_2)


        self.verticalLayout_4.addLayout(self.verticalLayout_3)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 800, 33))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.groupBox.setTitle(QCoreApplication.translate("MainWindow", u"Botones", None))
        self.pushButton.setText(QCoreApplication.translate("MainWindow", u"Boton1", None))
        self.pushButton_2.setText(QCoreApplication.translate("MainWindow", u"Boton2", None))
        self.pushButton_3.setText(QCoreApplication.translate("MainWindow", u"Boton3", None))
        self.pushButton_4.setText(QCoreApplication.translate("MainWindow", u"Boton4", None))
        self.groupBox1.setTitle(QCoreApplication.translate("MainWindow", u"Textos", None))
        self.label_8.setText(QCoreApplication.translate("MainWindow", u"Linea 1", None))
        self.label_7.setText(QCoreApplication.translate("MainWindow", u"Linea 2", None))
        self.label_9.setText(QCoreApplication.translate("MainWindow", u"Linea 3", None))
        self.label_4.setText(QCoreApplication.translate("MainWindow", u"Texto", None))
        self.label_5.setText(QCoreApplication.translate("MainWindow", u"Lista", None))
        self.label_6.setText(QCoreApplication.translate("MainWindow", u"Numero", None))
    # retranslateUi

