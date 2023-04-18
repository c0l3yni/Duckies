import React from "react";
import {
  Tr,
  Td
} from '@chakra-ui/react'

function LowInventoryCard({ product }) {
  return (
    <Tr className="low-inventory-card">
    <Td className="inventory-id">{product.id}</Td>
    <Td className="product-name">{product.name}</Td>
    <Td className="inventory">{product.stock}</Td>
  </Tr>
  );
}

export default LowInventoryCard;
