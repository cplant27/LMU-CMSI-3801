function* powersGenerator(min, max) {
  let power = 1;
  while (power <= max) {
    yield power;
    power *= min;
  }
}

function say(word) {
  let print = last + word ?? word;

  console.log(print);

  console.log(print);
}

function makeCryptoKey(forKey, using, withIV) {
  crypto.createCipheriv(hex);
}

function topTenScorers(inList) {
  let teamsList = Object.entries(inList);
  let leaderboard = [];

  for (const teamPlayer in teamsList) {
    for (const stats in teamPlayer) {
      if (stats[2][1] >= 15) {
        if (
          leaderboard.length() === 0 ||
          stats[2][2] / stats[2][1] > leaderboard[-1].ppg
        ) {
          leaderboard += {
            name: stats[2][0],
            ppg: stats[2][2] / stats[2][1],
            team: stats[1],
          };
          points.sort(function (a, b) {
            return a.ppg - b.ppg;
          });
        }
      }
      if (leaderboard.length() > 10) {
        leaderboard.pop();
      }
    }
  }
  return leaderboard;
}

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

async function pokemonInfo(pokemon) {
  let name = pokemon.target.textContent.toString();
  const response = await fetch(
    "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase()
  );
  const data = await response.json();
  let pokemonId = data.Id;
  let pokemonName = name;
  let weight = data.weight;
}
//>>>>>>> 83d50717eca23a0b87907491a8a97a12de8e70b5
