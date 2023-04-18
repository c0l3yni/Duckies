const fs = require("fs");
const path = "./data/products.json";

const productsString = fs.readFileSync(path, "utf8", (err, data) => {
  if (err) {
    throw "failed to read from carts.json";
  }
  return data;
});

module.exports = productsString;