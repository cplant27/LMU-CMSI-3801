#include <stdio.h>
#include <math.h>
#include <iostream>
#include <list>
#include <string>
#include <vector>
#include <array>
#include <valarray>
#include <map>
#include <memory>
#include "exercises.h"

using namespace std;

// g++ -std=c++2a -o runcpptests exercises.cpp exercises.test.cpp && ./runcpptests

double dot(valarray<double> a, valarray<double> b) {
  int total = 0;
  for (int i = 0; i < a.size(); i++){
      total += a[i] * b[i];
  }
  return total;
}

vector<int> stretched_positives(vector<int> v) {
  vector<int> positivesVec;
  copy_if(v.begin(), v.end(), back_inserter(positivesVec), [](int x) {return x != 0;});
  vector<int> stretchedVec;
  for (int i = 0; i < positivesVec.size(); i++) {
    int s = 0;
    while (s <= i) {
      stretchedVec.push_back(positivesVec[i]);
      s++;
    }
  } 
  return stretchedVec;
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
