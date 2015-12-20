//File IO library for use with node and possibly jjs

var fs = require('fs');


// Read file asynchronously and return the contents as a string.
// The only thing this saves is passing the "options" object.
// Worth it?
function readFile(fileName, callBack){
    fs.readFile(fileName, {encoding: 'utf8'}, callBack);
}

function readFileTest(){

    console.log('*readFileTest*');

    var fileName = 'test/read1.txt';
    var expected = "HELLO WORLD!";
    
    readFile(fileName, function(err, data){
       if (err){
            console.log('fail: Could not open the file for reading');
       }else{
            if (data !== expected) {
                console.log('fail');
                console.log('expected=[' + expected +"]"+ "\nactual=[" + data +"]");
            }else{
                console.log('success');
            }
       }
    });
}

readFileTest();