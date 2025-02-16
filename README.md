# Greedy-Scheduling-Algorithms

This repository contains the implementation and analysis of two greedy scheduling algorithms for distributing tasks across multiple processors: Greedy and Greedy-Decreasing. These algorithms aim to efficiently assign tasks based on their execution time to optimize the Makespan (the total time required for all processors to finish execution).

🔹 Implementation Description

  Algorithm 1: Greedy
  
  The Greedy algorithm follows these steps:
  
  Reads an input file (input.txt) containing:
  
    The number of processors.
    The number of tasks.
    A list of tasks, each with an ID and processing time.
    
  Creates a priority queue of processors, sorted by active time (total execution time of assigned tasks).
  
  For each task:
  
    Finds the processor with the minimum active time.
    Assigns the task to this processor.
    Reinserts the processor into the priority queue.
    
  Prints the state of the priority queue and the Makespan (active time of the busiest processor).
  
  Algorithm 2: Greedy-Decreasing
  
  The Greedy-Decreasing algorithm differs in one key aspect:
  
    Instead of assigning tasks in the given order, it first sorts the tasks in descending order of processing time using QuickSort.
    Then, it follows the same assignment process as the Greedy algorithm.
    This strategy improves the Makespan by prioritizing longer tasks.
    
  🔹 Experimental Analysis & Comparison
  We generated 30 input files, each containing a different number of tasks (100, 225, 529). The number of processors was computed as the square root of the number of tasks. Task execution times were generated randomly using Java's Random class.
  
  For each file, both the Greedy and Greedy-Decreasing algorithms were executed via the Comparisons class, which computes and prints the Makespan for both approaches.
  
  📊 Results:
  
  Tasks      	Greedy (Avg. Makespan)      	Greedy-Decreasing (Avg. Makespan)
   100	            541.5	                               456.7
   225	            797.5	                               756.7
   529	            1196	                               1148.6
   
  The results show that Greedy-Decreasing performs better, especially when task execution times vary significantly. The difference decreases as the number of tasks increases, but this is not always the case.

  🚀 Execution Instructions
  The program can be executed either via command line or Eclipse:
  
  To run the Greedy algorithm:
    java Greedy Data\input.txt
    
  To run the Greedy-Decreasing algorithm:
    java SortGreedy Data\input.txt
  
  To compare both algorithms:
    java Comparisons Data\input.txt

    
  📂 Repository Structure

  📁 GreedyScheduling  
   ├── 📁 src  
   │   ├── Greedy.java          # Implementation of the Greedy algorithm  
   │   ├── SortGreedy.java      # Implementation of the Greedy-Decreasing algorithm  
   │   ├── Comparisons.java     # Runs and compares both algorithms  
   │   ├── Processor.java       # Processor class  
   │   ├── Task.java            # Task class  
   │   ├── Sort.java            # QuickSort implementation  
   │   ├── PriorityQueue.java   # Priority queue implementation  
   ├── 📁 Data                  # Folder containing input txt files  
   ├── README.md                # Project description  
   
  📌 Conclusion
  The Greedy-Decreasing algorithm outperforms the standard Greedy approach, particularly when task execution times have high variance. This study highlights how initial sorting can significantly improve       scheduling performance.
