# Git Cookbook  

## Branching
**Problem:** Switching branches  
**Solution:** `$ git checkout <branch name>`

**Problem:** Create a new branch and switch to it.  
**Solution:** `$ git checkout -b <new branch name>`


**Problem:** Create a hotfix branch from master.  
**Solution:** Stash or commit any uncommitted changes. Switch to master and create a new branch. Make and commit hotfix changes
Switch to master and merge the hotfix in.
~~~
$ git stash
$ git checkout master
$ git checkout -b hotfix
... make some hotfix changes
$ git commit -am 'committing hotfix changes'
$ git checkout master
$ git merge hotfix
~~~ 

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

