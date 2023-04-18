import React, {
  useEffect,
  useState
} from "react";
import { fetchProducts } from "../data/product";
import Product from "./Product";
import { Box, SimpleGrid } from "@chakra-ui/react";

const ProductsPage = (props) => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    setProducts(fetchProducts());
  }, []);
  return (
    <Box
      id="products-page"
      maxW="7xl"
      mx="auto"
      px={{
        base: "4",
        md: "8",
        lg: "12",
      }}
      py={{
        base: "6",
        md: "8",
        lg: "12",
      }}
    >
      <SimpleGrid
        padding="30px"
        minChildWidth="320px"
        spacing="40px"
        columnGap={{ base: "4", md: "6" }}
        rowGap={{
          base: "8",
          md: "10",
        }}
        id="products-list"
      >
        {products.map((product, index) => {
          return (
            <Box key={index} item xs={12} sm={6} md={3}>
              <Product key={product.id} product={product} />
            </Box>
          );
        })}
      </SimpleGrid>
    </Box>
  );
};
export default ProductsPage;
