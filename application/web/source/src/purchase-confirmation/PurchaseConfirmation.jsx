import React from "react";
import "./css/purchaseconfirmation.css"
import { Text, Box, Heading } from "@chakra-ui/react";

const PurchaseConfirmation = () => {
  return (
    <Box
      id="purchase-confirmation"
      textAlign="center"
      width="100vw"
      height="100vh"
      display="flex"
      flexDirection="column"
      justifyContent="center"
    >
      <Heading
        id="confirmation-message"
        display="inline-block"
        as="h1"
        size="4xl"
        bgGradient="linear(to-r, teal.400, teal.600)"
        backgroundClip="text"
      >
        Payment Successful!
      </Heading>
      <Text color={"gray.500"} mb={6}>
        Thank You For Shopping With Duckies!
      </Text>
    </Box>
  );
};

export default PurchaseConfirmation;
