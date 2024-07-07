import time  # For timing model training
import numpy as np  # Multidimensional arrays
import pandas as pd  # Data frames & manipulation (built on NumPy)
import matplotlib.pyplot as plt  # Plotting
import seaborn as sns  # Plotting (built on matplotlib)
import sklearn  # Machine learning
from sklearn.model_selection import train_test_split  # Splitting data between the training and testing set

# Rendering plots within the Jupyter notebook

# Importing the dataset
df = sns.load_dataset('mpg').dropna()
print('Data frame shape:', df.shape)  # Reporting on the number of observations
df.head()  # Previewing the data frame



from sklearn.linear_model import LinearRegression

# Assigning the features and labels to variables before splitting them
# Note: We're discarding the origin (discrete/categorical variable) and model_year (ordinal)
#       for simplicity in this example.

features = df[['cylinders', 'displacement', 'horsepower', 'weight', 'acceleration']]
label = df['mpg']

# Splitting the observations into a training and a testing set for the holdout method
# Note: k-folds cross validation should be used for a dataset this small in order
#       to obtain a more realistic accuracy. This won't be used for simplicity
#       in this example.
X_train, X_test, y_train, y_test = train_test_split(features, label,
                                                    test_size=0.30, random_state=46)

# Instantiating the model
linear_regression_model = LinearRegression()

# Fitting the model and timing how long it takes
start_time = time.time()
linear_regression_model.fit(X_train, y_train)
end_time = time.time()

# Calculating the root mean squared error (RMSE) of our model
predictions = linear_regression_model.predict(X_test)  # Creating predictions for the test set
mse = sklearn.metrics.mean_squared_error(y_test, predictions)  # Calculating the mean squared error
rmse = np.sqrt(mse)  # Getting the square root of the mean squared error

# Reporting how long it takes to fit the model
print('Total time to fit the model:', end_time - start_time)

# Reporting the root mean squared error (RMSE)
print('RMSE:', rmse)