# -*- coding: utf-8 -*-
"""
Created on Sun Jun 25 16:17:16 2023

@author: CoupG
"""
import pandas as pd

veriler = pd.read_excel('Iris.xls')

x = veriler.iloc[:,:4].values # values yapınca arraye dönüşüyo
y = veriler.iloc[:,4:5].values

from sklearn.model_selection import train_test_split
x_train,x_test,y_train,y_test = train_test_split(x,y,test_size=0.3,random_state=0)

from sklearn.linear_model import LogisticRegression
lr = LogisticRegression(random_state=0)
lr.fit(x_train, y_train)
y_pred = lr.predict(x_test)

from sklearn.metrics import confusion_matrix
cm = confusion_matrix(y_test, y_pred)
print('Logistic Regression')
print(cm)
#logistic regression 1 adet hata verdi

from sklearn.neighbors import KNeighborsClassifier
kn = KNeighborsClassifier(n_neighbors=1,metric='minkowski')
kn.fit(x_train, y_train)
y_pred = kn.predict(x_test)
cm = confusion_matrix(y_test, y_pred)
print('KN')
print(cm)
#KN 1 adet hata verdi

from sklearn.svm import SVC
svc = SVC(kernel='rbf')
svc.fit(x_train,y_train)
y_pred = svc.predict(x_test)
cm = confusion_matrix(y_test, y_pred)
print('SVM')
print(cm)
#svm 1 adet hata verdi

from sklearn.naive_bayes import GaussianNB
gnb = GaussianNB()
gnb.fit(x_train, y_train)
y_pred = gnb.predict(x_test)
cm = confusion_matrix(y_test, y_pred)
print('Navie-Bayes')
print(cm)
#navie-bayes hiç hata veermedi

from sklearn.tree import DecisionTreeClassifier
dt = DecisionTreeClassifier(criterion='entropy')
dt.fit(x_train, y_train)
y_pred = dt.predict(x_test)
cm = confusion_matrix(y_test, y_pred)
print('Decision Tree')
print(cm)
#Decision Tree 1 adet hata verdi

from sklearn.ensemble import RandomForestClassifier
rfc = RandomForestClassifier(n_estimators=10,criterion='entropy')
rfc.fit(x_train, y_train)
y_pred = rfc.predict(x_test)
cm = confusion_matrix(y_test, y_pred)
print('Random Forest')
print(cm)
#random forest 1 adet hata verdi







#sanırım en iyi ve başarılı algoritma navie-bayes oldu olasılığın gücü adına evde kontrol etmeye devam et