const router = require("express").Router();
const {find, update} = require("../cart/userCartService")

router.route("/:id").get(find);
router.route("/:id").put(update);

module.exports = router;