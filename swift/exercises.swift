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
    var stretch = phrase.replacingOccurrences(of: " ", with: "").lowercased().split(separator: "")
    var stretched = ""

    for c in stretch{
        var i = 0
        while i <= c.index {
            stretched = stretched + c 
            i -= 1
        }
    }
    return stretched
}

extension Array {
    func mapThenUnique<T>(mapFunc: (Element) -> T )  -> Set<T> {
        return Set(self.map(mapFunc))
    }
}

func powers (of: Int, through: Int, then: (Int) -> Void){
    var num = 1
    while (num <= through) {
        then(num)
        num = num * of
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
    var phrase: String
    init(_ phrase: String) {
        self.phrase = phrase
    }
    func and(_ phrase: String) -> say {
        return say(self.phrase + phrase) 
    }
}

func twice(x: Any, function: (Any) -> Any) -> Any {
    return function(function(x));
}

func uppercasedFirst (of: [String], longerThan: Int) -> String? {
    for e in of{
        if e.count > longerThan{
            return e
        }
    }
    return nil
}


//Main struct
struct Quaternion {
    let a: Double
    let b: Double
    let c: Double
    let d: Double

    static var ZERO = Quaternion(a: 0, b: 0, c: 0, d: 0)
    static var K = Quaternion(a: 0, b: 0, c: 0, d: 1)
    static var I = Quaternion(a: 0, b: 0, c: 0, d: 0)
    static var J = Quaternion(a: 0, b: 0, c: 0, d: 1)
}

//String Format
extension Quaternion: CustomStringConvertible {
  var description: String {
    return "\(a), \(b)i, \(c)j, \(d)k"
  }
}

//Coefficients
extension Quaternion {
    static func coefficients (q: Quaternion) -> IndexSet {
        let coefficientArray:[Double] = [q.a, q.b, q.c, q.d]
        return coefficientArray
    }
}

//Equals
extension Quaternion: Equatable {
    static func == (left: Quaternion, right: Quaternion) -> Bool {
        return 
            left.a == right.a && 
            left.b == right.b && 
            left.c == right.c && 
            left.d == right.d
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
