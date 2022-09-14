function stretched(p1){

    numRepeats = 1;

    finalWord = "";

    for (let i = 0; i < p1.length; i++){

        if (p1.charAt(i) === " "){
            continue;
        } else {

            for(let j = 0; j < numRepeats; j++) {

                finalWord = finalWord + p1.charAt(i);

            }

        }

        numRepeats = numRepeats  + 1;

    }

    console.log(finalWord);

    return (finalWord);

}

stretched('ABCDEF');