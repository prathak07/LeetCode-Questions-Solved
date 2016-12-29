/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

*/
public class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(minHeap.size()>maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()) {
            return (double) (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else {
            return (double) maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

/*
public class MedianFinder {
    List<Integer> list = new ArrayList<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(list==null || list.size()==0) {
            list.add(num);
        }
        else {
            int j = list.size()-1;
            list.add(0);
            while(j>=0 && list.get(j)>=num) {
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,num);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(list.size()==0) {
            return -1;
        }
        else if(list.size()%2==1) {
            return list.get((list.size()-1)/2);
        }
        else {
            return (list.get((list.size()-1)/2)+list.get(((list.size()-1)/2)+1))/2.0;
        }
    }
};
*/