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

export function powers(base, limit) {
  value = 0;
  currPower = 0;

  while (value < limit) {
    value = base ** currPower;

    if (value > limit) {
      break;
    }

    console.log(value);
    currPower++;
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
  if (word === undefined) return phrase;
  else
    (phrase) => {
      if (phrase === undefined) return word;
      else phrase + word;
    };
  say(phrase);
}

function say2(func) {
  return function curried(...args) {
    if (args.length >= func.length) {
      return func.apply(this, args);
    } else {
      return function (...args2) {
        return curried.apply(this, args.concat(args2));
      };
    }
  };
}

say2("hello")("how")("are")("you");

export function makeCryptoFunctions(forKey, using, withIV) {
  crypto.createCipheriv(hex);
}

export function topTenScorers(inList) {
  let teamsList = Object.entries(inList);
  let leaderboard = teamsList.flatMap((teamPlayers) =>
    teamPlayers[1].map((playerArray) => [...playerArray, teamPlayers[0]])
  );
  leaderboard = leaderboard.filter((stats) => stats[1] >= 15);
  leaderboard.map((blah) => {
    blah[1] = blah[2] / blah[1];
    blah = blah.splice(2, 1);
  });
  console.log(leaderboard);
  leaderboard.sort((a, b) => {
    return a[1] - b[1];
  });
}

/*export function topTenScorers(inList) {
  let teamsList = Object.entries(inList);
  let leaderboard = [];

  for (const [ind, teamPlayers] in teamsList) {
    //console.log(`${ind}: ` + teamsList[ind][0]);
    for (const [key, val] in teamsList[ind][1]) {
      let stats = teamsList[ind][1][key];

      console.log(stats);
      if (stats[1] >= 15) {
        //console.log(`name ${typeof stats[0]}`);
        //console.log(`ppg: ${stats[2] / stats[1]}`);
        //console.log(`team: ${typeof teamsList[ind][0]}`);
        leaderboard += {
          name: String(stats[0]),
          ppg: String(stats[2] / stats[1]),
          team: String(teamsList[ind][0]),
        };
        //console.log("leaderboard[-1]" + leaderboard[0]);
        /*leaderboard.sort(function (a, b) {
          return a.ppg - b.ppg;
        });*/
/*      }
    }
    if (leaderboard.length > 10) {
      leaderboard = leaderboard.slice(0, 10);
    }
  }
  return leaderboard;
}*/

let input = {
  ATL: [
    ["Betnijah Laney", 16, 263],
    ["Courtney Williams", 14, 193],
  ],
  CHI: [
    ["Kahleah Copper", 17, 267],
    ["Allie Quigley", 17, 260],
    ["Courtney Vandersloot", 17, 225],
  ],
  CONN: [
    ["DeWanna Bonner", 16, 285],
    ["Alyssa Thomas", 16, 241],
  ],
  DAL: [
    ["Arike Ogunbowale", 16, 352],
    ["Satou Sabally", 12, 153],
  ],
  IND: [
    ["Kelsey Mitchell", 16, 280],
    ["Tiffany Mitchell", 13, 172],
    ["Candice Dupree", 16, 202],
  ],
  LA: [
    ["Nneka Ogwumike", 14, 172],
    ["Chelsea Gray", 16, 224],
    ["Candace Parker", 16, 211],
  ],
  LV: [
    ["A’ja Wilson", 15, 304],
    ["Dearica Hamby", 15, 188],
    ["Angel McCoughtry", 15, 220],
  ],
  MIN: [
    ["Napheesa Collier", 16, 262],
    ["Crystal Dangerfield", 16, 254],
  ],
  NY: [["Layshia Clarendon", 15, 188]],
  PHX: [
    ["Diana Taurasi", 13, 236],
    ["Brittney Griner", 12, 212],
    ["Skylar Diggins-Smith", 16, 261],
    ["Bria Hartley", 13, 190],
  ],
  SEA: [
    ["Breanna Stewart", 16, 317],
    ["Jewell Loyd", 16, 223],
  ],
  WSH: [
    ["Emma Meesseman", 13, 158],
    ["Ariel Atkins", 15, 212],
    ["Myisha Hines-Allen", 15, 236],
  ],
};

console.log(topTenScorers(input));
//=======

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
//>>>>>>> 83d50717eca23a0b87907491a8a97a12de8e70b5

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
