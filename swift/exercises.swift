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
