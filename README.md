Lift - Basic FoBo Module Demo
-----------------------------

This is a Lift FoBo module demo that demonstrates the use of the FoBo Lift module. 
See the [FoBo - Lift Front-End Toolkit Module](https://github.com/karma4u101/FoBo).

Demonstration of this module demo is set up and live [here](http://www.media4u101.se/fobo-lift-template-demo/). 
The corresponding FoBo module is available [here](https://github.com/karma4u101/FoBo). 

**Note:** This was initially intended to be a basic/starter lift template with the FoBo module initiated 
but it has turned out to be more of a comprehensive demo. There are lots of basic lift starter templats out there 
and for a FoBo incdued one see below, so just fork the demo, run it and look at the code and its examples. 

It's really simple to integrate the FoBo module in any lift project but here is a basic lift starter template 
that includes the FoBo module, it is set up for twitter bootstrap usage 
[Templating-With-Twitter-Bootstrap](https://github.com/karma4u101/Templating-With-Twitter-Bootstrap).  

Improvements, contributions and suggestions are welcome!

best regards Peter Petersson 

Quick Start
-----------
Prerequisites for running this Lift example is that you have Git and Java installed and configured on the target computer.
You don't need to use it but the project also includes a Eclipse plug-in for browsing and following/working with the code, see the Scala IDE section.   
As of FoBo v0.5.0 you do no longer need fetch FoBo and do a publish-local of it as it is now available via repository and will be fetched for you via dependancys. 

1) Get the examples

	git clone git://github.com:karma4u101/FoBo-Lift-Template.git
	cd FoBo-Lift-Template

2) Update & Run Jetty

There is also a sbt.bat for windows users.

	./sbt update ~container:start

3) Launch Your Browser
	
	http://localhost:8080

Scala IDE for Eclipse
---------------------
Sbteclipse provides SBT command to create Eclipse project files

1) Usage

	project$ ./sbt
	> eclipse 

2) In eclipse do: 

	File ==> Import...
	Select General ==> Existing Project into Workspace 
	Use "Brows" to look up the project root ....

User powered basic example 
==========================
**(*)** This is a _unofficial_ Lift user powered basic assembly example which means it is a work based on the 
sound foundation of Lift, done by a developer who uses Lift for development ;), sharing it with others. 
