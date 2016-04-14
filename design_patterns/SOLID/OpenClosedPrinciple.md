# Open Closed Principle

S **O** L I D

As Ivar Jacobson said: 

	“All systems change during their life cycles. This must be borne in mind when developing systems expected to last longer than the first version.”

How can we create designs that are stable in the face of change and that will last longer than the first version? Bertrand Meyer2
 gave us guidance as long ago as 1988 when he coined the now famous open-closed principle. To paraphrase him:


SOFTWARE ENTITIES (CLASSES, MODULES, FUNCTIONS, ETC.)
SHOULD BE OPEN FOR EXTENSION, BUT CLOSED FOR
MODIFICATION.

When a single change to a program results in a cascade of changes to dependent modules, that program exhibits the undesirable attributes that we have come to associate with “bad” design. The program becomes fragile, rigid, unpredictable and unreusable. The openclosed principle attacks this in a very straightforward way. It says that you should design modules that never change. When requirements change, you extend the behavior of such modules by **adding new code, not by changing old code that already works.**