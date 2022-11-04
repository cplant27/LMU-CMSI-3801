import Foundation

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
    static mapThenUnique(inFunction: (Int) -> (Int)){
        for e in self{
            e = inFunction(e)
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

func twice(_ f, _ x) {
    return twice(f, x);
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
        var coefficientArray:[Double] = [q.a, q.b, q.c, q.d]
        return coefficientArray
    }
}

//Addition
extension Quaternion {
    static func + (left: Quaternion, right: Quaternion) -> Quaternion {
        return [
            left.a + right.a,
            left.b + right.b,
            left.c + right.c,
            left.d + right.d
        ]
    }
}

//Subtraction
extension Quaternion {
    static func - (left: Quaternion, right: Quaternion) -> Quaternion {
        return [
            left.a - right.a,
            left.b - right.b,
            left.c - right.c,
            left.d - right.d
        ]
    }
}

//Multiplication
extension Quaternion {
    static func * (left: Quaternion, right: Quaternion) -> Quaternion {
        return [
            left.a * right.a,
            left.b * right.b,
            left.c * right.c,
            left.d * right.d
        ]
    }
}