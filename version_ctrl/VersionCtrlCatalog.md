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
## Branch Management
**Problem:** Show listing of current branches.  
**Solution:** run `$ git branch` with no arguments.

**Problem:** Show listing of branches you have currently merged into the branch you are on.  
**Solution:** run `$ git branch --merged`. To See branches merged into a target branch run `$ git branch --merged <target branch name>`.
Use the `--no-merged` option to see branches not yet merged.   

**Problem:**  See the last commit on each branch. 
**Solution:** `$ git branch -v`

<br/></br>
## Reverting
**Problem**: Your branch is ahead of the remote by some number of commits and you want to discard all commits which are 
ahead of the remote.  
**Solution:** `$ git reset --hard origin/<branch name>`



<br/></br>
## Merging
Todo:
* a single revision 
* a range of revisions  

**Problem:** update branch from master  
**Solution:** From the feature branch you want to update run: `$ git merge master`

<br/></br>
## Merge Conflicts
**Problem:** You want to see unmerged files after notification of a merge conflict.  
**Solution:** `$ git status`  

**Problem:** Mark a previously conflicted file as resolved.  
**Solution:** `$ git add <resolvedFileName>`  

**Problem:** Run a specific mergetool from the command line.  
**Solution:** `$ git mergetool -t tortoisemerge` will run tortoise merge on every file that has a conflict.

**Problem:** Finalizing merge resolution.  
**Solution:** After staging all your resolved conflicts with `$ git add <resolved confict file name>` finalize your merge with
`$ git commit`. 

<br/></br>
## Deleting
**Problem:** You have a branch you want to delete locally only, leaving the remote branch
in tact.  
**Solution:** `$ git branch -d <branch name>`. Use the `-D` option instead of `-d` if you need to force the deletion, say 
when you have commits on the branch that aren't merged.  




<br/></br>
## History
**Problem:** View commit history.  
**Solution:** `$ git log`  

**Problem:** View commit history for branch including divergent commits as text based graph.  
**Solution:** `$ git log --oneline --decorate --graph --all`  

