# Sequence Diagrams

Modeling the order of interactions within a program. Describes which interactions are triggered
and when. The focus is on the order of events.  

Sequence Diagrams contain the following components:
* Participants
* Lifelines
* Messages
* Guard Conditions

#### Participants

Participants can be objects or any other part of a program.
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
	
