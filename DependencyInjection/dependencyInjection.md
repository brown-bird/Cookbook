# Dependency Injection

## Partial Injection

**Problem:** You don't have all the arguments available to inject a service at application startup.

**Solution:** 

- Use assited injection with an injected provider interface implementation. 
- Use the *Builder* pattern and inject a **builder** as the dependency that can be loaded with contextual dependencies when ready.  

**Discussion**

The builder is preferrred for it's flexibility in dealing with large numbers of parameters. 

**Note:** Depending on your implementation of the builder you may have to **cleanup** or *reset* 
your builder's fields  to ensure that a failed or past build doesn't still contain stale data. 
You may find it useful to instead inject a provider that returns a new builder on each usage.

## Circular References

**Problem:** Your object graphs contain dependencies which depend on each other and are
problematic to construct at the same time. 

**Solution:** Use a proxy. Both(all) concrete implementations depend on Interfaces and
wiring is done as:

~~~java
public class CircularModule extends AbstractModule{
	
	@Override
	protected void configure(){
		bind(Host.class).to(HostImpl.class).in(Singleton.class);
		bind(Symbiote.class).to(SymbioteImpl.class).in(Singleton.class);
	}	
}
~~~

## Binding

**Problem:** A type is annotated with a scope you don't want. 

**Solution:** *(GUICE)* bind it `Scopes.NO_SCOPE`. Bind statement scoping trumps annotations.

## Injecting Sealed Code

**Problem:** You want to inject *3rd* party code or just code you cannot modify by adding annotations into your class.

**Solution(1):** Bind directly to the constructor of the class you want to inject. 

~~~java
public class SealedModule extends AbstractModule{

	@Override
	protected void configure(){
		bind(Sealed.class).toConstructor(sealedConstructor());
	}
	
	private Constructor<Sealed> sealedConstructor(){
		try {
			return Sealed.class.getConstructor(Dependency.class);
		} catch(NoSuchMethodException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
}	
~~~

**Solution(2):** Use the *Adapter* pattern and bind to an adapter which extends the sealed class. 

~~~java
public class SealedAdapter extends Sealed{
	
	@Inject
	public SealedAdapter(Dependency dep){
		super(dep);
	}
}
~~~

## Injecting Jersey Resources 

//Todo: complete
[Posible tutorial](https://sites.google.com/a/athaydes.com/renato-athaydes//posts/jersey_guice_rest_api)