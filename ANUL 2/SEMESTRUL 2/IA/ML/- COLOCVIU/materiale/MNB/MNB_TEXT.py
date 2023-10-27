import numpy as np
from sklearn.naive_bayes import MultinomialNB, GaussianNB
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics import classification_report

# Load the data
test_data = np.load('../model_2022/test_data.npy')
train_data_full = np.load('../model_2022/train_data.npy')
train_labels_full = np.load('../model_2022/train_labels.npy')

mock_train_data = train_data_full[:700]
mock_train_labels = train_labels_full[:700]

mock_val_data = train_data_full[700:]
mock_val_labels = train_labels_full[700:]

# Create a vectorizer
vectorizer = CountVectorizer()
vectorizer.fit(mock_train_data)

# Transform the data
mock_train_data = vectorizer.transform(mock_train_data)
mock_val_data = vectorizer.transform(mock_val_data)

for alpha in [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2]:
    # Create a Naive Bayes classifier
    nb = MultinomialNB(alpha=alpha)
    nb.fit(mock_train_data, mock_train_labels)

    # Predict the labels of the test data
    predicted_labels = nb.predict(mock_val_data)

    # Compute accuracy
    accuracy = np.mean(predicted_labels == mock_val_labels)

    print('Accuracy: ', accuracy, 'alpha: ', alpha)

    # Print a classification report
    print(classification_report(mock_val_labels, predicted_labels))