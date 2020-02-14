# Neural Numbers

An application of a Neural Network trained to recognize hand drawn digits between 0 and 9. It supports both both the testing data
provided or the ability to hand draw your own digits. Trained using 60,000 hand drawn digits this application has been able to
reach detection rates of 92% with provided test set. It's also able to detect custom drawn digits with and accuracy of about
60%.

## Getting Started

Clone the repository and run the program or download the provided jar and run it in the same directory as the .csv files.  
[NeuralNumbers.jar](https://github.com/budde25/NeuralNumbers/releases/latest)  

### Usage

Run the program and enter one of the folling commands when prompted:  
`1` to train the network with training data.  
`2 <1 - 10,000, all>` to test the network at a specified digit or all the digits.  
`3 <1 - 10,000>` to display a digit in a popup window.  
`4 <name>` to save the network as the specfied file.
`5 <name>` to load the network from the specfied file.  
`6` to draw a digit in a popup and have the network figure out what it is. 


## Built With
* [Neural Network Library](https://github.com/budde25/NeuralNetworkLibrary) - Custom nerual network libary.  
* [Processing Library](https://processing.org/) - Canvas drawing suppport.  
* [MNIST dataset](http://yann.lecun.com/exdb/mnist/) - Training and testing dataset.  

## Author
Ethan Budd
