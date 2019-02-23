class problem5(object):
    def __init__(self):
        self.string = ""

    def getString(self):
        self.string = input("Enter String: ")

    def printString(self):
        print(self.string.upper())
        
test = problem5()
test.getString()
test.printString()
