import crypto from "crypto";

import fetch from "node-fetch";
globalThis.fetch = fetch;

export function change(p1) {
  let change = [0, 0, 0, 0];

  if (p1 < 0) {
    throw new RangeError("Value cannot be negative!");
  }

  if (p1 >= 25) {
    change[0] = Math.floor(p1 / 25);
    p1 = p1 % 25;
  }

  while (p1 >= 10) {
    change[1] += 1;
    p1 = p1 - 10;
  }

  while (p1 >= 5) {
    change[2] += 1;
    p1 = p1 - 5;
  }

  change[3] = p1;

  return change;
}

export function stretched(p1) {
  p1 = p1.replace(/\s/g, "");
  //talked to julian for regular expression
  let p2 = Array.from(p1);

  p2 = p2.map((letter, index) => letter.repeat(index + 1));
  let finalWord = p2.join("");

  return finalWord;
}

export function powers(base, limit, func) {
  let pow = 0;
  let ans = 0;
  while (base ** pow <= limit) {
    ans = base ** pow;
    func(ans);
    pow++;
  }
}

export function* powersGenerator(num, max) {
  let power = 1;
  while (power <= max) {
    yield power;
    power *= num;
  }
}
//from notes

export function say(word) {
  if (word === undefined) return "";
  else
    return (say2) => {
      if (say2 === undefined) return word;
      else {
        return say(word + " " + say2);
      }
    };
}

//console.log(say("hi")());

export function makeCryptoFunctions(forKey, using, withIV) {
  crypto.createCipheriv("hex");
}

export function topTenScorers(inList) {
  let leaderboard = Object.entries(inList)
    .flatMap((teamPlayers) =>
      teamPlayers[1].map((playerArray) => [...playerArray, teamPlayers[0]])
    )
    .filter((stats) => stats[1] >= 15)
    .map((postFilter) => {
      return [postFilter[0], postFilter[2] / postFilter[1], postFilter[3]];
    })
    .map((playerStats) => {
      return {
        name: playerStats[0],
        ppg: playerStats[1],
        team: playerStats[2],
      };
    })
    .sort((a, b) => {
      return b.ppg - a.ppg;
    })
    .splice(0, 10);

  return leaderboard;
}

export async function pokemonInfo(pokemon) {
  let name = pokemon.toString();
  const response = await fetch(
    "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase()
  );
  const data = await response.json();

  return {
    id: data.id,
    name: data.name,
    weight: data.weight,
  };
}

export class Quaternion {
  constructor(a, b, c, d) {
    this.co1 = a;
    this.co2 = b;
    this.co3 = c;
    this.co4 = d;
  }

  plus(q) {
    let answer = new Quaternion(
      this.co1 + q.co1,
      this.co2 + q.co2,
      this.co3 + q.co3,
      this.co4 + q.co4
    );
    return answer;
  }

  times(q) {
    let ans1 =
      this.co1 * q.co1 - this.co2 * q.co2 - this.co3 * q.co3 - this.co4 * q.co4;
    let ans2 =
      this.co1 * q.co2 + this.co2 * q.co1 + this.co3 * q.co4 - this.co4 * q.co3;
    let ans3 =
      this.co1 * q.co3 - this.co2 * q.co4 + this.co3 * q.co1 + this.co4 * q.co2;
    let ans4 =
      this.co1 * q.co4 + this.co2 * q.co3 - this.co3 * q.co2 + this.co4 * q.co1;
    return new Quaternion(ans1, ans2, ans3, ans4);
  }

  coefficients() {
    let answer = [this.co1, this.co2, this.co3, this.co4];
    return answer;
  }
}
