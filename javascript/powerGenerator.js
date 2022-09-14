function* powersGenerator(base, limit){

    while (value < limit ){

        value = base ** currPower;
        
        yield value;

        if (value > limit){
            break;
        }
        
        console.log(value);

        currPower++;

    }

}

const p = powerGenerator(2,7);

p.next();
p.next();
p.next();