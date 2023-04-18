import React from "react";
import { Route, Routes } from "react-router-dom";
import AdminDashboard from "./admin-dashboard/AdminDashboard";
import Cart from "./cart/Cart";
import HighOrderBoundary from "./error/ErrorBoundary";
import Invalid from "./invalid/Invalid";
import PaymentSubmission from "./payment-submission/PaymentSubmission";
import ProductsPage from "./products-page/ProductsPage";
import PurchaseConfirmation from "./purchase-confirmation/PurchaseConfirmation";
import ErrorView from "./error/ErrorView";
import LowInventory from "./low-inventory/LowInventory";

function App() {
  return (
        <Routes>
          <Route path="/admin-dashboard" element={<AdminDashboard />}/>
          <Route path="/cart" element={<Cart />} />
          <Route path="/payment-submission" element={<PaymentSubmission />} />
          <Route path="/products" element={<ProductsPage />} />
          <Route path="/error" element={<ErrorView />} />
          <Route path="/purchase-confirmation" element={<PurchaseConfirmation />} />
          <Route path="/low-inventory" element={<LowInventory />} />
          <Route path="*" element={<Invalid />} />
        </Routes>
  );
}

export default HighOrderBoundary(App);