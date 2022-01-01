# Graphs


src/com/company/Main.java contains my implementation of DFS and BFS.
 
For DFS, the graph is fully explored by an iteration node until no adjacent nodes are found. If this is the case, the iterator backtracks until it reaches the node which
contains an explored adjacent node. If no adjacent nodes are found, then the iteration is done.
 
For BFS, the adjacent nodes of the source are found and then the adjacent nodes of those adjacent nodes are found.
 
DFS uses a stack since backtracking is used while BFS uses a queue where the first item out is one of the adjacent nodes are adjacent to the source
 
The time complexities for both are O(V+E) where V = vertices and E = edges. This is due to the fact that the iterator must iterate through all nodes as well as grab
adjacent nodes (edges)

operations:

print_DFS -> prints all vertices using Depth first search

print_BFS -> pritns all vertices using Breadth first search

add_edge -> add edge in graph between two specified vertices 

