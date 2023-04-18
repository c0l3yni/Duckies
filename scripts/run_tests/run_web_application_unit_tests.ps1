$loc = Get-Location

Write-Output "WEB APPLICATION UNIT TEST on suite`n"
cd ..\..\application\web\source

npm run test_coverage

cd $loc

pause