param ($suite)

if (!$suite) {
    $suite = Read-Host "What suite would you like to test for?"
}

Start-Process powershell -ArgumentList "-File run_payment_service_tests.ps1 $suite"
Start-Process powershell -ArgumentList "-File run_web_application_tests.ps1 $suite"
Start-Process powershell -ArgumentList "-File run_web_application_unit_tests.ps1"