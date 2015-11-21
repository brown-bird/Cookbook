# Sequence Diagrams

Modeling the order of interactions within a program. Describes which interactions are triggered
and when. The focus is on the order of events.  

Sequence Diagrams contain the following components:
* Participants
* Lifelines
* Messages
* Guard Conditions

#### Participants

Participants can be objects or any other part of a program. Interactions between participants are 
denoted with lines drawn between the lifelines.
Participants can be listed across the top of the diagram or as they are created.

Participant format:

	// format
	participantName:participantType
	
	//example
	theCustomer:Customer

#### Message Signature

	// format
	attribute=messageName(argument1:argumentClass):returnType
	
	//example
	validCard=atmCardInserted(card:ATMCard):Boolean

Synchronous messages use a filled in arrow head. Asynchronous messages use an open arrow head.

#### Sequence Fragments

Sequence Fragments are sometimes used to identify optional bits of logic. They can utilize a
guard condtion like so: `[bacon.isChunky() && myStomach.isEmpty()]` 



