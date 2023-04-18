const fs = require("fs");
const path = "./data/carts.json";

const cartsString = fs.readFileSync(path, "utf8", (err, data) => {
  if (err) {
    throw "failed to read from carts.json";
  }
  return data;
});

const carts = JSON.parse(cartsString);

function update(updatedCart) {
  carts.map((cart) => {
    if (cart.id != updatedCart.id) {
      cart = updatedCart;
    } else if (cart.id === updatedCart.id) {
      carts.push(cart);
    }
    fs.writeFile(path, JSON.stringify(carts, null, 2), (err) => {
      if (err) {
        throw "failed to write to json";
      }
    });
  });
}

module.exports = { carts, update };