package a4;

public class MinHeap implements Heap {

  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size

  // ================================================
  // constructors
  // ================================================

  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }

  public MinHeap() { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================

  public int[] getArray() { // do not change this method
    return this.elts;
  }

  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //=========================================================


  public void insert(int p) {
    if (size != max) {
      elts[size + 1] = p;
      size++;
      insert_r(p, size);
      return;
    }


  }

  private void insert_r(int p, int j) {
    int parent = j / 2;
    if (parent == 0) {
      return;
    }
    if (p < elts[parent]) {
      elts[j] = elts[parent];
      elts[parent] = p;
      insert_r(p, parent);
    }
    return;
  }


  public void delFront() {
    /*Your code here */
    if (size == 0) {
      return;
    }
    elts[1] = elts[size];
    size--;
    delFront_r(1);

  }

  private void delFront_r(int parent) {
    int ch = 2 * parent;
    while (ch <= size) {
      if (ch < size && elts[ch] > elts[ch + 1]) {
        ch++;
      }
      if (elts[parent] <= elts[ch]) {
        break;
      }
      int tmp = elts[parent];
      elts[parent] = elts[ch];
      elts[ch] = tmp;
      parent = ch;
      ch = 2 * parent;
    }
  }

  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */
    if (empty()) {
      throw new IllegalStateException("Heap is empty.");
    }
    return elts[1];
  }

  public boolean empty() {
    return size == 0;
  }

  public int size() {
    return size; //Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

  public void clear() {
    size = 0;
    for (int i = 0; i < elts.length; i++) {
      elts[i] = 0;
    }


  }

  public void build(int[] e, int ne) {
    clear();
    size = ne;
    for(int i = 0; i < ne; i++){
      elts[i+1] = e[i];
    }
    for(int i = size/2; i >= 1; i--){
      delFront_r(i);
    }
  }


  public int[] sort() {
    int[] sortedArr = new int[size];
    int i = 0;
    while(!empty()){
      sortedArr[i++] = getFront();
      delFront();
    }
    return sortedArr;
  }
  }


