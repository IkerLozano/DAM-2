# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'Ej4.ui'
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
from PySide6.QtWidgets import (QApplication, QCheckBox, QComboBox, QGridLayout,
    QHBoxLayout, QLabel, QLineEdit, QMainWindow,
    QMenuBar, QPushButton, QRadioButton, QSizePolicy,
    QSpacerItem, QStatusBar, QTextEdit, QVBoxLayout,
    QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(800, 885)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(60, 70, 440, 594))
        self.verticalLayout_2 = QVBoxLayout(self.widget)
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.verticalLayout_2.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.label = QLabel(self.widget)
        self.label.setObjectName(u"label")

        self.horizontalLayout.addWidget(self.label)

        self.lineEdit = QLineEdit(self.widget)
        self.lineEdit.setObjectName(u"lineEdit")

        self.horizontalLayout.addWidget(self.lineEdit)


        self.verticalLayout_2.addLayout(self.horizontalLayout)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.label_2 = QLabel(self.widget)
        self.label_2.setObjectName(u"label_2")

        self.horizontalLayout_2.addWidget(self.label_2)

        self.lineEdit_2 = QLineEdit(self.widget)
        self.lineEdit_2.setObjectName(u"lineEdit_2")

        self.horizontalLayout_2.addWidget(self.lineEdit_2)


        self.verticalLayout_2.addLayout(self.horizontalLayout_2)

        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.label_3 = QLabel(self.widget)
        self.label_3.setObjectName(u"label_3")

        self.horizontalLayout_3.addWidget(self.label_3)

        self.textEdit = QTextEdit(self.widget)
        self.textEdit.setObjectName(u"textEdit")

        self.horizontalLayout_3.addWidget(self.textEdit)


        self.verticalLayout_2.addLayout(self.horizontalLayout_3)

        self.horizontalLayout_4 = QHBoxLayout()
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.textEdit_2 = QTextEdit(self.widget)
        self.textEdit_2.setObjectName(u"textEdit_2")

        self.horizontalLayout_4.addWidget(self.textEdit_2)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.pushButton = QPushButton(self.widget)
        self.pushButton.setObjectName(u"pushButton")

        self.verticalLayout.addWidget(self.pushButton)

        self.pushButton_3 = QPushButton(self.widget)
        self.pushButton_3.setObjectName(u"pushButton_3")

        self.verticalLayout.addWidget(self.pushButton_3)

        self.pushButton_4 = QPushButton(self.widget)
        self.pushButton_4.setObjectName(u"pushButton_4")

        self.verticalLayout.addWidget(self.pushButton_4)

        self.pushButton_2 = QPushButton(self.widget)
        self.pushButton_2.setObjectName(u"pushButton_2")

        self.verticalLayout.addWidget(self.pushButton_2)


        self.horizontalLayout_4.addLayout(self.verticalLayout)


        self.verticalLayout_2.addLayout(self.horizontalLayout_4)

        self.gridLayout = QGridLayout()
        self.gridLayout.setObjectName(u"gridLayout")
        self.radioButton_2 = QRadioButton(self.widget)
        self.radioButton_2.setObjectName(u"radioButton_2")

        self.gridLayout.addWidget(self.radioButton_2, 4, 0, 1, 1)

        self.checkBox = QCheckBox(self.widget)
        self.checkBox.setObjectName(u"checkBox")

        self.gridLayout.addWidget(self.checkBox, 0, 1, 1, 1)

        self.comboBox = QComboBox(self.widget)
        self.comboBox.setObjectName(u"comboBox")

        self.gridLayout.addWidget(self.comboBox, 0, 2, 1, 1)

        self.radioButton = QRadioButton(self.widget)
        self.radioButton.setObjectName(u"radioButton")

        self.gridLayout.addWidget(self.radioButton, 0, 0, 1, 1)

        self.radioButton_3 = QRadioButton(self.widget)
        self.radioButton_3.setObjectName(u"radioButton_3")

        self.gridLayout.addWidget(self.radioButton_3, 5, 0, 1, 1)

        self.pushButton_7 = QPushButton(self.widget)
        self.pushButton_7.setObjectName(u"pushButton_7")

        self.gridLayout.addWidget(self.pushButton_7, 5, 1, 1, 2)


        self.verticalLayout_2.addLayout(self.gridLayout)

        self.horizontalLayout_5 = QHBoxLayout()
        self.horizontalLayout_5.setObjectName(u"horizontalLayout_5")
        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_5.addItem(self.horizontalSpacer)

        self.pushButton_6 = QPushButton(self.widget)
        self.pushButton_6.setObjectName(u"pushButton_6")

        self.horizontalLayout_5.addWidget(self.pushButton_6)

        self.pushButton_5 = QPushButton(self.widget)
        self.pushButton_5.setObjectName(u"pushButton_5")

        self.horizontalLayout_5.addWidget(self.pushButton_5)


        self.verticalLayout_2.addLayout(self.horizontalLayout_5)

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
        self.label.setText(QCoreApplication.translate("MainWindow", u"Nombre", None))
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"Apellidos", None))
        self.label_3.setText(QCoreApplication.translate("MainWindow", u"Bloc de notas", None))
        self.pushButton.setText(QCoreApplication.translate("MainWindow", u"Borar", None))
        self.pushButton_3.setText(QCoreApplication.translate("MainWindow", u"Duplicar", None))
        self.pushButton_4.setText(QCoreApplication.translate("MainWindow", u"Mostrar", None))
        self.pushButton_2.setText(QCoreApplication.translate("MainWindow", u"Listado", None))
        self.radioButton_2.setText(QCoreApplication.translate("MainWindow", u"Me hes indiferente", None))
        self.checkBox.setText(QCoreApplication.translate("MainWindow", u"Selecconame", None))
        self.radioButton.setText(QCoreApplication.translate("MainWindow", u"No me gusta esta distribuicion", None))
        self.radioButton_3.setText(QCoreApplication.translate("MainWindow", u"Me encanta como esta distribuido todo", None))
        self.pushButton_7.setText(QCoreApplication.translate("MainWindow", u"Soy un boton de ocupa 2 celdas", None))
        self.pushButton_6.setText(QCoreApplication.translate("MainWindow", u"Ok", None))
        self.pushButton_5.setText(QCoreApplication.translate("MainWindow", u"Cancel", None))
    # retranslateUi

