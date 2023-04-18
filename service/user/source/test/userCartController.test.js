import userCartController from "../controllers/userCartController";

describe("Test userCartController", () => {
  test("get", () => {
    let id = "1";
    let expected =
      "{\n" +
      '    "id": "1",\n' +
      '    "items": [\n' +
      "      {\n" +
      '        "product": {\n' +
      '          "id": "1",\n' +
      '          "name": "Golden Duck",\n' +
      '          "price": 150\n' +
      "        },\n" +
      '        "quantity": 1\n' +
      "      }\n" +
      "    ]\n" +
      "  }";
    let actual = userCartController.get(id);
    expect(actual).toBe(expected);
  });
});

describe("Test userCartService", () => {
  test("put", () => {


    
    let actual = userCartController.put(id);
    expect(actual).toBe(expected);
  });
});
