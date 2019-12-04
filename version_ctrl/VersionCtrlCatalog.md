# Git Cookbook  

## Branching
**Problem:** Switching branches  
**Solution:** `$ git checkout <branch name>`

**Problem:** Create a new branch and switch to it.  
**Solution:** `$ git checkout -b <new branch name>`


<br/></br>
## Reverting
**Problem**: Your branch is ahead of the remote by some number of commits and you want to discard all commits which are 
ahead of the remote.  
**Solution:** `$ git reset --hard origin/<branch name>`



<br/></br>
## Merging
* a single revision 
* a range of revisions
* update branch from master


<br/></br>
## Deleting
**Problem:** You have a branch you want to delete locally only, leaving the remote branch
in tact.  
**Solution:** `$ git branch -D <branch name>`


<br/></br>
## History
**Problem:** View commit history.  
**Solution:** `$ git log`  

**Problem:** View commit history for branch including divergent commits as text based graph.  
**Solution:** `$ git log --oneline --decorate --graph --all`  

