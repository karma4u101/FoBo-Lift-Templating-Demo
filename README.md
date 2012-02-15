FoBo - Lift Template
--------------------

This is a stipped down Lift template / FoBo demo for use with/of the FoBo Lift module. 
See the [FoBo - Lift Front-End Toolkit Module](https://github.com/karma4u101/FoBo).

Live demo of this lift template with the [FoBo](https://github.com/karma4u101/FoBo) module is available 
[here](http://www.media4u101.se/fobo-lift-template-demo/).

Improvements, contributions and suggestions are welcome!

best regards Peter Petersson 

Quick Start
-----------
Prerequisites for running this Lift example is that you have the FoBo module, Git and Java installed and configured on the target computer.
You don't need to use it but the project also includes a Eclipse plug-in for browsing and following/working with the code, see the Scala IDE section.   

1) Get the examples

	git clone git@github.com:karma4u101/FoBo-Lift-Template.git
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
sound foundation of Lift and done by a developer who uses Lift for development ;), sharing it with others. 