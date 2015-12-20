var fs = require('fs');
var fileName = process.argv[2];

if (fileName == undefined) {
    console.log("error: missing a file name");
    process.exit();
}

var contents = fs.readFileSync(fileName, "utf8");

console.log(contents ? contents : "some poo poo happened :( ");
console.log(contents);