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
     * Tells the maximum capacity of the structure, if a sequential list, else, it's current size.
     * @return An int containing the structure capacity (or size).
     */
    public int getMaxSize();
    
    /**
     * Checks if a given position is valid or not.
     * @param position The position to be checked.
     * @return True if the position is valid, else, false.
     */
    public boolean isValidPosition(int position);
    
    /**
     * Adds a value in a given position.
     * @param position The value position.
     * @param value The new position value .
     * @return True if the operation was succesful, else, false.
     * @throws java.lang.Exception If the position is invalid or the list if full (for Sequential List types)
     */
    public boolean addValue(int position, T value) throws Exception;
    
    /**
     * Tells the element of a given position.
     * @param position The position to be searched.
     * @return The element of that position if valid, else, null.
     * @throws java.lang.Exception If the position is invalid.
     */
    public T getValueAtPosition(int position) throws Exception;
    
    /**
     * Searches the position of a given value.
     * @param value The value to be searched.
     * @return An int with the first position of that value, else, 0.
     * @throws java.lang.Exception If the value is not found.
     */
    public int getPositionByValue(T value) throws Exception;
    
    /**
     * Change the value at a given position.
     * @param position The position to be modified.
     * @param newValue The position new value.
     * @return True if the operation was succesful, else, false.
     */
    public boolean setValueAtPosition(int position, T newValue);
    
    /**
     * Removes an element in a given position.
     * @param position The element position.
     * @return The element removed.
     * @throws java.lang.Exception If the position is invalid.
     */
    public T remove(int position) throws Exception;
    
    /**
     * Removes an element from the structure.
     * @param value The element to be removed.
     * @return An int with the element removed position if found, else, 0.
     * @throws java.lang.Exception If the position is invalid.
     */
    public int remove(T value) throws Exception;
}
