import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./css/paymentsubmission.css";
import { formatCurrencyFromPennies } from "../cart/cartLogic";
import { VStack, Box, Button, Input, FormLabel } from "@chakra-ui/react";

const PaymentSubmission = () => {
  const [total, setTotal] = useState(0);
  const navigate = useNavigate();

  const handleSubmit = () => {
    navigate("/purchase-confirmation");
  };

  useEffect(() => {
    function getParam(name) {
      return new URLSearchParams(window.location.search).get(name);
    }

    const urlTotal = getParam("total");
    const formattedTotal = formatCurrencyFromPennies(urlTotal);
    setTotal(formattedTotal);
  }, []);

  return (
    <Box
      id="payment-submission"
      width
      display="flex"
      justifyContent="center"
      alignContent="center"
    >
      <VStack margin="auto">
        <form action="submit">
          <FormLabel> Amount </FormLabel>
          <Input
            variant="flushed"
            id="amount"
            label="amount"
            type="text"
            required
          />
          <FormLabel> Currency </FormLabel>
          <Input variant="flushed" id="currency" label="currency" type="text" />
          <FormLabel> Source </FormLabel>
          <Input
            variant="flushed"
            id="source"
            label="source"
            type="text"
            name="source"
            required
          />
          <h2>Total</h2>
          <p id="total-owed">{total}</p>
          <Button
            className="payment-submission__form-submit-button"
            id="submit"
            colorScheme="yellow"
            onClick={handleSubmit}
          >
            Submit Payment
          </Button>
        </form>
      </VStack>
    </Box>
  );
};

export default PaymentSubmission;
