const EMPTY_MESSAGE = "There are currently no items in your cart. Bummer.";

function formatCurrencyFromPennies(total) {
  const penniesToDollars = (total / 100).toFixed(2);
  return `$${penniesToDollars}`;
}

function getEmptyMessage(items) {
  return items.length === 0 ? "There are currently no items in your cart. Bummer." : "";
}

function calculateTotal(items) {
  let currentTotal = 0;
  if (!items) {
    return 0;
  }

  items.forEach((item) => {
    currentTotal += item.product.price * item.quantity;
  });

  return currentTotal;
}

function getCart(cart) {
  return cart.id;
}

module.exports = {
  formatCurrencyFromPennies,
  getEmptyMessage,
  EMPTY_MESSAGE,
  calculateTotal,
  getCart,
};
