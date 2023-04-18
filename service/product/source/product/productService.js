const productController = require("../controller/productController");
const CONTENT = "Content-Type";
const TYPE = "application/json";

const productService = {
    findAll(req, res) {
        res.header(CONTENT, TYPE);
        const products = productController.getAll();
        if (!carts) {
            res.status(404).send("Products not found");
            return;
        }
        res.json([products]);
    },

    find(req, res) {
        res.header(CONTENT, TYPE);
        const product = productController.get(req.params.id);
        if (!product) {
            res.status(404).send("Product not found");
            return;
        }
        res.json([product]);
    }
};
module.exports = productService;