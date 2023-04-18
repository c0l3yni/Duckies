import React, { useEffect, useState } from "react";
import { formatCurrencyFromPennies } from "../cart/cartLogic";
import {
  AspectRatio,
  Box,
  Button,
  Image,
  Skeleton,
  Stack,
  Text,
  useColorModeValue,
  Heading,
} from "@chakra-ui/react";
import "./css/productsPage.css";

function Product({ product }) {
  const [cartId, setCartId] = useState([]);
  const { id, name, price, stock } = product;
  
  useEffect(() => {
    const cartUrl = new URLSearchParams(window.location.search).get("cart-id");
    if (cartUrl === null) {
      console.log("Your cart is in another castle");
    } else {
      setCartId(cartUrl);
    }
  }, []);

  function addToCart(cartId, productId) {
    const data = {
      id: productId,
    };
    const customHeaders = {
      "Content-Type": "application/json",
    };
    const url = `http://localhost:3001/cart/${cartId}`;
    fetch(url, {
      method: "PUT",
      headers: customHeaders,
      body: JSON.stringify(data),
    }).then((response) => {
      response.json()
    });
  }

  function getButtonMessage(stock) {
    if (stock <= 0) {
      return "Out of Stock";
    } else {
      return "Add To Cart";
    }
  }

  return (
    <Stack
      className="product-card"
      data-id={id}
      spacing={{
        base: "4",
        md: "5",
      }}
    >
      <Box position="relative">
        <AspectRatio ratio={4 / 3}>
          <Image
            src={name}
            alt={name}
            draggable="true"
            fallback= {<Skeleton startColor="gray" endColor="gray"/>}
            borderRadius={{
              base: "md",
              md: "xl",
            }}
          />
        </AspectRatio>
      </Box>
      <Stack className="product" display="flex">
        <Stack spacing="1">
          <Heading
            as="h2"
            className="product-name"
            fontWeight="medium"
            color={useColorModeValue("gray.700", "gray.400")}
          >
            {name}
          </Heading>
          <Text className="product-price">
            {formatCurrencyFromPennies(price)}
          </Text>
        </Stack>
      </Stack>
      <Stack align="center">
        <Button
          isDisabled={stock<=0}
          colorScheme="yellow"
          width="full"
          className="add-to-cart"
          onClick={() => {
            addToCart(cartId, product.id);
          }}
        >
          {getButtonMessage(stock)}
        </Button>
      </Stack>
    </Stack>
  );
}

export default Product;
