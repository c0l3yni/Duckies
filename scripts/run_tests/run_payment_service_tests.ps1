param ($suite)

if (!$suite) {
    $suite = Read-Host "What suite would you like to test for?"
}

$loc = Get-Location

Write-Output "PAYMENT SERVICE TEST on suite $suite`r`n"
cd ..\..\service\stripe\test
.\gradlew clean $suite

cd $loc

pause