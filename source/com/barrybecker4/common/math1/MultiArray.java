/** Copyright by Barry G. Becker, 2000-2011. Licensed under MIT License: http://www.opensource.org/licenses/MIT  */
package com.barrybecker4.common.math1;

import java.util.Arrays;

/**
 * Provide support for high dimensional arrays of doubles.
 * Eventually this class should support multi-dimensional arrays of any type, but
 * for now it only supports doubles.
 * Use this class when you need to create an arbitrarily sized array of &gt; 1 dimension.
 *
 * @author Barry Becker
 */
public class MultiArray {

    /** handles converting from a raw index into an array of indices and back. */
    private final MultiDimensionalIndexer indexer;

    /** this will hold all the data for this array class. */
    private double[] arrayData = null;

    /**
     * Constructor
     */
    public MultiArray( int[] dims ) {
        indexer = new MultiDimensionalIndexer(dims);
        long numValues = indexer.getNumValues();
        if (numValues > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "The array with dimensions " + Arrays.toString(dims) + " cannot have more values than "
                    + Integer.MAX_VALUE);
        }
        arrayData = new double[(int)numValues];
    }

    public int getNumValues() {
        return (int)indexer.getNumValues();
    }

    /**
     * Specify a tuple to get a particular value.
     * @param index an integer index array of size numDims specifying a location in the data array.
     * @return array value.
     */
    public double get( int[] index ) {
        return arrayData[indexer.getRawIndex(index)];
    }

    /**
     * Specify a tuple to set a given value.
     * @param index location in the data array.
     * @param value to assign to that location.
     */
    public void set( int[] index, double value ) {
        arrayData[indexer.getRawIndex(index)] = value;
    }

    /**
     * specify a tuple to get a particular value.
     * see getIndexFromRaw for how we can get a multi-dim index from a single raw integer index.
     * @param rawIndex int specifying location in the multi dim array.
     */
    public double getRaw( int rawIndex ) {
        return arrayData[rawIndex];
    }
}