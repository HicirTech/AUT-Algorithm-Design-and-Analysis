package lab4;

public class Runable {

	 static heap a; 
	 static PriorityQueueUsingArray b;
	 public static void main( String[] args ) {
		
		 HeapAdd(100);
		 HeapSize();
		 HeapRemove(100);
		
		 ArrayAdd(100);
		 ArraySize();
		 ArrayRemove(100);
		 
		 HeapAdd(200);
		 HeapSize();
		 HeapRemove(200);
		
		 ArrayAdd(200);
		 ArraySize();
		 ArrayRemove(200);
		 
		 HeapAdd(300);
		 HeapSize();
		 HeapRemove(300);
		
		 ArrayAdd(300);
		 ArraySize();
		 ArrayRemove(300);
		 
		 HeapAdd(1000);
		 HeapSize();
		 HeapRemove(1000);
		
		 ArrayAdd(300);
		 ArraySize();
		 ArrayRemove(1000);
		 
		 
		 
	 }
	
	 
	 private static void HeapAdd(int size)
	 {
		 long start =System.nanoTime();
		 a = new heap(size);
		 for(int i=0;i!=size;i++)
		 {
			 a.add(new Nodes(i,i));
		 }
		 System.out.println("Heap add finish");
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + size +" elements");
		 System.out.println("Every time for add each element is "+((end-start)/size)+" nano second\n"); 
	 }
	 private static void HeapRemove(int size)
	 {
		 long start =System.nanoTime();
		 for(int i=0;i!=size;i++)
		 {
			 a.remove();
		 }
		 System.out.println("Heap remove finish");
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + size +" elements");
		 System.out.println("Every time for remove each element is "+((end-start)/size)+" nano second\n"); 
	 }
	 private static void ArrayAdd(int size)
	 {
		 
		 long start =System.nanoTime();
		 b = new PriorityQueueUsingArray(size);
		 for(int i=0;i!=size;i++)
		 {
			 b.insert(i,i);
		 }
		 System.out.println("array add finish");
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + size +" elements");
		 System.out.println("Every time for add each element is "+((end-start)/size)+" nano second\n"); 
	 }
	 private static void ArrayRemove(int size)
	 {
		 long start =System.nanoTime();
		 for(int i=0;i!=size;i++)
		 {
			 b.dequeue();
		 }
		 System.out.println("array remove finish");
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + size +" elements");
		 System.out.println("Every time for remove each element is "+((end-start)/size)+" nano second\n"); 
	 }
	 private static void HeapSize()
	 {
		 long start =System.nanoTime();
		 a.findLast();
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + 	 a.findLast() +" elements");
		 System.out.println("Every time for remove each element is "+((end-start)/ a.findLast())+" nano second\n"); 
	 }
	 private static void ArraySize()
	 {
		 long start =System.nanoTime();
		 b.findLast();
		 long end = System.nanoTime();
		 System.out.println("used time "+(end-start)+" nano second for " + 	 b.findLast() +" elements");
		 System.out.println("Every time for remove each element is "+((end-start)/ b.findLast())+" nano second\n"); 
	 }
}
