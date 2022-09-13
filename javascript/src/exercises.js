function* powersGenerator(min, max) {
  let power = 1
  while (power <= max) {
    yield power
    power *= min
  }
}

function say(word){

    let print = (last + word ?? word)




    console.log (print)

}

function makeCryptoKey(forKey, using, withIV){
    crypto.createCipheriv(hex, );

}

function topTenScorers(team){
    let playersList = Object.entries(team);
    let leaderboard = [];

    for (; i < playersList.length(); i++){
        if (totalGames >= 15){
            if (currentPoints > last.ppg){
                add to leaderboard
                sort leaderboard
            }

        }
        if (leaderboard.length > 10){
            leaderboard.length() = 10;
        }
    }
}

async function pokemonInfo(pokemon) {
  let name = pokemon.target.textContent.toString()
  const response = await fetch('https://pokeapi.co/api/v2/pokemon/' + name.toLowerCase())
  const data = await response.json()
  let pokemonId = data.Id
  let pokemonName = name
  let weight = data.weight
}
