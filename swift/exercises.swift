import Foundation

enum NegativeAmountError: Error {
  case negative
}
 
func change(_ change: Int) -> Result<(Int,Int,Int,Int), NegativeAmountError> {
  
    guard change >= 0 else {
        return .failure(.negative)
    }

    var currentAmount = change
    let coinType = [25, 10, 5, 1]
    var changeAmount = [Int]()

    for coinValue in coinType {
        let (numCoins, _) = currentAmount.quotientAndRemainder(dividingBy: coinValue)
        changeAmount.append(numCoins)
        currentAmount -= coinValue * numCoins
    }
    return .success((changeAmount[0], changeAmount[1], changeAmount[2], changeAmount[3]))
}

func stretched(_ phrase : String) -> String {
    var stretchPhrase = phrase.replacingOccurrences(of:" ", with: "").lowercased()
    var letterList : [String] = stretchPhrase.split{$0 == ""}.map(String.init)
    do {
        var index : Int = 0
        while (index < letterList.count) {
            var check : Int = index
            let letter : String = letterlist[index]
            while (check > 0) {
                letterList[index] += letter
                check -= 1
            }
            index += 1
        }
    }
    return String.join("", &letterList)
}

extension Array {
    func mapThenUnique(mapFunc: (Int) -> (Int))  -> (Set<Int>) {
        for e in self{
            e = mapFunc(e)
        }
        return Set(self)
    }
}

func powers (of: Int, through: Int, then f: (Int) -> String) -> Int {
    var num = 0
    var power = 0
    while (num <= through) {
        num = pow(of, power) as Int
        f(num)
        power++
    }
}

protocol Animal {
    var name: String { get }
    var sound: String { get }
}

extension Animal{
    func speak() -> (String) {
        return self.name + " says " + self.sound
    }
}

struct Horse: Animal {
    let name: String 
    let sound = "neigh"
}

struct Cow: Animal {
    let name: String
    let sound = "moooo"
}

struct Sheep: Animal {
    let name: String
    let sound = "baaaa"
}

class say {
    init(_ phrase: String) {
        self.phrase = phrase
    }
    func and(_ phrase: String) {
        self.phrase = self.phrase + phrase
    }
}

func twice(x: Any, function: (Any) -> Any) -> Any {
    return function(function(x));
}

func uppercasedFirst (of: String, longerThan: Int) -> String {
    if let string = of.first(where: {$0.count >= longerThan})? {
        return string.uppercased()
    } else {
        return nil
    }

}


//Main struct
struct Quaternion {
    let a: Double
    let b: Double
    let c: Double
    let d: Double

    static var ZERO = Quaternion(a: 0, b: 0, c: 0, d: 0)
    static var K = Quaternion(a: 0, b: 0, c: 0, d: 1)
}

//String Format
extension Quaternion: CustomStringConvertible {
  var description: String {
    return "\(a), \(b)i, \(c)j, \(d)k"
  }
}

//Coefficients
extension Quaternion {
    static func coefficients (q: Quaternion) -> Array<Double> {
        let coefficientArray:[Double] = [q.a, q.b, q.c, q.d]
        return coefficientArray
    }
}

//Addition
extension Quaternion {
    static func + (left: Quaternion, right: Quaternion) -> Quaternion {
        return Quaternion(a: left.a + right.a, b: left.b + right.b, c: left.c + right.c, d: left.d + right.d)
    }
}

//Subtraction
extension Quaternion {
    static func - (left: Quaternion, right: Quaternion) -> Quaternion {
        return Quaternion(a: left.a - right.a, b: left.b - right.b, c: left.c - right.c, d: left.d - right.d)
    }
}

//Multiplication
extension Quaternion {
    static func * (left: Quaternion, right: Quaternion) -> Quaternion {
        return Quaternion(a: left.a * right.a, b: left.b * right.b, c: left.c * right.c, d: left.d * right.d)
    }
}
