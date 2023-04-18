import React from "react";
import "./css/invalid.css"
import { Box, Heading, Text } from "@chakra-ui/react";
const Invalid = () => {
  return (
    <Box
      textAlign="center"
      width="100vw"
      height="100vh"
      display="flex"
      flexDirection="column"
      justifyContent="center"
      id="invalid-url"
    >
      <Heading
        display="inline-block"
        as="h1"
        size="4xl"
        bgGradient="linear(to-r, teal.400, teal.600)"
        backgroundClip="text"
      >
        404
      </Heading>
      <Text fontSize="18px" mt={3} mb={2} id="not-found">
        Sorry, page not found!
      </Text>
      <Text color={"gray.500"} mb={6}>
        The page you're looking for does not seem to exist
      </Text>
    </Box>
  );
};

export default Invalid;
