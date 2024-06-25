# Image Classification using Naive Bayes Classifier

This Python script demonstrates image classification using a Gaussian Naive Bayes classifier. The dataset used contains grayscale images categorized into 'analog' and 'digital'.

## Overview

### Steps:

1. **Dataset Preparation:**
   - The dataset is organized under the directory `D:/Trodo/6y8m379mkt-1/trodo-v01/trodo-v01/new`.
   - Images are loaded using OpenCV (`cv2.imread`) and converted to grayscale.
   - Preprocessing steps include histogram equalization (`cv2.equalizeHist`) and Gaussian blur (`cv2.GaussianBlur`).
   - Images are resized to 15x15 pixels and normalized to [0, 1].

2. **Model Training:**
   - Data is split into training and testing sets using `train_test_split` from `sklearn.model_selection`.
   - A Gaussian Naive Bayes classifier (`GaussianNB` from `sklearn.naive_bayes`) is trained on the training data.

3. **Evaluation:**
   - The trained model predicts labels for the test set.
   - Performance metrics such as confusion matrix and classification report (`confusion_matrix` and `classification_report` from `sklearn.metrics`) are computed and displayed.

## Requirements

- Python 3.x
- OpenCV (`pip install opencv-python`)
- Scikit-learn (`pip install scikit-learn`)
- NumPy (`pip install numpy`)

## Usage

1. Ensure Python and the required libraries are installed.
2. Place your dataset in the directory specified (`D:/Trodo/6y8m379mkt-1/trodo-v01/trodo-v01/new`).
3. Run the script (`image_classification_naive_bayes.py`).
4. View the printed confusion matrix and classification report to evaluate the model's performance.

## Notes

- Adjust the dataset directory (`dataset_dir`) and categories (`categories`) according to your dataset structure.
- Experiment with different preprocessing techniques and model parameters to improve classification accuracy.
- Customize the script for larger datasets by optimizing preprocessing steps and exploring alternative classifiers.
