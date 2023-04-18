const userCartController = require("../controllers/userCartController");
const CONTENT = "Content-Type";
const TYPE = "application/json";

const userCartService = {
    findAll(res) {
        res.header(CONTENT, TYPE);
        const carts = userCartController.getAll();
        if (!carts) {
            res.status(404).send("Carts not found");
            return;
        }
        res.json([carts]);
    },
    find(req, res) {
        res.header(CONTENT, TYPE);
        const cart = userCartController.get(req.params.id);
        if (!cart) {
            res.status(404).send("Cart not found");
            return;
        }
        res.json([cart]);
    },
    update(req, res) {
        res.header(CONTENT, TYPE);
        const cartId = req.params.id;
        const productId = req.body.id;

        const updatedCart = userCartController.addCart(cartId, productId);
        res.json([updatedCart]);
    }

};

module.exports = userCartService;