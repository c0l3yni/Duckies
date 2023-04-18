const router = require("express").Router();
const {find, findAll} = require("../product/productService")

router.route("/product/:id").get(find);
router.route("/product").get(findAll);


module.exports = router;