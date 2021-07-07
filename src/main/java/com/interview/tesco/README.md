# Tesco Coding Problem Statement

Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
 
In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:
 
In Bakery department: From 8 to 10
In Checkout department: From 10 to 12
In Dairy department: From 14 to 19
 
Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts. This will be exposed to the colleague in different UI and help them plan their day accordingly.
 
His shift timings in this case are 8 to 12 and 14 to 19.

# Use Cases

  1. Fetch shift timings based on the department. Merge the timing if there is overlap.
  2. Throw Colleague / Employee not found exception.
  3. Throw no department associated with employee exception.
  