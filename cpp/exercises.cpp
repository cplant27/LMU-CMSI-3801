#include <stdio.h>
#include <math.h>

int dot(valarray<double> vector1, valarray<double> vector2){
    int total = 0;
    for (int i = 0; i < vector1.size(); i++){
        total += vector1[i] * vector2[i]
    }
    return total
}

vector<int> stretched_positives(vector<int> vecToStretch){
    stretchedVec = new vector<int>
    copy_if(vecToStretch.begin(), vecToStretch.end(), std::back_inserter(stretched_vec), [](int i) {
    return i != 0;
	});
    //for each loop that duplicates numbers
}

vector<pair<string, int>> sorted_word_counts(list<string> words) {
  map<string, int> counts;
  for (string word : words) {
    counts[word]++;
  }
  auto value_descending = [](auto x, auto y) { return y.second < x.second; };
  vector<pair<string, int>> pairs(counts.begin(), counts.end());
  sort(pairs.begin(), pairs.end(), value_descending);
  return pairs;
}

void powers(int base, int limit, function<void(int)> consumer) {
	int power = 0;
	int out = 0;
	while (pow(base, power) <= limit) {
		out = pow(base, power);
		consumer(out);
		power++;
	}
}
