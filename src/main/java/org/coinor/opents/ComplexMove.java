package org.coinor.opents;


/**
 * This extends the {@link org.coinor.opents.Move} interface and requires you to implement
 * a <code>public int[] attributes()</code> method that returns attributes
 * of that move. The length of the array is the number of attributes
 * you are tracking in your {@link org.coinor.opents.ComplexTabuList}.
 *
 * <p><em>This code is licensed for public use under the Common Public License version 0.5.</em><br/>
 * The Common Public License, developed by IBM and modeled after their industry-friendly IBM Public License,
 * differs from other common open source licenses in several important ways:
 * <ul>
 *  <li>You may include this software with other software that uses a different (even non-open source) license.</li>
 *  <li>You may use this software to make for-profit software.</li>
 *  <li>Your patent rights, should you generate patents, are protected.</li>
 * </ul>
 * </p>
 * <p><em>Copyright © 2003 Robert Harder</em></p>
 *
 * @author Robert Harder
 * @author rharder@usa.net
 * @see org.coinor.opents.ObjectiveFunction
 * @see org.coinor.opents.Solution
 * @version 1.0
 * @since 1.0-exp9
 */

public interface ComplexMove extends Move
{

    /**
     * Returns an array of attributes to track in the
     * {@link org.coinor.opents.ComplexTabuList}.
     *
     * @return array of attributes
     * @since 1.0-exp9
     */
    public abstract int[] attributes();


}   // end class ComplexMove