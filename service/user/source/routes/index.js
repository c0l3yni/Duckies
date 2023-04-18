const router = require("express").Router();
const routes = require("./userCartRoutes");

router.use("/cart", routes);

module.exports = router;