package structures;

public interface Operations<T> {
    
    /**
     * Tells if the structure has zero elements.
     * @return True if the structure has zero elements, else, false.
     */
    public boolean isEmpty();
         
    /**
     * Tells if the structure has reached the maximum size.
     * @return True if the structure size equals the maximum size, else, false.
     */
    public boolean isFull();
    
    /**
     * Tells the number of elements of the structure.
     * @return An int containing the number of elements of this structure.
     */
    public int getSize();
    
    /**
     * Tells the maximum capacity of the structure.
     * @return An int containing the structure capacity.
     */
    public int getMaxSize();
    
    /**
     * Adds a value in a given position.
     * @param position The value position.
     * @param value The new position value .
     * @return True if the operation was succesful, else, false.
     */
    public boolean addValue(int position, T value);
    
    /**
     * Tells the element of a given position.
     * @param position The position to be searched.
     * @return The element of that position if valid, else, null.
     */
    public T getValueAtPosition(int position);
    
    /**
     * Searches the position of a given value.
     * @param value The value to be searched.
     * @return An int with the first position of that value, else, 0.
     */
    public int getPositionByValue(T value);
    
    /**
     * Removes an element in a given position.
     * @param position The element position.
     * @return The element removed.
     */
    public T remove(int position);
    
    /**
     * Removes an element from the structure.
     * @param value The element to be removed.
     * @return An int with the element removed position if found, else, 0.
     */
    public int remove(T value);
}
