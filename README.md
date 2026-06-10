# Java-Assessment
Java systems design assessment. 

Overview

You are tasked with building an Airport Logistics Network.

The system coordinates cargo transportation between colonies across multiple planets.

Cargo ships transport resources between colonies. Mission coordinators schedule shipments, allocate pilots, consume fuel, and generate transport reports.

The system must support different transport control strategies and maintain accurate operational records.

Learning Outcomes

You will be assessed on:

OOP Design
Encapsulation
Inheritance
Polymorphism
Composition
Collections (List, Map, Queue, Set)
Abstract Classes
Enums
Validation
Unit Testing
UML Documentation
Build Tools
Version Control
Software Design
Time Limit

4 Hours

Assessment Structure
Component	Weight
Implementation	60%
UML Diagram	20%
Long Questions	20%
Scoring
Coding Score = (tests passed / total tests) × 60%

UML Score = (marks earned / UML marks) × 20%

Long Question Score = (marks earned / long question marks) × 20%

Final Score = Total

Pass Mark = 70%
Project Structure
interplanetary-logistics/

src/main/java/com/logistics

model/
    Cargo.java
    Pilot.java
    Shipment.java
    Colony.java
    TransportReport.java

service/
    LogisticsControl.java
    CivilianLogistics.java
    MilitaryLogistics.java
Implementation Requirements

You will need to create enums for this assessment.

Step 1 — Cargo

Implement a class representing transported cargo.

The cargo must track:

CargoType
weight
priorityLevel

Business rules must be enforced.

The system must be capable of determining whether cargo is considered high priority.

Step 2 — Pilot

Implement a pilot capable of operating transport ships.

Each pilot has:

name
rank
flightHours
certifications

The system must prevent invalid pilot states.

Pilots participate in shipment operations.

Step 3 — Shipment

A shipment represents cargo movement between colonies.

Each shipment should maintain:

shipmentId
origin
destination
assignedPilots
cargoManifest
status
riskLevel

The shipment must support:

Pilot assignment
Cargo assignment
Status updates
Risk calculation

Design decisions are intentionally left to you.

Step 4 — Colony

Represents a planetary colony.

A colony maintains:

name
population
cargoInventory
shipmentHistory

The colony should support:

Inventory management
Shipment tracking
Report storage
Step 5 — TransportReport

Represents the result of a completed shipment.

Must record:

shipment
success
timestamp
notes
Step 6 — LogisticsControl (Abstract)

Create an abstract logistics controller responsible for shipment processing.

The controller manages:

colony
pending shipments
completed reports

The processing workflow must:

Validate shipment readiness
Verify pilot assignment
Verify cargo availability
Execute transport
Update shipment state
Produce report

Some behaviour must be delegated to subclasses.

Step 7 — CivilianLogistics

Specialized logistics controller.

Must implement transport execution according to civilian regulations.

Step 8 — MilitaryLogistics

Specialized logistics controller.

Must implement transport execution according to military regulations.

UML Diagram

Create a UML Class Diagram using draw.io.

Requirements:

Include
Classes
Enums
Access modifiers
Constructors
Methods
Multiplicity
Associations
Composition
Inheritance
Additional Requirement

For every relationship:

You must specify:

1
0..1
0..*
1..*

where appropriate.

Missing multiplicities will result in marks being deducted.

Export:

uml.pdf
Long Questions (20 Marks)
Question 1 — Encapsulation (4)

Explain how encapsulation improves maintainability in large systems.

Provide an example from your solution.

Question 2 — Defensive Copying (3)

Explain:

return new ArrayList<>(items);

Why is this often preferable to:

return items;
Question 3 — Inheritance vs Composition (3)

Consider the relationship between:

Shipment
Pilot
Cargo

Explain where composition should be preferred over inheritance and why.

Question 4 — Build Tools (Maven) (4)

Answer all of the following:

A

What problem does Maven solve?

B

What is the purpose of:

<dependency>

inside a pom.xml?

C

What does the command below do?

mvn clean compile test
D

What is the difference between:

mvn compile

and

mvn package
Question 5 — Version Control (Git) (6)

Answer all of the following:

A

What problem does Git solve in software development?

B

Explain the difference between:

git add .

and

git commit -m "message"
C

A teammate accidentally breaks the project after merging a feature branch.

Describe one Git-based strategy for recovering from this situation.

D

Why are branches useful in a team environment?

Design Question (Bonus 10 Marks)

You discover that additional transport types will be added:

MedicalLogistics
MiningLogistics
EmergencyLogistics
ScientificLogistics

Describe how your design can accommodate these new types without modifying existing code.

Reference:

Open/Closed Principle
Polymorphism
Abstract Classes
