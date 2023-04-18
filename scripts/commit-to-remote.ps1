$CurrentBranch = git branch --show-current
git status
Write-Host "This script will add all, commit, and push branch "$CurrentBranch "to remote location"
Write-Host ""
$Continue?= Read-Host -Prompt "Continue? (y/n)"
if('y' -ne $Continue?) {
  Write-Host "Ok, try again later. Nothing has been staged."
  Write-Host ""
  exit
}

git add ..\..\..\
git status
Write-Host ""
$Ready?= Read-Host -Prompt "All good, ready to commit? (y/n)"
if('y' -ne $Ready?) {
  Write-Host "Code has NOT been committed!"
  Write-Host ""
  exit
}

$CommitMessage= Read-Host -Prompt "Enter commit message (no quotes)"
git commit -m $CommitMessage

Write-Host ""
$RemoteCount= ("remotes/origin"+$CurrentBranch | git branch -a).count
if(1 -eq $RemoteCount) {
  git push
} else {
  git push --set-upstream origin $CurrentBranch
}
