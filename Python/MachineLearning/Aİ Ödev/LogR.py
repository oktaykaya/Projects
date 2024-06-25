import os
from skimage.io import imread
from skimage.transform import resize
import numpy as np
import cv2
from sklearn.model_selection import train_test_split
from sklearn.model_selection import GridSearchCV
from sklearn.svm import SVC
from sklearn.metrics import confusion_matrix, classification_report

dataset_dir = "D:/Trodo/6y8m379mkt-1/trodo-v01/trodo-v01/new"
categories = ['analog', 'digital']
data = []
labels = []

for category_idx, category in enumerate(categories):
    for file in os.listdir(os.path.join(dataset_dir, category)):
        img_path = os.path.join(dataset_dir, category, file)
        img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
        img = cv2.equalizeHist(img)
        img = cv2.GaussianBlur(img, (5, 5), 0)
        img = cv2.resize(img, (15, 15))
        img = img / 255.0  # Normalization
        data.append(img.flatten())
        labels.append(category_idx)

data = np.asarray(data)
labels = np.asarray(labels)

x_train, x_test, y_train, y_test = train_test_split(data, labels, test_size=0.2, shuffle=True, stratify=labels)


from sklearn.linear_model import LogisticRegression
logr = LogisticRegression(random_state = 0)
logr.fit(x_train,y_train)
y_pred = logr.predict(x_test)

# Confusion matrix ve diğer metrikleri hesapla
conf_matrix = confusion_matrix(y_test, y_pred)
rapor = classification_report(y_test, y_pred, target_names=categories)

print("Confusion Matrix:")
print(conf_matrix)
print("\nClassification Report:")
print(rapor)
