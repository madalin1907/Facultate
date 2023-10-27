# import necesary libraries
import numpy as np
from matplotlib import pyplot as plt
from sklearn.neighbors import KNeighborsClassifier
from sklearn import svm


# load train & test data from the .npy files
train_images = np.load("trainImages.npy")
test_images = np.load("testImages.npy")
train_labels = np.load("trainLabels.npy")


# function used for image binarization
def binarization(image, T):
    bins = np.linspace(0, 256, num = 5)
    # print(bins)
    image = np.digitize(image, bins)
    return image


# print shapes of input (testing)
print("Input data shapes:")
print("Train images: " + str(train_images.shape))
print("Test images: " + str(test_images.shape))
print("Train labels: " + str(train_labels.shape))

# plot image 721 (testing)
image = train_images[:, :, 721]
image = np.reshape(image, (28, 28))
plt.imshow(image.astype(np.uint8), cmap='gray')
plt.show()

# try to binarize and plot image 721 (testing)
image = train_images[:, :, 721]
image = binarization(image, 100)
image = np.reshape(image, (28, 28))
plt.imshow(image.astype(np.uint8), cmap='gray')
plt.show()