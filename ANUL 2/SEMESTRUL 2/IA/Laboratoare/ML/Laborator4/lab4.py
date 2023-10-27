import numpy as np

train_labels = np.load('data/training_labels.npy', allow_pickle=True)
train_sentences = np.load('data/training_sentences.npy', allow_pickle=True)
test_labels = np.load('data/test_labels.npy', allow_pickle=True)
test_sentences = np.load('data/test_sentences.npy', allow_pickle=True)



# Exercitiul 2. Normalizarea datelor de antrenare si de testare

def normalize_data(train_data, test_data, type=None):
    if type is None:
        return train_data, test_data
    elif type.lower() == 'standard':
        train_mean = np.mean(train_data, axis=1)
        train_deviation = np.std(train_data, axis=1)

        normalized_train = (train_data - train_mean) / train_deviation
        normalized_test = (test_data - train_mean) / train_mean

        return normalized_train, normalized_test
    elif type.lower() == 'l1':
        train_norm = np.linalg.norm(train_data, ord=1, axis=1)
        test_norm = np.linalg.norm(test_data, ord=1, axis=1)

        normalized_train = train_data / train_norm
        normalized_test = test_data / test_norm

        return normalized_train, normalized_test
    elif type.lower() == 'l2':
        train_norm = np.linalg.norm(train_data, ord=2, axis=0)
        test_norm = np.linalg.norm(test_data, ord=2, axis=0)

        normalized_train = train_data / train_norm
        normalized_test = test_data / test_norm

        return normalized_train, normalized_test
    else:
        raise Exception('Invalid normalization type')


# testing

train_matrix = np.random.rand(10, 10)
test_matrix = np.random.rand(10, 10)

print (train_matrix, "\n\n\n")
print (test_matrix, "\n\n\n")

print (normalize_data(train_matrix, test_matrix, 'l1'))




# Exercitiile 3 & 4. Clasa BagOfWords

class BagOfWords:
    def __init__(self):
        self.vocabulary = {}
        self.order = []
    
    def build_vocabulary(self, data):
        index = 0
        for sentence in data:
            for word in sentence:
                if word not in self.vocabulary:
                    self.vocabulary[word] = index
                    self.order.append(word)
                    index += 1

    def get_features(self, data):
        features = np.zeros((len(data), len(self.vocabulary)))
        for i in range(len(data)):
            for word in data[i]:
                if word in self.vocabulary:
                    features[i, self.vocabulary[word]] += 1
        return features

# # testing for ex. 3
# train_s = BagOfWords()
# train_s.build_vocabulary(train_sentences)
# print(train_s.vocabulary, "\n\n")

# # testing for ex. 4
# print(train_s.get_features(train_sentences), "\n\n")


# Exercitiul 5. BOW for train and test data + l1 normalization

train_bow = BagOfWords()
train_bow.build_vocabulary(train_sentences)
train_features = train_bow.get_features(train_sentences)
test_features = train_bow.get_features(test_sentences)

train_features, test_features = normalize_data(train_features, test_features, 'l1')

# print(train_features, "\n\n\n")
# print(test_features, "\n\n\n")



# Exercitiul 6. 

from sklearn import svm
import sklearn

training = svm.SVC(C = 1, kernel = 'linear')
training.fit(train_features, train_labels)

predictions = training.predict(test_features)

print (sklearn.metrics.f1_score(predictions, test_labels))