#Optional Type 
*Java 8*

It is important to note that the intention of the Optional class is not to replace every single null reference. **Instead, its purpose is to help design more-comprehensible APIs so that by just reading the signature of a method, you can tell whether you can expect an optional value.** This forces you to actively unwrap an Optional to deal with the absence of a value.


## Creating Optional Objects

An Empty Optional

	Optional<SoundCard> SoundCard = Optional.empty();
	
An Optional with a non-null value. Throws a NullPointerException if soundCard is null.

	SoundCard soundCard = new SoundCard();
	Optional<SoundCard> sc = Optional.of(soundCard);	
	
## Do Something if the Value is present

## Default values if optional is not present	