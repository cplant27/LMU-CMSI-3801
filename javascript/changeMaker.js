function changeMaker(p1) {
    let change = []
    let quarters = 0;
    let dimes = 0;
    let nickles = 0;
    let pennies = 0;

    if (Math.sign(p1) === -1) {
        throw 'Value cannot be negative!'
      }

    while (p1 >= 25) {
        quarters = quarters + 1;
        p1 = p1 - 25;
      }

    change[0] = quarters + " quarter(s)";

    while (p1 >= 10) {
        dimes = dimes + 1;
        p1 = p1 - 10;
      }
    
    change[1] = dimes + " dime(s)";

    while (p1 >= 5) {
        nickles = nickles + 1;
        p1 = p1 - 5;
    }

    change[2] = nickles + " nickle(s)";

    pennies = p1;
    
    change[3] = pennies + " penny(s)";

      console.log(change)

      return true;
  }

  changeMaker(52);