import math
import array
from cryptography.fernet import Fernet

def change (amt):
    Q = 25
    D = 10
    N = 5
    if type(amt) != int:
        raise TypeError ("Argument must be of type int.")
    if amt < 0:
        raise ValueError ("amount cannot be negative")    
    if amt >= Q:
        num_Q = math.floor(amt / Q)
        amt = amt % Q  
    if amt >= D:
        num_D = math.floor(amt / D)
        amt = amt % D
    if amt >= N:
        num_N = math.floor(amt / N)
        amt = amt % N
    num_P = amt
    return tuple([num_Q, num_D, num_N, num_P])

def stretched (phrase):
    phrase = phrase.replace(" ", "")
    phrase = phrase.replace("\n", "")
    phrase = phrase.replace("\t", "")
    letters_list = list(phrase)
    index = list(range(1,len(letters_list)+1))
    letters_list = list(map(lambda x, y : x * y, letters_list, index))
    return ''.join(letters_list)

def powers (**kwargs):
    exp = 0
    pow = 0
    while kwargs['base'] ** exp <= kwargs['limit']:
        ans = kwargs['base'] ** exp
        yield(pow)
        exp += 1


def say(word = None):
  if word == None: return ''
  else:
    return lambda say2 = None : word if say2 == None else say(word + " " + say2)

def find_first_then_lower(func, strings):
    for s in strings:
        if func(s):
            return s.lower()
    raise ValueError

def crypto_functions():
    key = Fernet.generate_key()
    fernet = Fernet(key)
    def encode(s):
        encoded = fernet.encrypt(s) 
        return encoded
    def decode(s):
        decoded = fernet.decrypt(s)
        return decoded
    return [encode, decode]

def top_ten_scorers (input):
    leaderboard = []
    holdBoard=[]
    for x, y in input.items():
        if len(y[0]) >= 2:
            for i in y : 
                if i[1] >= 15:
                    var1 = (i[0])
                    var2 = str("{:.2f}".format(i[2]/i[1]))
                    var2Fl = ("{:.2f}".format(i[2]/i[1]))
                    var3 = x
                    finalList = [var1, var2Fl, var3]

                    def sortSecond(val):
                        return val[1]

                    holdBoard.append(finalList)
                    holdBoard.sort(key = sortSecond, reverse=True)
    holdBoard2 = holdBoard[0:10]
    for i in holdBoard2:
        var1 = (i[0])
        var2 = str(i[1])
        var3 = i[2]
        finalStr = var1 + "|" + var2 + "|" + var3
        leaderboard.append(finalStr)
        
    if leaderboard == [] :
        return []
    else:
        return leaderboard

class Quaternion:
    def __init__(self, a, b, c, d):
        self.co1 = a
        self.co2 = b
        self.co3 = c
        self.co4 = d

    def __add__(self, q):
        answer = Quaternion(self.co1 + q.co1, self.co2 + q.co2, self.co3 + q.co3, self.co4 + q.co4)
        return answer


    def __mul__(self, q):
        ans1 = self.co1 * q.co1 - self.co2 * q.co2 - self.co3 * q.co3 - self.co4 * q.co4
        ans2 = self.co1 * q.co2 + self.co2 * q.co1 + self.co3 * q.co4 - self.co4 * q.co3
        ans3 = self.co1 * q.co3 - self.co2 * q.co4 + self.co3 * q.co1 + self.co4 * q.co2
        ans4 = self.co1 * q.co4 + self.co2 * q.co3 - self.co3 * q.co2 + self.co4 * q.co1
        return Quaternion(ans1, ans2, ans3, ans4)

    @property
    def coefficients(self):
        answer = (self.co1, self.co2, self.co3, self.co4)
        return answer

        
