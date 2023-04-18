Write-Host "This script will provide prompt to MANUALLY run deployment tests on current branch, pull develop branch (to fix any merge conflicts in current branch before merging), then checkout develop branch, prompt to MANUALLY run deployment tests again and merge current branch with develop"
$PSScriptRoot
$RunDeploymentTests= $PSScriptRoot+"\deployment-tests.ps1"
$CurrentBranch = git branch --show-current
Write-Host ""

#PROMT TO MANUALLY RUN TESTS
Write-Host "Run deployment tests & continue when ready."
$Continue?= Read-Host -Prompt "Continue? (y/n)"
if('y' -ne $Continue?) {
  Write-Host "Ok, try again later. No code has been pulled or merged."
  Write-Host ""
  exit
}

#PULL ORIGIN DEVELOP TO CURRENT BRANCH & PROMPT TO RUN TESTS AGAIN
git pull origin develop
$Continue2?= Read-Host -Prompt "If there are any merge conflicts, fix now. Then run deployment tests again. If ready, continue? (y/n)"
if('y' -ne $Continue2?) {
  Write-Host "Ok, try again later. No code has been pushed."
  Write-Host ""
  exit
}

git checkout develop
git pull
git merge $CurrentBranch
git push
