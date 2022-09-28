import math
import array
import crypto

def change (amt):
    change = [0,0,0,0]

    if type(amt) != int:
        raise TypeError ("Argument must be of type int.")

    if amt < 0:
        raise ValueError ("amount cannot be negative")
    
    if amt >= 25:
        change[0] = math.floor(amt / 25)
        amt = amt % 25
    
    while amt >= 10:
        change[1] += 1
        amt -= 10

    while amt >= 5:
        change [2] += 1
        amt -= 5
    
    change[3] += amt

    return tuple(change)

def stretched (word):
    word = word.replace(" ", "")
    word = word.replace("\n", "")
    word = word.replace("\t", "")
    letters_list = list(word)
    index = list(range(1,len(letters_list)+1))
    letters_list = list(map(lambda x, y : x * y, letters_list, index))
    return ''.join(letters_list)

def powers (**kwargs):
    print(kwargs)
    pow = 0
    ans = 0
    while kwargs['base'] ** pow <= kwargs['limit']:
        ans = kwargs['base'] ** pow
        yield(ans)
        pow += 1


def say(word = None):
  if word == None: return ''
  else:
    return lambda say2 = None : word if say2 == None else say(word + " " + say2)

def find_first_then_lower(func, strings):
    for s in strings:
        if func(s):
            return s.lower()
    raise ValueError

def crypto_functions(using, for_key, with_iv):
    def e(s):
        cipher = crypto.Cipher(using, crypto.MODE_CFB, for_key, iv=with_iv)
        encrypted = cipher.encrypt(s)

        return encrypted.encode("hex")

    def d(s):
        cipher = crypto.Cipher(using, crypto.MODE_CFB, for_key, iv=with_iv)
        decrypted = cipher.decrypt(s.decode("hex"))

        return decrypted

    return [e, d]

def top_ten_scorers (input):
    pass

class Quaternion:
    pass
