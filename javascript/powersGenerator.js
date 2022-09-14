function* powersGenerator(base, limit){

    value = 0;

    currPower = 0;

    while (value < limit ){

        value = base ** currPower;

        if (value > limit){
            break;
        }
        
        yield console.log("value: " + value );

        currPower++;

    }

}

const p = powersGenerator(2,7);

p.next();
p.next();
p.next();
