# Dependency Injection

* Contextual Dependencies
* Circular References
* Binding
* Injecting Sealed Code
* Injecting Jersey Resources
* Configuring Request and Session Scoping 

</br>
</br>

## Contextual Injection

**Problem:** You don't have all the arguments available to inject a service at application startup.

**Solution:**

AssistedInjection pattern with the [FactoryModuleBuilder](http://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/assistedinject/FactoryModuleBuilder.html). The gist is that you inject a guice created factory that can create the object you actually need by passing the contextual values you have only at runtime. 

**Solution:** 

- Inject a provider. Then use a setter to set contextual dependencies on the injected service. 
- Use the AssitedProvider pattern where the provider's `get` method can accept arguments. 
~~~java
public interface AssitedProvider<T, C>{
	T get(C context);
}

//implementation
public class MyAssitedProvider implements AssitedProvider<MyDependency, MyContext>{
	public MyDependency get(MyContext context){
		return new MyDependency(context);
	}
}
~~~

- Use the *Builder* pattern and inject a **builder** as the dependency that can be loaded with contextual dependencies when ready.  

**Discussion**

The builder is preferrred for it's flexibility in dealing with large numbers of parameters. 

**Note:** Depending on your implementation of the builder you may have to **cleanup** or *reset* 
your builder's fields  to ensure that a failed or past build doesn't still contain stale data. 
You may find it useful to instead inject a provider that returns a new builder on each usage.

</br>
</br>
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


</br>
</br>
## Binding

**Problem:** A type is annotated with a scope you don't want. 

**Solution:** *(GUICE)* bind it `Scopes.NO_SCOPE`. Bind statement scoping trumps annotations. `NO_SCOPE` is the default scoping wherein every injection receives it's own instance of a service.  

</br>
</br>
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

</br>
</br>
## Scope
**Note:** Concurrent requests within the same session will be injected with the same instance of a session scoped service and thus thread safety may be a concern. Likewise, request scoped services that are injected into multiple objects during the same request are also the same instance. 

### Scoping Problems

* **Scope Widening** - Injecting no scope objects into Singletons or request scoped objects into session scoped objects. 
	* **Memory leaks** - Objects that can't be garbage collected. 
	* **Concurrency issues** - Memory integrity 
* **Out of Scope Objects** - Attempting to access services before they are created or after they are disposed.


</br>
</br>
## Injecting Jersey Resources 

//Todo: complete
[Possible tutorial](https://sites.google.com/a/athaydes.com/renato-athaydes//posts/jersey_guice_rest_api)