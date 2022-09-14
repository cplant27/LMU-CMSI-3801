function powers(base, limit){

    value = 0;

    currPower = 0;

    while (value < limit ){

        value = base ** currPower;

        if (value > limit){
            break;
        }
        
        console.log(value);

        currPower++;

    }

}

powers(2, 70);