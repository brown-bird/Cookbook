# Git Version Control Cookbook

<br/></br>
## Reverting
**Problem**: Your branch is ahead of the remote by some number of commits and you want to discard all commits which are 
ahead of the remote.

**Solution**
~~~
git reset --hard origin/master
~~~



<br/></br>
## Merging
* a single revision 
* a range of revisions



<br/></br>
## Deleting
**Problem:** You have a branch you want to delete locally only, leaving the remote branch
in tact.

**Solution:**
~~~
git branch -D <branchName>
~~~