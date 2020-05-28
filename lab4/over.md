### Override vs Overload

Method overload occurs when the same method name but different method parameter appears in the same
class. The compiler would know which method to invoke based on the different parameters.

Overriding means two methods in different classes, have the same method signature. 
Overrding allows a child class to provide it's own implementation of the method
Method overriding is also a  run time polymorphism because the overriding happens during
run time.  The return type for this method has to be the same, or co-variant - meaning it
has to be a subtype of the original return type.