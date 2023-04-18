import React from "react";
import LowInventoryCard from "./low-inventory-card/LowInventoryCard";
import { fetchProducts } from "../../data/product";
import {
  Table,
  Thead,
  Tbody,
  Tfoot,
  Tr,
  Th,
  TableContainer,
} from '@chakra-ui/react'

function LowInventoryCards() { 
  let products = fetchProducts();
  return (
<TableContainer>
  <Table variant='striped' colorScheme='telegram'>
    <Thead>
      <Tr>
        <Th>Product ID:</Th>
        <Th>Product NAME:</Th>
        <Th>Product STOCK:</Th>
      </Tr>
    </Thead>
    <Tbody id="low-inventory-cards">
      {products.map(
        (product) =>
          product.stock <= 6 && (
            <LowInventoryCard 
            key={product.id} 
            product={product} />
          )
      )}
    </Tbody>
    <Tfoot>
      <Tr>
      <Th>Product ID:</Th>
        <Th>Product NAME:</Th>
        <Th>Product STOCK:</Th>
      </Tr>
    </Tfoot>
  </Table>
</TableContainer>
  );
}

export default LowInventoryCards;
