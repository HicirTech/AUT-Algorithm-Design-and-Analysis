import collections

import SpiderLeg

def OriginalStart(url, deep):
    seen = set() # a set of seen the url, will not this at next recution
    seenWithLevel=set() 
    queue = collections.deque() # Queue use for BFS, at start, it has a root( the url taken into the fuction in it
    queueWithLevel = collections.deque()


    leveledUtl = (url,0)
    queue.append(leveledUtl[0])# put the root node into the queue
    queueWithLevel.append(leveledUtl)

    seen.add(leveledUtl) # add the begin root has been seen
    seenWithLevel.add(leveledUtl)

    while(queue): # while the queue is not empty, we keep do bfs
      
        working = queueWithLevel.popleft()
        currentLevel = working[1]
        current = queue.popleft() # the left node will be pop to process its childrens

        childrens = SpiderLeg.getHyperLink(current) # a set of childrens 

        for link in childrens:
            if((link not in seen) & (link not in queue)):
                queue.append(link) # if the child haven't been discover, then put children in queue, also the node
                                    # the node should not in the queue already, so that we will not go into odd cycle
                currentLinkWithLevel = (url,currentLevel+1)
                queueWithLevel.append(currentLinkWithLevel)
        seen.add(current)# once the node add all its child, then it will stop 
        seenWithLevel.add(working)
        #print(f"Seen:{seen})
        print(f"Processed: {current}")
        print(queueWithLevel)


if __name__ == '__main__':
    OriginalStart('http://ashuyun.tk/WP/',1)