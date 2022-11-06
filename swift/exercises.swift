import Foundation

struct Results{

  var coins = (0,0,0,0)
  var success = false
  
}
 
func change(cents : Int) -> (Result) {

    var cents = cents
    var quarters = 0
    var dimes = 0
    var nickles = 0
    var pennies = 0
    let result = Results()
    
    if (cents < 0) {
        return result
    } else {
        result.success = true
    }
    
    while (cents >= 25){
        quarters = quarters + 1
        cents = cents - 25
    }
    
    result.coins.0 = quarters
    
    while (cents >= 10){
        dimes = dimes + 1
        cents = cents - 10
    }
    
        result.coins.1 = dimes

    while (cents >= 5){
        nickles = nickles + 1
        cents = cents - 5
    }

    result.coins.2 = nickles

    while (cents >= 1){
        pennies = pennies + 1
        cents = cents - 1
    }

    result.coins.3 = pennies

    return result

}

static func stretched(_ phrase : String) -> String {
    phrase = phrase.replacingOccurrences(of:" ", with: "").lowercased();
    let letterList : [String] = phrase.split{$0 == ""}.map(String.init);
    do {
        var index : Int = 0;
        while (index < letterList.count) {
            var check : Int = index;
            let letter : String = letterlist[index];
            while (check > 0) {
                letterList[index] += letter;
                check -= 1;
            }
            index += 1;
        }
    }
    return String.join("", &letterList);
}

extension Array {
    static mapThenUnique(mapFunc: (Int) -> (Int)){
        for e in self{
            e = mapFunc(e)
        }
        return Set(self)
    }
}

protocol Animal {
    init(name: String, sound: String) {
        self.name = name
        self.sound = sound
    }
    var expression : String {
        return name + " says " + sound
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
