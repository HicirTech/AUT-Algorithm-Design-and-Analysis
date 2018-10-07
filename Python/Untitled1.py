def MakeGraph(graph,soreceNode):
    distance={}
    currentProcess = {}
    for node in graph:
        distance[node] = float('inf') # this will show the step 0 all 
                                # nodes are haveing infinity distance
        currentProcess[node] = None   # no node for current graph have no
                                # node have processess
    distance[soreceNode] = 0    # here is step 0, source node is 0 distandce
                                # to it self
    return distance,currentProcess

def Compare(currentNode, neighbour, graph, distance, currentProcess):
    if distance[neighbour] > distance[currentNode] + graph[currentNode][neighbour]:#compare current node distance and new node distance
        distance[neighbour]  = distance[currentNode] + graph[currentNode][neighbour]# if new distance is smaller assgin new distance to destant set
        currentProcess[neighbour] = currentNode #update current process node
        print(f"step {distance}\n") # print step
    return distance
    
def BellmanFord(graph, source):
    distance, currentProcess = MakeGraph(graph, source)# make graph matrix
    for i in range(len(graph)-1): 
        for u in graph:# run compare 
            for v in graph[u]:
               result = Compare(u, v, graph, distance, currentProcess) #update result set
    return result

def Run():
    graph = { #make graph G2
        's': {'a': 10, 'c':  3},
        'a': {'b': 2, 'd':  -3},
        'b': {'a': -1},
        'c': {'d': 3 },
        'd': {'b': 4, 'e':  1},
        'e': {'b': 4}
        }

    result = BellmanFord(graph, 's')
    print(f'final result {result}')   

if __name__ == '__main__': Run()# runable 

