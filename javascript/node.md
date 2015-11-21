# Node / NPM

### Setup

**Problem:** Download and install your project's dependencies in the local `node_modules` folder

**Solution:** Run: `npm install` from the root of your project directory.

## Getting Information

**Problem:** You want to view registry information for an package.

**Solution:** `npm view [package]` 

**Discussion:** `npm view` is used to get all sorts of information regarding packages. [npm-registry](https://docs.npmjs.com/misc/registry)

---

**Problem:** You want to view the dependencies for a package.

**Solution:** run `npm view myPackage@1.0.2 dependencies` where *myPackage* = the name of the package to view and 1.0.2 is the version of the package you want to view dependencies for. **Note:** the version number is optional. 