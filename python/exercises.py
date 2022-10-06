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
    ans = 0
    while kwargs['base'] ** exp <= kwargs['limit']:
        ans = kwargs['base'] ** exp
        yield(ans)
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
       fernet.encrypt(s.encode()) 
    def decode(s):
        fernet.decrypt(encode(s)).decode()
    return [encode, decode]

def top_ten_scorers (input):
    pass

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

    def coefficients(self):
        answer = (self.co1, self.co2, self.co3, self.co4)
        return answer

        
