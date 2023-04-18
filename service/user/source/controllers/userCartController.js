const products = require("../data/products.json");
const repository = require("../cart/userCartRepository");
const carts = repository.carts;

function findCart(cartId) {
  return carts.find((cart) => cart.id === cartId);
}
const userCartController = {
  getAll() {
    return carts;
  },

  get(id) {
    return findCart(id);
  },

  addCart(cartId, productId) {
    const productToAdd = products.find((product) => product.id === productId);
    const cartToUpdate = carts.find((cart) => cart.id === cartId);
    if (!cartToUpdate) {
      return "no id provided or no cart with that id found";
    }
    let product = { product: productToAdd, quantity: 1 };
    cartToUpdate.items.push(product);
    repository.update(carts, cartToUpdate);
    return findCart(cartId);
  }
};

module.exports = userCartController;