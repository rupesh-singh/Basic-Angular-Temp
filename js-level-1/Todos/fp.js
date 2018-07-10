"use strict";

var myFunction = [];

var f1 = function (i) {
    var f = function () {
        console.log(i);
    }
    return f;
}

for (var i = 0; i < 2; i++) {



    myFunction.push(f1(i));

}

myFunction[0]();
myFunction[1]();
