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

func twice(_ f, _ x) {
    return twice(f, x);
}
