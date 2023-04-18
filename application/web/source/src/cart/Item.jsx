import React from "react";
import { formatCurrencyFromPennies } from "./cartLogic";
import "./css/cart.css";
import { Button } from "@chakra-ui/react";

const Item = ({ item }) => {
  return (
    <div>
    <div className="item" data-id={item?.product?.id}>
      <div className="item-title-container">
          <h1 className="cart-item-name">{item?.product?.name}</h1> 
      </div>
      <div className="button-quantity-container">
        <Button
          type="button"
          className="decrement-button"
          isDisabled={item?.quantity === 0}
        >
          -
        </Button>
          <div className="count">{item?.quantity}</div>
        <Button
          type="button"
          className="increment-button"
          isDisabled={item?.quantity === item?.product?.stock}
        >
          +  
        </Button>
      </div>
      <div className="cart-item-additional-info">
        <div>
          {formatCurrencyFromPennies(item?.product?.price)}
        </div>
      </div>
    </div>
  </div>
  );
};

export default Item;
