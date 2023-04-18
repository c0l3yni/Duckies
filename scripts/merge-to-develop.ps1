
Write-Host "This script will run deployment tests on current branch, pull develop branch (to fix any merge conflicts in current branch before merging), then checkout develop branch, run deployment tests again and merge current branch with develop"
$PSScriptRoot
$RunDeploymentTests= $PSScriptRoot+"\run_tests\RUN_ALL_TESTS.ps1"
$CurrentBranch = git branch --show-current
Write-Host ""

#RUN TESTS
$RunDeploymentTests
Write-Host ""
$Continue?= Read-Host -Prompt "Continue? (y/n)"
if('y' -ne $Continue?) {
  Write-Host "Ok, try again later. No code has been pulled or merged."
  Write-Host ""
  exit
}

#PULL ORIGIN DEVELOP TO CURRENT BRANCH
git pull origin develop
$Continue2?= Read-Host -Prompt "If there are any merge conflicts, fix now. If none, continue? (y/n)"
if('y' -ne $Continue2?) {
  Write-Host "Ok, try again later. No code has been pushed."
  Write-Host ""
  exit
}

#RUN TESTS AFTER CONFIRMING NO MERGE CONFLICTS
$RunDeploymentTests
Write-Host ""
Write-Host "Confirm that deployment tests pass"
$Continue3?= Read-Host -Prompt "Continue? (y/n)"
if('y' -ne $Continue3?) {
  Write-Host "Ok, try again later. Code has NOT been merged into develop branch."
  Write-Host ""
  exit
}
git checkout develop
git pull
git merge $CurrentBranch
git push
