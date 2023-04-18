#In Progress
try {
    Write-Host 'Resetting cart JSON';
    # Invoke-Command -FilePath C:\Users\milane\duckies\service\user\source\cart\cartReset.js;
    Write-host "Getting data...."
    Set-Location ..\\service\\user\\source\\cart
    Write-Host "Resetting Data"
    node cartReset.js
    Write-Host 'Navigating back to script folder'
    Set-Location ..\\..\\..\\..\\scripts
    Write-Host "Reset complete"
}
Catch {
    Write-Host "Error resetting data"
}