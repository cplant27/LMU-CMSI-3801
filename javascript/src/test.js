import { powers } from "./exercises.js";

console.log("TEST");
console.log(typeof powers);

// console.log(powers(2, 80));

console.log(
  powers(2, 80, () => {
    console.log("CALLBACK CALLED");
  })
);
