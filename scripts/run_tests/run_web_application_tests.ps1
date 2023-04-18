param ($suite)

if (!$suite) {
    $suite = Read-Host "What suite would you like to test for?"
}

$loc = Get-Location

Write-Output "WEB APPLICATION TEST on suite $suite`r`n"
cd ..\..\application\web\source
$node = (Start-Process node app.js -PassThru).Id
cd ..\test
.\gradlew clean $suite
Stop-Process -Id $node

cd $loc

pause