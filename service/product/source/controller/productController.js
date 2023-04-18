const repository = require("../product/productRepository");
const products = require("../data/products.json");

function findProduct(productId) {
    return products.find((product) => product.id === productId);
  }

const productController = {
    getAll() {
        return repository.data
      },
    get(id) {
      return findProduct(id);
    }
  };
  
  module.exports = productController;