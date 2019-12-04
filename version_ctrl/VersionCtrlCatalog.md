# Git Cookbook

<br/></br>
## Branching
**Problem:** Switching branches  

**Solution:** `$ git checkout <branch name>`


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
