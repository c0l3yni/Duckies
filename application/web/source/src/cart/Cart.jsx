
import React, { useEffect, useState } from "react";
import "./css/cart.css";
import "./cartLogic";
import Item from "./Item.jsx";
import {
  calculateTotal,
  formatCurrencyFromPennies,
  getEmptyMessage,
} from "./cartLogic";
import { Button } from "@chakra-ui/react";

const Cart = () => {
  const [cart, setCart] = useState();
  const [items, setItems] = useState([]);
  useEffect(() => {
    const cartId = new URLSearchParams(window.location.search).get("id");
    const url = `http://localhost:3001/cart/${cartId}`;
    fetch(url, {
      method: "GET",
    })
      .then((response) => response.json())
      .then((data) => {
        setCart(data[0]);
        setItems(data[0].items);
      });
  }, []);
  console.log(cart);
  function rendercart() {
    if (items) {
      return items.map((item) => {
        return <Item key={item.product.id} item={item} />;
      });
    } else {
      return;
    }
  }

  return (
    <div id="cart">
      <h1 className="cart-heading">Shopping Cart</h1>
     <div id="empty-message">{getEmptyMessage(items)}</div>
      <div id="items">{rendercart()}</div>
      <hr />
      <div className="cart-total-information">
        <div className="cart__total-container">
          <div className="cart-total-labels">
            <h3 className="cart-total-heading">Total:</h3>
            <h3 id="total" className="cart__total-amount">
              {formatCurrencyFromPennies(calculateTotal(items))}
            </h3>
          </div>
          <Button
            colorScheme="yellow"
            id="checkout-button"
            isDisabled={!items.length}
          >
            Checkout
          </Button>
        </div>
      </div>
    </div>
  );
};
export default Cart;


