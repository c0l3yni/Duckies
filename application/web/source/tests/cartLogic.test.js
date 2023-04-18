import {EMPTY_MESSAGE, formatCurrencyFromPennies, calculateTotal, getEmptyMessage} from "../src/cart/cartLogic.js";

const scenarios = [
  [[
    {quantity: 2, product: {price: 5}}
  ], 10],
  [[
    {quantity: 5, product: {price: 5}},
    {quantity: 5, product: {price: 10}},
    {quantity: 5, product: {price: 5}}
  ], 100],
  [[
    {quantity: 1, product: {price: 2}},
    {quantity: 1, product: {price: 10}},
    {quantity: 3, product: {price: 5}}
  ], 27]
]

test.each(scenarios)("calculateTotalTest quantity: %p and cart Id: %p", (input, expected) => {
  const actual = calculateTotal(input)
  expect(actual).toEqual(expected)
});

describe("Test currency formatting", () => {
    const cases = [[100, "$1.00"], [0, "$0.00"], [-100, "$-1.00"], [100000000, "$1000000.00"], [1, "$0.01"], [-1, "$-0.01"],];

    test.each(cases)("Given %p pennies, convert to %p", (pennies, expected) => {
        const actual = formatCurrencyFromPennies(pennies);
        expect(actual).toBe(expected);
    });
});
describe("Test empty cart message display", () => {
    test("Get Empty Message when cart is empty", () => {
        let expected = EMPTY_MESSAGE;
        const actual = getEmptyMessage(0);
        expect(actual).toBe(expected);
    });
    test("Get Empty Message when cart is not empty", () => {
        const expected = "";
        const actual = getEmptyMessage(1);
        expect(actual).toBe(expected);
    });
});
