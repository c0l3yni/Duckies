import React, { useEffect, useState } from "react";
import "./css/adminDashboard.css";
import { Heading, Box, Text } from "@chakra-ui/react";

const AdminDashboard = () => {
  const [failurePercentString, setFailurePercentString] = useState(0);
  useEffect(() => {
    const failurePercent = new URLSearchParams(window.location.search).get(
      "percent"
    );

    if (failurePercent === null) {
      setFailurePercentString("0");
    } else {
      setFailurePercentString(failurePercent);
    }
  }, []);

  return (
    <div id="admin-dashboard">
      <Heading className="admin-dashboard__header">
        <Box container alignItems="center" spacing={1}>
          <Box item xs>
            <Text id="title" color="inherit" variant="h5" component="h1">
              Admin Dashboard
            </Text>
          </Box>
        </Box>
      </Heading>
      <Box
        id="failure-report"
        sx={{ maxWidth: 936, margin: "auto", overflow: "hidden" }}
      >
        <Text variant="h5">Login Failures:</Text>
        <Text id="failure-percentage">{failurePercentString}%</Text>
      </Box>
    </div>
  );
};

export default AdminDashboard;
