# -*- coding: utf-8 -*-
"""
Created on Mon Jun 19 22:38:06 2023

@author: CoupG
"""
import pandas as pd

veriler = pd.read_csv('veriler.csv')

x = veriler.iloc[:,1:4].values
y = veriler.iloc[:,4:].values

from sklearn.model_selection import train_test_split

x_train, x_test, y_train, y_test = train_test_split(x,y,test_size=0.33,random_state=0)

from sklearn.preprocessing import StandardScaler

sc = StandardScaler()

X_train = sc.fit_transform(x_train) #burada fit transform ile öğren ve uygula diyoruz
X_test = sc.transform(x_test) # burada transform ile öğrendiğini uygula diyoruz

from sklearn.linear_model import LogisticRegression
logr = LogisticRegression(random_state = 0)
logr.fit(X_train,y_train)

y_pred = logr.predict(X_test)
print(y_pred)
print(y_test)

from sklearn.metrics import confusion_matrix
cm = confusion_matrix(y_test, y_pred)
print(cm)

from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=1,metric='minkowski')# neighborsun büyük olması kodun daha iyi çalışması anlamına gelmiyo ve minkowski uzaklık ölçme algoritması
knn.fit(X_train,y_train)
y_pred = knn.predict(X_test)

cm = confusion_matrix(y_test, y_pred)
print(cm)

from sklearn.svm import SVC
svc = SVC(kernel='rbf')
svc.fit(X_train, y_train)

y_pred = svc.predict(X_test)
cm = confusion_matrix(y_test, y_pred)
print('SVC')
print(cm)

from sklearn.naive_bayes import GaussianNB # olasılık değerlerini kullanarak yapar
gnb = GaussianNB()
gnb.fit(X_train, y_train)

y_pred = gnb.predict(X_test)
cm = confusion_matrix(y_test, y_pred)
print('Naive-bayes')
print(cm)

from sklearn.tree import DecisionTreeClassifier
dtc = DecisionTreeClassifier(criterion = 'entropy')
dtc.fit(X_train, y_train)
y_pred = dtc.predict(X_test)

cm = confusion_matrix(y_test, y_pred)
print('DTC')
print(cm)

from sklearn.ensemble import RandomForestClassifier
rfc = RandomForestClassifier(n_estimators=10, criterion='entropy')
rfc.fit(X_train, y_train)
y_pred = rfc.predict(X_test)

cm = confusion_matrix(y_test, y_pred)
print('RFC')
print(cm)

#Roc, tpr, fpr değerleri
#değerlerin tam olarak ne işe yaradıklarını anlamasamda şablonda kalsın
y_proba = rfc.predict_proba(X_test)
print(y_test)
print(y_proba[:,0])

from sklearn import metrics
fpr, tpr, thold = metrics.roc_curve(y_test, y_proba[:,0], pos_label='e')
print(fpr)
print(tpr)